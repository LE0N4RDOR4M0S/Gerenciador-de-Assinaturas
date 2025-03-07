package com.leonardoramos.assinaturas.model;

import com.leonardoramos.assinaturas.auditoria.AuditoriaListener;
import com.leonardoramos.assinaturas.Enum.MetodoPagamento;
import com.leonardoramos.assinaturas.Enum.StatusPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditoriaListener.class)
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private double valor;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodoPagamento metodo_pagamento;

    @Column(nullable = false)
    private StatusPagamento status_pagamento;

    @Column(nullable = false)
    private Timestamp data_pagamento;

    @ManyToOne
    @JoinColumn(name = "id_assinatura", nullable = false)
    private Assinatura assinatura;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
