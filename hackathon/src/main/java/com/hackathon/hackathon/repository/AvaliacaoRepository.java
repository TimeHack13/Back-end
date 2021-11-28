package com.hackathon.hackathon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hackathon.model.Avaliacao;

@Repository
public interface AvaliacaoRepository  extends JpaRepository<Avaliacao, Long> {

	public Optional<Avaliacao> findByNomeEmpresa(String nomeEmpresa);
	
	public List<Avaliacao> findAllByNomeEmpresaContainingIgnoreCase(String nomeEmpresa);
	
	public List<Avaliacao> findAllByIdEmpresa(Long idEmpresa);
	
}