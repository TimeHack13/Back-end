package com.hackathon.hackathon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.hackathon.model.Empresa;

public interface EmpresaRepository  extends JpaRepository<Empresa, Long> {
	
	public Optional<Empresa> findByRazãoSocial(String razãoSocial);
	
	public List<Empresa> findAllByEnderecoContainingIgnoreCase(String endereco);
	
}