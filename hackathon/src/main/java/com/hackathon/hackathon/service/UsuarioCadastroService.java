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
			
			Usuario novoUsuario = new Usuario(novoUsuarioCadastro);			
						
			return Optional.ofNullable(usuarioRepository.save(novoUsuario));
		});
	}
	
	public Optional<UsuarioLoginDTO> logar(Optional<UsuarioLoginDTO> userLogin) {
		
		Optional<Usuario> usuario = usuarioRepository.findByEmail(userLogin.get().getEmail());

		String valor1 = userLogin.get().getEmail();
		String valor2 = usuario.get().getEmail();
		
		boolean verifica = valor1 == valor2;
				
		if (usuario.isPresent()) {
			if (!verifica) {
				
				userLogin.get().setId(usuario.get().getId_usuario());
				userLogin.get().setEmail(usuario.get().getEmail());
				
				return userLogin;
			}
		}
		
		return Optional.empty();
	}
	
}