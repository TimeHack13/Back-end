package com.hackathon.hackathon.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "tb_avaliacao	")
@Component
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_avaliacao;

	private String descricao;
	private String nomeEmpresa;
	private Long pontuacao;
	private String endereco;
	private String telefone;

	/**
	 * Id da empresa avaliada.
	 */
	private Long idEmpresa;

	/**
	 * Id do usuário que fez a avaliação.
	 */
	private Long idUsuario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public Avaliacao() {
		super();
	}

	public Avaliacao(String descricao, String nomeEmpresa, Long pontuacao, String endereco, String telefone,
			Long idEmpresa, Long idUsuario) {
		super();
		this.descricao = descricao;
		this.nomeEmpresa = nomeEmpresa;
		this.pontuacao = pontuacao;
		this.endereco = endereco;
		this.telefone = telefone;
		this.idEmpresa = idEmpresa;
		this.idUsuario = idUsuario;
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

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public Long getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Long pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
