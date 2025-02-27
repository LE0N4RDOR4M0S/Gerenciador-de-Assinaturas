package com.leonardoramos.assinaturas.controller;

import com.leonardoramos.assinaturas.model.Cupom;
import com.leonardoramos.assinaturas.service.CupomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cupom")
public class CupomController {

    private final CupomService cupomService;

    public CupomController(CupomService cupomService) {
        this.cupomService = cupomService;
    }

    @GetMapping
    public List<Cupom> buscarTodos() {
        return cupomService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Cupom buscarPorID(String id) {
        return cupomService.buscarPorID(id);
    }

    @PostMapping
    public Cupom criar(Cupom cupom) {
        return cupomService.criar(cupom);
    }

    @PostMapping("/{id}/atualizar")
    public Cupom atualizar(Cupom cupom, String id) {
        return cupomService.atualizar(cupom, id);
    }

    @GetMapping("/{id}/deletar")
    public void deletar(String id) {
        cupomService.deletar(id);
    }
}
