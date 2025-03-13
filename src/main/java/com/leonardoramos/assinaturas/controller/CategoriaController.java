package com.leonardoramos.assinaturas.controller;

import com.leonardoramos.assinaturas.dtos.Categoria.CategoriaRequestDTO;
import com.leonardoramos.assinaturas.dtos.Categoria.CategoriaResponseDTO;
import com.leonardoramos.assinaturas.model.Categoria;
import com.leonardoramos.assinaturas.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
@Tag(name = "Categoria", description = "Gerenciamento de categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping
    @Operation(summary = "Buscar todas as categorias", description = "Retorna uma lista com todas as categorias cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de categorias retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Nenhuma categoria encontrada")
    })
    private List<CategoriaResponseDTO> buscarTodos(){
        return categoriaService.buscarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoria por id", description = "Retorna a categoria correspondente ao id informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    private CategoriaResponseDTO buscarPorId(@PathVariable(name = "id") String id){
        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Criar uma nova categoria", description = "Cria uma nova categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria criada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    private CategoriaResponseDTO criar(@RequestBody CategoriaRequestDTO categoria){
        return categoriaService.criar(categoria);
    }

    @PostMapping("{id}")
    @Operation(summary = "Atualizar uma categoria", description = "Atualiza uma categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    private CategoriaResponseDTO atualizar(@RequestBody CategoriaRequestDTO categoria,@PathVariable(name = "id") String id){
        return categoriaService.atualizar(categoria, id);
    }

    @GetMapping("/{id}/deletar")
    @Operation(summary = "Deletar uma categoria", description = "Deleta uma categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoria deletada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    private void deletar(@PathVariable(name = "id") String id){
        categoriaService.deletar(id);
    }

}
