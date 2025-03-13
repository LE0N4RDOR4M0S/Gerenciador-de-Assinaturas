package com.leonardoramos.assinaturas.dtos.Categoria;

import com.leonardoramos.assinaturas.model.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "DTO para requisição de criação ou atualização de categoria")
public class CategoriaRequestDTO {
    @NotNull
    @Schema(description = "Nome da categoria", example = "Categoria Premium")
    private String nome;

    @NotNull
    @Schema(description = "Descrição da categoria", example = "Categoria com acesso a todos os recursos")
    private String descricao;

    public Categoria toModel(){
        return Categoria.builder()
                .nome(nome)
                .descricao(descricao)
                .build();
    }
}
