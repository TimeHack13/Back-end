package com.hackathon.hackathon.dto;

public class UsuarioLoginDTO {

	private String apelido;
	private String email;
	private String senha;
	
	public UsuarioLoginDTO() {
		super();
	}

	public UsuarioLoginDTO(String apelido, String email, String senha) {
		super();
		this.apelido = apelido;
		this.email = email;
		this.senha = senha;
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
	

}