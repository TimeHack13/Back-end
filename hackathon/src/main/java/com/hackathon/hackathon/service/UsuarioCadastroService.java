package com.hackathon.hackathon.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.hackathon.dto.UsuarioCadastroDTO;
import com.hackathon.hackathon.dto.UsuarioLoginDTO;
import com.hackathon.hackathon.repository.UsuarioRepository;

@Service
public class UsuarioCadastroService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;
	
}