package com.leonardoramos.assinaturas.repository;

import com.leonardoramos.assinaturas.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
}
