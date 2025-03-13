package com.leonardoramos.assinaturas.controller;

import com.leonardoramos.assinaturas.model.Usuario;
import com.leonardoramos.assinaturas.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario", description = "Gerenciamento de usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Operation(summary = "Buscar todos os usuários", description = "Retorna uma lista com todos os usuários cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuários retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Nenhum usuário encontrado")
    })
    public List<Optional<Usuario>> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar usuário por id", description = "Retorna o usuário correspondente ao id informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário retornado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public Optional<Usuario> buscarPorID(@PathVariable(name = "id") String id) {
        return usuarioService.buscarPorID(id);
    }

    @PostMapping
    @Operation(summary = "Criar um novo usuário", description = "Cria um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public Usuario criar(@RequestBody Usuario usuario) {
        return usuarioService.criar(usuario);
    }

    @PostMapping("/{id}/atualizar")
    @Operation(summary = "Atualizar um usuário", description = "Atualiza um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public Optional<Usuario> atualizar(@RequestBody Usuario usuario,@PathVariable(name = "id") String id) {
        return usuarioService.atualizar(usuario, id);
    }

    @GetMapping("/{id}/deletar")
    @Operation(summary = "Deletar um usuário", description = "Deleta um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    public void deletar(@PathVariable(name = "id") String id) {
        usuarioService.deletar(id);
    }
}
