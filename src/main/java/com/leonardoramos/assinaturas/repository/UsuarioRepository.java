package com.leonardoramos.assinaturas.repository;

import com.leonardoramos.assinaturas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    List<Usuario> id(UUID id);
}
