package com.hackathon.hackathon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hackathon.model.Empresa;

@Repository
public interface EmpresaRepository  extends JpaRepository<Empresa, Long> {
		
	public List<Empresa> findAllByEnderecoContainingIgnoreCase(String endereco);
	
	public Optional<Empresa> findByRazaoSocial(String razaoSocial);
	
}