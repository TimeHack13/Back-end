package com.hackathon.hackathon.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "tb_vagas")
@Component
public class Vagas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_vagas;

	private String titulo;
	private String descricao;
	private String salario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Usuario usuario;

	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Vagas vagas;

	public Vagas() {
		super();
	}

	public Vagas(Long id_vagas, String titulo, String descricao, String salario, Date data, Usuario usuario,
			Vagas vagas) {
		super();
		this.id_vagas = id_vagas;
		this.titulo = titulo;
		this.descricao = descricao;
		this.salario = salario;
		this.data = data;
		this.usuario = usuario;
		this.vagas = vagas;
	}

	public Long getId_vagas() {
		return id_vagas;
	}

	public void setId_vagas(Long id_vagas) {
		this.id_vagas = id_vagas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vagas getVagas() {
		return vagas;
	}

	public void setVagas(Vagas vagas) {
		this.vagas = vagas;
	}

}
