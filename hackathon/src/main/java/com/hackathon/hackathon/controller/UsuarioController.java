package com.hackathon.hackathon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.hackathon.dto.UsuarioCadastroDTO;
import com.hackathon.hackathon.dto.UsuarioLoginDTO;
import com.hackathon.hackathon.model.Avaliacao;
import com.hackathon.hackathon.model.Usuario;
import com.hackathon.hackathon.repository.AvaliacaoRepository;
import com.hackathon.hackathon.repository.UsuarioRepository;
import com.hackathon.hackathon.service.UsuarioCadastroService;
import com.hackathon.hackathon.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repositoryUsuario;
	
	@Autowired
	private AvaliacaoRepository repositoryAvaliacao;

	@Autowired
	private UsuarioService serviceUsuario;
	
	@Autowired
	private UsuarioCadastroService cadastroUsuarioService;
	
	/*
	 * Volta todos os usuários.
	 */
	@GetMapping
	public ResponseEntity<List<Usuario>> getAllUsuarios() {

		return ResponseEntity.ok(repositoryUsuario.findAll());

	};
	
	/**
	 * Retorna as avaliações.
	 * 
	 */
	@GetMapping("/avaliacoes")
	public ResponseEntity<List<Avaliacao>> getAllAvaliacoes() {

		return ResponseEntity.ok(repositoryAvaliacao.findAll());

	};

	/**
	 * Acha o usuário pelo id.
	 */
	@GetMapping("/id_usuario/{id_usuario}")
	public ResponseEntity<Usuario> getByIdUsuario(@PathVariable Long id_usuario) {

		return repositoryUsuario.findById(id_usuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());

	};
	
	/**
	 * Acha o usuário pelo id.
	 */
	@GetMapping("/id_empresa/{id_empresa}")
	public ResponseEntity<List<Avaliacao>> getByIdEmpresa(@PathVariable Long id_empresa) {
		
		return ResponseEntity.ok(repositoryAvaliacao.findAllByIdEmpresa(id_empresa));
		
	};
	
	/**
	 * Cria uma avaliação
	 * @param avaliacao
	 * @return
	 */
	@PostMapping("/avaliacao")
	public ResponseEntity<Object> criarEmpresa(@RequestBody Avaliacao avaliacao) {
		
		return serviceUsuario.fazerAvaliacao(avaliacao)
				.map(x -> ResponseEntity.status(201).body(x))
				.orElse(ResponseEntity.badRequest().build());
		
	}
	
	/**
	 * Cadastra/Cria usuario
	 * @param usuarioCadastro
	 * @return
	 */
	@PostMapping("/cadastrar")
	public ResponseEntity<Object> autentication(@RequestBody UsuarioCadastroDTO usuarioCadastro) {
		return cadastroUsuarioService.cadastrarUsuario(usuarioCadastro)
				.map(usuarioCadastrado -> ResponseEntity.status(HttpStatus.CREATED)
						.body(usuarioCadastrado))
				.orElse(ResponseEntity.badRequest().build());
	}
	
	/**
	 * Loga o usuário.
	 * @param login
	 * @return
	 */
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLoginDTO> autentication(@RequestBody Optional<UsuarioLoginDTO> login) {
		return cadastroUsuarioService.logar(login).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

}
