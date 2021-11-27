package com.hackathon.hackathon.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private Long pontuacao;

	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Avaliacao avaliacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public Empresa() {
		super();
	}

	public Empresa(Long id_empresa, String razãoSocial, String endereco, Long pontuacao, Avaliacao avaliacao,
			Date data) {
		super();
		this.id_empresa = id_empresa;
		this.razãoSocial = razãoSocial;
		this.endereco = endereco;
		this.pontuacao = pontuacao;
		this.avaliacao = avaliacao;
		this.data = data;
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

	public Long getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Long pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
