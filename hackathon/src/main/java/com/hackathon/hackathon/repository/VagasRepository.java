package com.hackathon.hackathon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.hackathon.model.Vagas;

public interface VagasRepository extends JpaRepository<Vagas, Long> {

	public Optional<Vagas> findByTitulo(String titulo);

	public List<Vagas> findAllByTituloContainingIgnoreCase(String titulo);

}