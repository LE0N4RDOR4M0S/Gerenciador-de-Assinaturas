package com.leonardoramos.assinaturas.dtos.Usuario_Assinatura;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UsuarioAssinaturaRequestDTO", description = "DTO para requisição de Usuario_Assinatura")
public class UsuarioAssinaturaRequestDTO {

    @Schema(description = "Data de início da assinatura", example = "2022-12-31T23:59:59")
    private String dataInicio;

    @Schema(description = "Data de fim da assinatura", example = "2022-12-31T23:59:59")
    private String dataFim;

    @Schema(description = "Status da assinatura", example = "ATIVO")
    private String status;

    @Schema(description = "Usuário da assinatura", example = "123e4567-e89b-12d3-a456-426614174000")
    private String usuario;

    @Schema(description = "Assinatura do usuário", example = "123e4567-e89b-12d3-a456-426614174000")
    private String assinatura;

    /*
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, name = "data_inicio")
    private Timestamp dataInicio;

    @Column(nullable = false, name = "data_fim")
    private Timestamp dataFim;

    @Column(nullable = false)
    private Status_Assinatura status;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "assinatura_id", nullable = false)
    private Assinatura assinatura;
     */
}
