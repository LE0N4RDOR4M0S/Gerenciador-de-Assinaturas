package com.leonardoramos.assinaturas.controller;

import com.leonardoramos.assinaturas.model.Usuario_Assinatura;
import com.leonardoramos.assinaturas.service.Usuario_AssinaturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario_assinatura")
@Tag(name = "Usuario_Assinatura", description = "Gerenciamento de relacionamentos entre usuário e assinatura")
public class Usuario_AssinaturaController {

    private final Usuario_AssinaturaService usuarioAssinaturaService;

    public Usuario_AssinaturaController(Usuario_AssinaturaService usuarioAssinaturaService) {
        this.usuarioAssinaturaService = usuarioAssinaturaService;
    }

    @GetMapping
    @Operation(summary = "Buscar todos os usuário_assinaturas", description = "Retorna uma lista com todos os usuários e assinaturas cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuários e assinaturas retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Nenhum usuário e assinatura encontrado")
    })
    public List<Usuario_Assinatura> buscarTodos(){
        return usuarioAssinaturaService.buscarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuário e assinatura por id", description = "Retorna o usuário e assinatura correspondente ao id informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário e assinatura retornados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Usuário e assinatura não encontrado")
    })
    public Usuario_Assinatura buscarPorId(@PathVariable(name = "id") String id){
        return usuarioAssinaturaService.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Criar um novo usuário e assinatura", description = "Cria um novo usuário e assinatura")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário e assinatura criados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public Usuario_Assinatura criar(@RequestBody Usuario_Assinatura usuarioAssinatura){
        return usuarioAssinaturaService.criar(usuarioAssinatura);
    }

    @PostMapping("/{id}/atualizar")
    @Operation(summary = "Atualizar um relacionamento de usuário e assinatura", description = "Atualiza o relacionamento entre usuário e assinatura")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relacionamento de usuário e assinatura atualizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public Usuario_Assinatura atualizar(@RequestBody Usuario_Assinatura novo, @PathVariable(name = "id") String id){
        return usuarioAssinaturaService.atualizar(novo, id);
    }

    @GetMapping("/{id}/deletar")
    @Operation(summary = "Deletar um relacionamento de usuário e assinatura", description = "Deleta um relacionamento entre usuário e assinatura")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relacionamento de usuário e assinatura deletado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Relacionamento de usuário e assinatura não encontrado")
    })
    public void deletar(@PathVariable(name = "id") String id){
        usuarioAssinaturaService.deletar(id);
    }
}
