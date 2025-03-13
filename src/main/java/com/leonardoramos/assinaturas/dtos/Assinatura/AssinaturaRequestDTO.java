package com.leonardoramos.assinaturas.dtos.Assinatura;

import com.leonardoramos.assinaturas.model.Assinatura;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "DTO para requisição de criação ou atualização de assinatura")
public class AssinaturaRequestDTO {
    @NotNull
    @Schema(description = "Nome da assinatura", example = "Assinatura Premium")
    private String nome;

    @Schema(description = "Limite de usuários da assinatura", example = "10")
    private int limit_usuario;

    @NotNull
    @Schema(description = "Preço da assinatura", example = "100.00")
    private double preco;

    @Schema(description = "Duração da assinatura em dias", example = "30")
    private int duracao_dias;

    @Schema(description = "Descrição da assinatura", example = "Assinatura com acesso a todos os recursos")
    private String descricao;

    @NotNull
    @Schema(description = "ID da categoria da assinatura", example = "123e4567-e89b-12d3-a456-426614174000")
    private String categoria_id;

    public Assinatura toModel(){
        return Assinatura.builder()
                .nome(nome)
                .limit_usuario(limit_usuario)
                .preco(preco)
                .duracao_dias(duracao_dias)
                .descricao(descricao)
                //TODO: Implementar método para buscar categoria pelo ID
                .build();
    }
}

