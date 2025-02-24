package com.leonardoramos.assinaturas.repository;

import com.leonardoramos.assinaturas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Usuario findByEmail(String email);

    Usuario findByNome(String nome);
}
