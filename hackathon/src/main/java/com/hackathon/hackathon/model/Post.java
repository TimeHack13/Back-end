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
@Table(name = "tb_post")
@Component
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_post;

	private String historia;
	private int corFundo;
	private String titulo;

	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Usuario usuario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public Post() {
		super();
	}

	public Post(Long id_post, String historia, int corFundo, String titulo, Usuario usuario, Date data) {
		super();
		this.id_post = id_post;
		this.historia = historia;
		this.corFundo = corFundo;
		this.titulo = titulo;
		this.usuario = usuario;
		this.data = data;
	}

	public Long getId_post() {
		return id_post;
	}

	public void setId_post(Long id_post) {
		this.id_post = id_post;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public int getCorFundo() {
		return corFundo;
	}

	public void setCorFundo(int corFundo) {
		this.corFundo = corFundo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
