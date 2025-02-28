package com.leonardoramos.assinaturas.repository;

import com.leonardoramos.assinaturas.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID> {
}
