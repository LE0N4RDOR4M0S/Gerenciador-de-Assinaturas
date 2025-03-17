package com.leonardoramos.assinaturas.dtos.Usuario;

import com.leonardoramos.assinaturas.model.Pagamento;
import com.leonardoramos.assinaturas.model.Usuario_Assinatura;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "UsuarioResponseDTO", description = "DTO para response de entidade Usuario")
public class UsuarioResponseDTO {
    @Schema(name = "Id", description = "Id do usuário em formato UUID")
    private String id;

    @Schema(name = "nome", description = "Nome do usuário", example = "leonardoBr")
    private String nome;

    @Schema(name = "email", description = "email do usuário", example = "subflow@flow.sub")
    private String email;

    @Schema(name = "senha", description = "Senha do usuário", example = "123456")
    private String senha;

    @Schema(name = "dataCriacao", description = "Email do usuário", example = "2022-12-31T23:59:59")
    private Timestamp dataCriacao;

    @Schema(name = "usuarioAssinaturas", description = "Lista de assinaturas no qual o usuário está ativo")
    private List<Usuario_Assinatura> usuarioAssinaturas;

    @Schema(name = "pagamentos", description = "Pagamentos com o nome do usuário")
    private List<Pagamento> pagamentos;
}
