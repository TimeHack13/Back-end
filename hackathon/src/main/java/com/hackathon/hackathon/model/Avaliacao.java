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
@Table(name = "tb_post")
@Component
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_avaliacao;

	private String descricao;
	private int corFundo;
	private String titulo;

	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Usuario usuario;

	@OneToMany(mappedBy = "usuario")
	private List<Avaliacao> avaliacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public Avaliacao() {
		super();
	}

	public Avaliacao(Long id_avaliacao, String descricao, int corFundo, String titulo, Usuario usuario,
			List<Avaliacao> avaliacao, Date data) {
		super();
		this.id_avaliacao = id_avaliacao;
		this.descricao = descricao;
		this.corFundo = corFundo;
		this.titulo = titulo;
		this.usuario = usuario;
		this.avaliacao = avaliacao;
		this.data = data;
	}

	public Long getId_avaliacao() {
		return id_avaliacao;
	}

	public void setId_avaliacao(Long id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public List<Avaliacao> getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(List<Avaliacao> avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
	
}
