package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.model.Usuario;
import com.leonardoramos.assinaturas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarPorID(UUID id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario criar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario, UUID id) {
        Usuario usuarioAntigo = usuarioRepository.findById(id).orElse(null);
        if (usuarioAntigo != null) {
            usuarioAntigo.setNome(usuario.getNome());
            usuarioAntigo.setEmail(usuario.getEmail());
            usuarioAntigo.setSenha(usuario.getSenha());
            usuarioRepository.save(usuarioAntigo);
        }
        return usuarioAntigo;
    }

    public void deletar(UUID id) {
        usuarioRepository.deleteById(id);
    }
}
