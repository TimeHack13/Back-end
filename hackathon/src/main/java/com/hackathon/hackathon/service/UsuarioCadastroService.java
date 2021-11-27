package com.hackathon.hackathon.service;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.hackathon.dto.UsuarioCadastroDTO;
import com.hackathon.hackathon.dto.UsuarioLoginDTO;
import com.hackathon.hackathon.model.Avaliacao;
import com.hackathon.hackathon.model.Usuario;
import com.hackathon.hackathon.repository.UsuarioRepository;

@Service
public class UsuarioCadastroService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	public Optional<Object> cadastrarUsuario(UsuarioCadastroDTO novoUsuarioCadastro) {
		
		return usuarioRepository.findByEmail(novoUsuarioCadastro.getEmail()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			
			List<Avaliacao> novaAvaliacao = new ArrayList<Avaliacao>();
			
			Usuario novoUsuario = new Usuario(novoUsuarioCadastro, novaAvaliacao);			
						
			return Optional.ofNullable(usuarioRepository.save(novoUsuario));
		});
	}
	
	public Optional<UsuarioLoginDTO> logar(Optional<UsuarioLoginDTO> user) {
		
		Optional<Usuario> cadastro = usuarioRepository.findByEmail(user.get().getEmail());

		if (cadastro.isPresent()) {
			if (user.get().getSenha() == cadastro.get().getSenha()) {
				
				user.get().setNome(cadastro.get().getNome());
				user.get().setId(cadastro.get().getId_usuario());
				user.get().setEmail(cadastro.get().getEmail());

				return user;
			}
		}
		
		return Optional.empty(); // login errado. seViraFront().
	}
	
}