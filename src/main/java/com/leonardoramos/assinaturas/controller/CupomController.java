package com.leonardoramos.assinaturas.controller;

import com.leonardoramos.assinaturas.model.Cupom;
import com.leonardoramos.assinaturas.service.CupomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cupom")
@Tag(name = "Cupom", description = "Gerenciamento de cupons de desconto")
public class CupomController {

    private final CupomService cupomService;

    public CupomController(CupomService cupomService) {
        this.cupomService = cupomService;
    }

    @GetMapping
    @Operation(summary = "Buscar todos os cupons", description = "Retorna uma lista com todos os cupons cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de cupons retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Nenhum cupom encontrado")
    })
    public List<Cupom> buscarTodos() {
        return cupomService.buscarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cupom por id", description = "Retorna o cupom correspondente ao id informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cupom retornado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Cupom não encontrado")
    })
    public Cupom buscarPorID(String id) {
        return cupomService.buscarPorID(id);
    }

    @PostMapping
    @Operation(summary = "Criar um novo cupom", description = "Cria um novo cupom")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cupom criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    public Cupom criar(Cupom cupom) {
        return cupomService.criar(cupom);
    }

    @PostMapping("/{id}/atualizar")
    @Operation(summary = "Atualizar um cupom", description = "Atualiza um cupom")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cupom atualizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Cupom não encontrado")
    })
    public Cupom atualizar(Cupom cupom, String id) {
        return cupomService.atualizar(cupom, id);
    }

    @GetMapping("/{id}/deletar")
    @Operation(summary = "Deletar um cupom", description = "Deleta um cupom")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cupom deletado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Cupom não encontrado")
    })
    public void deletar(String id) {
        cupomService.deletar(id);
    }
}
