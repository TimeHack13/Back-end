package com.hackathon.hackathon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.hackathon.dto.UsuarioCadastroDTO;
import com.hackathon.hackathon.model.Avaliacao;
import com.hackathon.hackathon.model.Usuario;
import com.hackathon.hackathon.repository.AvaliacaoRepository;
import com.hackathon.hackathon.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositoryUsuario;

	@Autowired
	private AvaliacaoRepository repositoryPost;
}