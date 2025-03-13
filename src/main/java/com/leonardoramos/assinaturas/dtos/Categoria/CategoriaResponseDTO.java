package com.leonardoramos.assinaturas.dtos.Categoria;

import com.leonardoramos.assinaturas.model.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@Schema(description = "DTO para resposta de criação,atualização e busca de categoria")
public class CategoriaResponseDTO {
    @Schema(description = "ID da categoria")
    private String id;

    @Schema(description = "Nome da categoria")
    private String nome;

    @Schema(description = "Descrição da categoria")
    private String descricao;

    public static CategoriaResponseDTO fromModel(Categoria categoria){
        return CategoriaResponseDTO.builder()
                .id(categoria.getId().toString())
                .nome(categoria.getNome())
                .descricao(categoria.getDescricao())
                .build();
    }

    public static List<CategoriaResponseDTO> fromModel(List<Categoria> categorias){
        return categorias.stream().map(CategoriaResponseDTO::fromModel).collect(Collectors.toList());
    }

}
