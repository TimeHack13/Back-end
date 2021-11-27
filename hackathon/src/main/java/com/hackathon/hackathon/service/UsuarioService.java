package com.hackathon.hackathon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.hackathon.dto.UsuarioCadastroDTO;
import com.hackathon.hackathon.model.Avaliacao;
import com.hackathon.hackathon.model.Empresa;
import com.hackathon.hackathon.model.Usuario;
import com.hackathon.hackathon.repository.AvaliacaoRepository;
import com.hackathon.hackathon.repository.EmpresaRepository;
import com.hackathon.hackathon.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositoryUsuario;

	@Autowired
	private EmpresaRepository repositoryEmpresa;

	@Autowired
	private AvaliacaoRepository repositoryAvaliacao;

	// Salva um novo usuario
	public Usuario novoUsuario(Usuario novoUsuario) {
		return repositoryUsuario.save(novoUsuario);
	}

	public Optional<?> mudarUsuario(Usuario mudarUsuario) {

		return repositoryUsuario.findById(mudarUsuario.getId_usuario()).map(usuarioExistente -> {
			Optional<Usuario> usuarioExistente2 = repositoryUsuario.findByEmail(mudarUsuario.getEmail());

			if (usuarioExistente2.isPresent()) {
				return Optional.empty();
			} else {

				usuarioExistente.setEmail(mudarUsuario.getEmail());
				usuarioExistente.setNome(mudarUsuario.getNome());
				usuarioExistente.setSenha(mudarUsuario.getSenha());

				return Optional.ofNullable(repositoryUsuario.save(usuarioExistente));
			}
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

	// Cadastrar uma empresa.

	public Optional<Object> cadastrarEmpresa(Empresa novaEmpresa) {

		return repositoryEmpresa.findByRazaoSocial(novaEmpresa.getRazaoSocial()).map(empresaExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {

			Empresa novoEmpresaCadastro = new Empresa();

			return Optional.ofNullable(repositoryEmpresa.save(novoEmpresaCadastro));
		});
	}
	
	// Fazer avaliação.
	
	public Optional<Object> fazerAvaliacao(Avaliacao novaAvaliacao) {

		return repositoryAvaliacao.findByTitulo(novaAvaliacao.getTitulo()).map(empresaExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {

			Avaliacao novaAvaliacaoUsuario = new Avaliacao();

			return Optional.ofNullable(repositoryAvaliacao.save(novaAvaliacaoUsuario));
		});
	}

}