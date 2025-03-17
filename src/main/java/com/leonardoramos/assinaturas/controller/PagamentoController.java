package com.leonardoramos.assinaturas.controller;

import com.leonardoramos.assinaturas.dtos.Pagamento.PagamentoRequestDTO;
import com.leonardoramos.assinaturas.model.Pagamento;
import com.leonardoramos.assinaturas.service.PagamentoService;
import com.leonardoramos.assinaturas.dtos.Pagamento.PagamentoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
@Tag(name = "Pagamento", description = "Gerenciamento de pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar pagamento por id", description = "Retorna o pagamento correspondente ao id informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento retornado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado")
    })
    private PagamentoResponseDTO buscarPorID(@PathVariable(name = "id") String id) {
        return pagamentoService.buscarPorID(id);
    }

    @GetMapping
    @Operation(summary = "Buscar todos os pagamentos", description = "Retorna uma lista com todos os pagamentos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pagamentos retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Nenhum pagamento encontrado")
    })
    private List<PagamentoResponseDTO> buscarTodos() {
        return pagamentoService.buscarTodos();
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar um novo pagamento", description = "Cria um novo pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    private PagamentoResponseDTO criar(@RequestBody PagamentoRequestDTO pagamento) {
        return pagamentoService.criar(pagamento);
    }

    @PostMapping("/{id}/atualizar")
    @Operation(summary = "Atualizar um pagamento", description = "Atualiza um pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento atualizado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado")
    })
    private PagamentoResponseDTO atualizar(@RequestBody PagamentoRequestDTO pagamento, @PathVariable(name = "id") String id) {
        return pagamentoService.atualizar(pagamento, id);
    }

    @GetMapping("/{id}/deletar")
    @Operation(summary = "Deletar um pagamento", description = "Deleta um pagamento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento deletado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
            @ApiResponse(responseCode = "404", description = "Pagamento não encontrado")
    })
    private void deletar(@PathVariable(name = "id") String id) {
        pagamentoService.deletar(id);
    }
}
