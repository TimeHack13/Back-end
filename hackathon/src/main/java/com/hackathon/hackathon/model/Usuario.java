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

import com.hackathon.hackathon.dto.UsuarioCadastroDTO;

@Entity
@Table(name = "tb_usuario")
@Component
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;

	private String nome;
	private String email;
	private String senha;
	private String avatar;

	@OneToMany(mappedBy = "usuario")
	private List<Avaliacao> avaliacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public Usuario() {
		super();
	}

	public Usuario(UsuarioCadastroDTO usuarioCadastroDTO, List<Avaliacao> avaliacao) {
		super();
		this.nome = usuarioCadastroDTO.getNome();
		this.email = usuarioCadastroDTO.getEmail();
		this.senha = usuarioCadastroDTO.getSenha();
		this.avatar = usuarioCadastroDTO.getAvatar();
		this.avaliacao = avaliacao;
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


	public List<Avaliacao> getPost() {
		return avaliacao;
	}

	public void setPost(List<Avaliacao> post) {
		this.avaliacao = post;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}