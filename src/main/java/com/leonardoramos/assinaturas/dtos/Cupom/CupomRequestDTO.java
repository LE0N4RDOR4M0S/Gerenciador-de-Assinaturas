package com.leonardoramos.assinaturas.dtos.Cupom;

import com.leonardoramos.assinaturas.model.Cupom;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@Schema(name = "CupomRequestDTO", description = "DTO para requisição de cupom")
public class CupomRequestDTO {
    @NotNull
    @Schema(description = "Código do cupom", example = "CUPOM10")
    private String codigo;

    @NotNull
    @Schema(description = "Desconto percentual do cupom", example = "10")
    private double desconto_percentual;

    @Schema(description = "Data de expiração do cupom", example = "2022-12-31T23:59:59")
    private Timestamp expiracao;

    @NotNull
    @Schema(description = "Ativo", example = "true")
    private boolean ativo;

    @NotNull
    @Schema(description = "Assinatura para qual o cupom é válido", example = "123e4567-e89b-12d3-a456-426614174000")
    private String assinatura;

    public Cupom toModel() {
        return Cupom.builder()
                .codigo(codigo)
                .desconto_percentual(desconto_percentual)
                .expiracao(expiracao)
                .ativo(ativo)
                //TODO: Implementar Criação de Assinatura
                .build();
    }
}
