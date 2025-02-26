package com.leonardoramos.assinaturas.controller;

import com.leonardoramos.assinaturas.model.Usuario_Assinatura;
import com.leonardoramos.assinaturas.service.Usuario_AssinaturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario_assinatura")
public class Usuario_AssinaturaController {

    private final Usuario_AssinaturaService usuarioAssinaturaService;

    public Usuario_AssinaturaController(Usuario_AssinaturaService usuarioAssinaturaService) {
        this.usuarioAssinaturaService = usuarioAssinaturaService;
    }

    @GetMapping
    public List<Usuario_Assinatura> buscarTodos(){
        return usuarioAssinaturaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Usuario_Assinatura buscarPorId(@PathVariable(name = "id") String id){
        return usuarioAssinaturaService.buscarPorId(id);
    }

    @PostMapping
    public Usuario_Assinatura criar(@RequestBody Usuario_Assinatura usuarioAssinatura){
        return usuarioAssinaturaService.criar(usuarioAssinatura);
    }

    @PostMapping("/{id}/atualizar")
    public Usuario_Assinatura atualizar(@RequestBody Usuario_Assinatura novo, @PathVariable(name = "id") String id){
        return usuarioAssinaturaService.atualizar(novo, id);
    }

    @GetMapping("/{id}/deletar")
    public void deletar(@PathVariable(name = "id") String id){
        usuarioAssinaturaService.deletar(id);
    }
}
