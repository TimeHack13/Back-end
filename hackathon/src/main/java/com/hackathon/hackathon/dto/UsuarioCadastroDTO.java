package com.hackathon.hackathon.dto;

public class UsuarioCadastroDTO {

	private String nome;
	private String email;
	private String senha;
	private String avatar;

	public UsuarioCadastroDTO() {
		super();
	}

	public UsuarioCadastroDTO(String nome, String email, String senha, String avatar) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.avatar = avatar;
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

}