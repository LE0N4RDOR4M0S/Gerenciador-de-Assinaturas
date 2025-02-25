package com.leonardoramos.assinaturas.repository;

import com.leonardoramos.assinaturas.model.Assinatura;
import com.leonardoramos.assinaturas.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AssinaturaRepository extends JpaRepository<Assinatura, UUID> {
    Optional<Assinatura> findByCategoria(Categoria categoria);
}
