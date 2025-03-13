package com.leonardoramos.assinaturas.model;

import com.leonardoramos.assinaturas.auditoria.AuditoriaListener;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditoriaListener.class)
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @OneToMany
    private List<Assinatura> assinaturas;
}
