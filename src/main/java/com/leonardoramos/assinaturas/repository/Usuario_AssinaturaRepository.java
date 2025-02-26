package com.leonardoramos.assinaturas.repository;

import com.leonardoramos.assinaturas.model.Usuario_Assinatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Usuario_AssinaturaRepository extends JpaRepository<Usuario_Assinatura, UUID> {
}
