package com.leonardoramos.assinaturas.repository;

import com.leonardoramos.assinaturas.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CupomRepository extends JpaRepository<Cupom, UUID> {
    Cupom findByCodigo(String codigo);
}
