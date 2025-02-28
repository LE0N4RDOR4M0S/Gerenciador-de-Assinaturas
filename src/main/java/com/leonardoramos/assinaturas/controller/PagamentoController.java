package com.leonardoramos.assinaturas.controller;

import com.leonardoramos.assinaturas.model.Pagamento;
import com.leonardoramos.assinaturas.service.PagamentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/{id}")
    private Pagamento buscarPorID(@PathVariable(name = "id") String id) {
        return pagamentoService.buscarPorID(id);
    }

    @GetMapping
    private List<Pagamento> buscarTodos() {
        return pagamentoService.buscarTodos();
    }

    @GetMapping("/criar")
    private Pagamento criar(Pagamento pagamento) {
        return pagamentoService.criar(pagamento);
    }

    @GetMapping("/{id}/atualizar")
    private Pagamento atualizar(Pagamento pagamento, @PathVariable(name = "id") String id) {
        return pagamentoService.atualizar(pagamento, id);
    }

    @GetMapping("/{id}/deletar")
    private void deletar(@PathVariable(name = "id") String id) {
        pagamentoService.deletar(id);
    }
}
