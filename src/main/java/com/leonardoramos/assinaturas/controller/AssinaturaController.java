package com.leonardoramos.assinaturas.controller;

import com.leonardoramos.assinaturas.dtos.Assinatura.AssinaturaRequestDTO;
import com.leonardoramos.assinaturas.dtos.Assinatura.AssinaturaResponseDTO;
import com.leonardoramos.assinaturas.model.Assinatura;
import com.leonardoramos.assinaturas.service.AssinaturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assinaturas")
@Tag(name = "Assinaturas", description = "Gerenciamento de assinaturas")
public class AssinaturaController {

    private final AssinaturaService assinaturaService;

    public AssinaturaController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @GetMapping
    @Operation(summary = "Buscar todas as assinaturas", description = "Retorna uma lista com todas as assinaturas cadastradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de assinaturas retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Nenhuma assinatura encontrada")
    })
    public List<AssinaturaResponseDTO> buscarTodas() {
        return assinaturaService.buscarTodas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar assinatura por id", description = "Retorna a assinatura correspondente ao id informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Assinatura retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Assinatura não encontrada")
    })
    public AssinaturaResponseDTO buscarPorId(@PathVariable(name = "id") String id){
        return assinaturaService.buscarPorId(id);
    }

    @PostMapping
    @Operation(summary = "Criar uma nova assinatura", description = "Cria uma nova assinatura")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Assinatura criada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public AssinaturaResponseDTO criar(@RequestBody AssinaturaRequestDTO assinatura){
        return assinaturaService.criar(assinatura);
    }

    @PostMapping("/{id}/atualizar")
    @Operation(summary = "Atualizar uma assinatura", description = "Atualiza uma assinatura")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Assinatura atualizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public AssinaturaResponseDTO atualizar(@PathVariable(name = "id") String id, @RequestBody AssinaturaRequestDTO novaAssinatura) {
        return assinaturaService.atualizar(id, novaAssinatura);
    }

    @GetMapping("/{id}/deletar")
    @Operation(summary = "Deletar uma assinatura", description = "Deleta uma assinatura")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Assinatura deletada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Assinatura não encontrada")
    })
    public void deletar(@PathVariable(name = "id") String id){
        assinaturaService.deletar(id);
    }
}
