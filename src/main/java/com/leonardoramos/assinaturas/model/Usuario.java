package com.leonardoramos.assinaturas.model;

import com.leonardoramos.assinaturas.auditoria.AuditoriaListener;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditoriaListener.class)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private Timestamp dataCriacao;

    @OneToMany(mappedBy = "usuario")
    private List<Usuario_Assinatura> usuarioAssinaturas;

    @OneToMany(mappedBy = "usuario")
    private List<Pagamento> pagamentos;
}
