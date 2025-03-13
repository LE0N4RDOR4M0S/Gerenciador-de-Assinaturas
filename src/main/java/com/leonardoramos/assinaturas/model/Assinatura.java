package com.leonardoramos.assinaturas.model;

import com.leonardoramos.assinaturas.auditoria.AuditoriaListener;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditoriaListener.class)
public class Assinatura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = true)
    private int limit_usuario;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = true)
    private int duracao_dias;

    @Column(nullable = true)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @OneToMany(mappedBy = "assinatura")
    private List<Usuario_Assinatura> usuario_assinaturas;

    @OneToMany(mappedBy = "assinatura")
    private List<Cupom> cupons;

    @OneToMany(mappedBy = "assinatura")
    private List<Pagamento> pagamentos;
}
