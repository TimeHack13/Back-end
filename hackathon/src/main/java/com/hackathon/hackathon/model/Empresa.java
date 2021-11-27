package com.hackathon.hackathon.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "tb_empresa")
@Component
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_empresa;

	private String razãoSocial;
	private String endereco;
	private String cnpj;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	@OneToMany(mappedBy = "usuario")
	private List<Vagas> vagas;

	public Empresa() {
		super();
	}

	public Empresa(Long id_empresa, String razãoSocial, String endereco, String cnpj, Date data, List<Vagas> vagas) {
		super();
		this.id_empresa = id_empresa;
		this.razãoSocial = razãoSocial;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.data = data;
		this.vagas = vagas;
	}

	public Long getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getRazãoSocial() {
		return razãoSocial;
	}

	public void setRazãoSocial(String razãoSocial) {
		this.razãoSocial = razãoSocial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Vagas> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vagas> vagas) {
		this.vagas = vagas;
	}

}
