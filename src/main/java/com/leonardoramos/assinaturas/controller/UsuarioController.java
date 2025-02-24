package com.leonardoramos.assinaturas.controller;

import com.leonardoramos.assinaturas.model.Usuario;
import com.leonardoramos.assinaturas.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public List<Usuario> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorID(UUID id) {
        return usuarioService.buscarPorID(id);
    }

    @PostMapping("/")
    public Usuario criar(Usuario usuario) {
        return usuarioService.criar(usuario);
    }

    @PostMapping("/{id}/atualizar")
    public Usuario atualizar(Usuario usuario, UUID id) {
        return usuarioService.atualizar(usuario, id);
    }

    @GetMapping("/{id}/deletar")
    public void deletar(UUID id) {
        usuarioService.deletar(id);
    }
}
