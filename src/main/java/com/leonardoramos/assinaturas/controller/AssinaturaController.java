package com.leonardoramos.assinaturas.controller;

import com.leonardoramos.assinaturas.model.Assinatura;
import com.leonardoramos.assinaturas.service.AssinaturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {

    private final AssinaturaService assinaturaService;

    public AssinaturaController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @GetMapping
    public List<Assinatura> buscarTodas() {
        return assinaturaService.buscarTodas();
    }

    @GetMapping("/{id}")
    public Assinatura buscarPorId(@PathVariable(name = "id") String id){
        return assinaturaService.buscarPorId(id);
    }

    @PostMapping
    public Assinatura criar(@RequestBody Assinatura assinatura){
        return assinaturaService.criar(assinatura);
    }

    @PostMapping("/{id}/atualizar")
    public Assinatura atualizar(@PathVariable(name = "id") String id, @RequestBody Assinatura novaAssinatura) {
        return assinaturaService.atualizar(id, novaAssinatura);
    }

    @GetMapping("/{id}/deletar")
    public void deletar(@PathVariable(name = "id") String id){
        assinaturaService.deletar(id);
    }
}
