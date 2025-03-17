package com.leonardoramos.assinaturas.dtos.Usuario;

import com.leonardoramos.assinaturas.model.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(name = "UsuarioRequestDTO", description = "DTO para requisição de usuarios")
public class UsuarioRequestDTO {
    @NotNull
    @Schema(name = "nome", description = "Nome do usuário", example = "leonardoBR")
    private String nome;

    @NotNull
    @Schema(name = "email", description = "Email do usuário", example = "subflow@flow.sub")
    private String email;

    @NotNull
    @Schema(name = "senha", description = "Senha criada do usuário", example = "123456")
    private String senha;

    public Usuario toModel() {
        return Usuario.builder()
                .nome(this.nome)
                .email(this.email)
                .senha(this.senha)
                .build();
    }
}
