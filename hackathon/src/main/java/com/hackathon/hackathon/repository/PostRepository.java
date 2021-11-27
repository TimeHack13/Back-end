package com.hackathon.hackathon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.hackathon.model.Post;

public interface PostRepository  extends JpaRepository<Post, Long> {

	public Optional<Post> findByTitulo(String titulo);
	
	public List<Post> findAllByTituloContainingIgnoreCase(String titulo);
	
}