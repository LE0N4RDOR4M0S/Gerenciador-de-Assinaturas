package com.leonardoramos.assinaturas.dtos.Assinatura;

import com.leonardoramos.assinaturas.model.Assinatura;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@Schema(description = "DTO para resposta de criação ou atualização de assinatura")
public class AssinaturaResponseDTO {
    @Schema
    private String id;

    @Schema
    private String nome;

    @Schema
    private int limit_usuario;

    @Schema
    private double preco;

    @Schema
    private int duracao_dias;

    @Schema
    private String descricao;

    @Schema
    private String categoria_id; //TODO: Implementar DTO de Categoria

    //TODO: Implementar DTO dos relacionamentos OneToMany

    public static AssinaturaResponseDTO fromModel(Assinatura assinatura){
        return AssinaturaResponseDTO.builder()
                .id(assinatura.getId().toString())
                .nome(assinatura.getNome())
                .limit_usuario(assinatura.getLimit_usuario())
                .preco(assinatura.getPreco())
                .duracao_dias(assinatura.getDuracao_dias())
                .descricao(assinatura.getDescricao())
                .categoria_id(assinatura.getCategoria().getId().toString())
                .build();
    }

    public static List<AssinaturaResponseDTO> fromModel(List<Assinatura> assinaturas){
        return assinaturas.stream().map(AssinaturaResponseDTO::fromModel).collect(Collectors.toList());
    }
}
