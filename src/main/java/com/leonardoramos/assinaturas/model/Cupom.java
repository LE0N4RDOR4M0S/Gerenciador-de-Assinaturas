package com.leonardoramos.assinaturas.model;

import com.leonardoramos.assinaturas.auditoria.AuditoriaListener;
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
public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String codigo;

    @Column(nullable = false)
    private double desconto_percentual;

    @Column(nullable = false)
    private Timestamp expiracao;

    @Column(nullable = false)
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "id_assinatura", nullable = false)
    private Assinatura assinatura;
}
