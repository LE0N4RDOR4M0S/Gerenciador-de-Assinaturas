package com.leonardoramos.assinaturas.dtos.Usuario_Assinatura;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Schema(name = "UsuarioAssinaturaResponseDTO", description = "DTO para response de entidade Usuario_Assinatura")
public class UsuarioAssinaturaResponseDTO {
    @Schema(name = "Id", description = "Id do usuário em formato UUID", example = "123e4567-e89b-12d3-a456-426614174000")
    private String Id;

    @Schema(name = "dataInicio", description = "Data de início da assinatura", example = "2022-12-31T23:59:59")
    private String dataInicio;

    @Schema(name = "dataFim", description = "Data de fim da assinatura", example = "2022-12-31T23:59:59")
    private String dataFim;

    @Schema(name = "status", description = "Status da assinatura", example = "ATIVO")
    private String status;

    @Schema(name = "usuario", description = "Usuário da assinatura", example = "123e4567-e89b-12d3-a456-426614174000")
    private String usuario;

    @Schema(name = "assinatura", description = "Assinatura do usuário", example = "123e4567-e89b-12d3-a456-426614174000")
    private String assinatura;
}
