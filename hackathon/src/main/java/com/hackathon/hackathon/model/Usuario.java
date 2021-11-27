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
@Table(name = "tb_usuario")
@Component
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	private String nome;
	private String nomeSocial;
	private String apelido;
	private String email;
	private String senha;
	private String avatar;
	private String orientacaoSex;
	private int idade;

	@OneToMany(mappedBy = "usuario")
	private List<Post> post;

	@OneToMany(mappedBy = "usuario")
	private List<Vagas> vagas;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public Usuario() {
		super();
	}

	public Usuario(Long id_usuario, String nome, String nomeSocial, String apelido, String email, String senha,
			String avatar, String orientacaoSex, int idade, List<Post> post, List<Vagas> vagas, Date data) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.apelido = apelido;
		this.email = email;
		this.senha = senha;
		this.avatar = avatar;
		this.orientacaoSex = orientacaoSex;
		this.idade = idade;
		this.post = post;
		this.vagas = vagas;
		this.data = data;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getOrientacaoSex() {
		return orientacaoSex;
	}

	public void setOrientacaoSex(String orientacaoSex) {
		this.orientacaoSex = orientacaoSex;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public List<Vagas> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vagas> vagas) {
		this.vagas = vagas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}