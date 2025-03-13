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

/**
 * Classe de serviço para usuários
 */
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Busca um usuário pelo id
     * @param id id do usuário em String
     * @return Usuário correspondente ao id
     */
    public Optional<Usuario> buscarPorID(String id) {
        if (id == null) {
            return Optional.empty();
        }
        return usuarioRepository.findById(UUID.fromString(id));
    }

    /**
     * Busca todos os usuários
     * @return Lista de usuários
     */
    public List<Optional<Usuario>> buscarTodos() {
        return usuarioRepository.findAll().stream().map(Optional::ofNullable).collect(Collectors.toList());
    }

    /**
     * Cria um novo usuário
     * @param usuario usuário a ser criado
     * @return Usuário criado
     */
    public Usuario criar(Usuario usuario) {
        usuario.setDataCriacao(Timestamp.from(Instant.now()));
        return usuarioRepository.save(usuario);
    }

    /**
     * Atualiza um usuário
     * @param usuario usuário a ser atualizado
     * @param id id do usuário a ser atualizado
     * @return Usuário atualizado
     */
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

    /**
     * Deleta um usuário
     * @param id id do usuário a ser deletado
     */
    public void deletar(String id) {
        if (id != null && !id.isEmpty()) {
            usuarioRepository.deleteById(UUID.fromString(id));
        }
    }
}
