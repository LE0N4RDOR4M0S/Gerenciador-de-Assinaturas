package com.leonardoramos.assinaturas.controller;

import com.leonardoramos.assinaturas.model.Usuario;
import com.leonardoramos.assinaturas.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Optional<Usuario>> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarPorID(@PathVariable(name = "id") String id) {
        return usuarioService.buscarPorID(id);
    }

    @PostMapping
    public Optional<Usuario> criar(@RequestBody Usuario usuario) {
        return usuarioService.criar(usuario);
    }

    @PostMapping("/{id}/atualizar")
    public Optional<Usuario> atualizar(@RequestBody Usuario usuario,@PathVariable(name = "id") String id) {
        return usuarioService.atualizar(usuario, id);
    }

    @GetMapping("/{id}/deletar")
    public void deletar(@PathVariable(name = "id") String id) {
        usuarioService.deletar(id);
    }
}
