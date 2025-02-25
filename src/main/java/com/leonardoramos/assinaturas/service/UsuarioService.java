package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.model.Usuario;
import com.leonardoramos.assinaturas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> buscarPorID(String id) {
        if (id == null) {
            return Optional.empty();
        }
        return usuarioRepository.findById(UUID.fromString(id));
    }

    public List<Optional<Usuario>> buscarTodos() {
        return usuarioRepository.findAll().stream().map(Optional::ofNullable).collect(Collectors.toList());
    }

    public Optional<Usuario> criar(Usuario usuario) {
        usuario.setDataCriacao(Timestamp.from(Instant.now()));
        return Optional.of(usuarioRepository.save(usuario));
    }

    public Optional<Usuario> atualizar(Usuario usuario, String id) {
        Usuario usuarioAntigo = usuarioRepository.findById(UUID.fromString(id)).orElse(null);
        if (usuarioAntigo != null) {
            usuarioAntigo.setNome(usuario.getNome());
            usuarioAntigo.setEmail(usuario.getEmail());
            usuarioAntigo.setSenha(usuario.getSenha());
            usuarioRepository.save(usuarioAntigo);
        }
        return Optional.of(usuarioAntigo);
    }

    public void deletar(String id) {
        if (id != null && !id.isEmpty()) {
            usuarioRepository.deleteById(UUID.fromString(id));
        }
    }
}
