package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.dtos.Usuario.UsuarioRequestDTO;
import com.leonardoramos.assinaturas.dtos.Usuario.UsuarioResponseDTO;
import com.leonardoramos.assinaturas.model.Usuario;
import com.leonardoramos.assinaturas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
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
    public UsuarioResponseDTO buscarPorID(String id) {
        return modelToDTO(Objects.requireNonNull(usuarioRepository.findById(UUID.fromString(id)).orElse(null)));
    }

    /**
     * Busca todos os usuários
     * @return Lista de usuários
     */
    public List<UsuarioResponseDTO> buscarTodos() {
        return modelToDTO(usuarioRepository.findAll());
    }

    /**
     * Cria um novo usuário
     * @param usuarioDTO usuário a ser criado
     * @return Usuário criado
     */
    public UsuarioResponseDTO criar(UsuarioRequestDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.toModel();
        usuario.setDataCriacao(Timestamp.from(Instant.now()));
        return modelToDTO(usuarioRepository.save(usuario));
    }

    /**
     * Atualiza um usuário
     * @param usuarioDTO usuário a ser atualizado
     * @param id id do usuário a ser atualizado
     * @return Usuário atualizado
     */
    public UsuarioResponseDTO atualizar(UsuarioRequestDTO usuarioDTO, String id) {
        Usuario usuarioAntigo = usuarioRepository.findById(UUID.fromString(id)).orElse(null);
        if (usuarioAntigo != null) {
            usuarioAntigo.setNome(usuarioDTO.getNome());
            usuarioAntigo.setEmail(usuarioDTO.getEmail());
            usuarioAntigo.setSenha(usuarioDTO.getSenha());
            usuarioRepository.save(usuarioAntigo);
        }
        assert usuarioAntigo != null;
        return modelToDTO(usuarioAntigo);
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

    public Usuario buscarPorIDModel(String id){
        return usuarioRepository.findById(UUID.fromString(id)).orElse(null);
    }

    private static UsuarioResponseDTO modelToDTO(Usuario usuario){
        return UsuarioResponseDTO.builder()
                .id(String.valueOf(usuario.getId()))
                .nome(usuario.getNome())
                .senha(usuario.getSenha())
                .email(usuario.getEmail())
                .dataCriacao(usuario.getDataCriacao())
                .pagamentos(usuario.getPagamentos())
                .usuarioAssinaturas(usuario.getUsuarioAssinaturas())
                .build();
    }

    private static List<UsuarioResponseDTO> modelToDTO(List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioService::modelToDTO).collect(Collectors.toList());
    }
}
