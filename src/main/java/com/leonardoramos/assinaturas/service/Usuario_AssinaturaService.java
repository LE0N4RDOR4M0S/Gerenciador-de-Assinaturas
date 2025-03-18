package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.Enum.Status_Assinatura;
import com.leonardoramos.assinaturas.dtos.Usuario.UsuarioResponseDTO;
import com.leonardoramos.assinaturas.dtos.Usuario_Assinatura.UsuarioAssinaturaRequestDTO;
import com.leonardoramos.assinaturas.dtos.Usuario_Assinatura.UsuarioAssinaturaResponseDTO;
import com.leonardoramos.assinaturas.model.Usuario_Assinatura;
import com.leonardoramos.assinaturas.repository.Usuario_AssinaturaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Classe de serviço para usuários e assinaturas
 */
@Service
public class Usuario_AssinaturaService {

    private final Usuario_AssinaturaRepository usuarioAssinaturaRepository;

    private final UsuarioService usuarioService;

    private final AssinaturaService assinaturaService;


    public Usuario_AssinaturaService(Usuario_AssinaturaRepository usuarioAssinaturaRepository, UsuarioService usuarioService, AssinaturaService assinaturaService) {
        this.usuarioAssinaturaRepository = usuarioAssinaturaRepository;
        this.usuarioService = usuarioService;
        this.assinaturaService = assinaturaService;
    }

    /**
     * Busca um relacionamento usuario e assinatura pelo id
     * @param id id do usuário e assinatura em String
     * @return Relacionamento correspondente ao id
     */
    public UsuarioAssinaturaResponseDTO buscarPorId(String id) {
        UsuarioAssinaturaResponseDTO usuarioAssinaturaResponseDTO = modelToDTO(usuarioAssinaturaRepository.findById(UUID.fromString(id)).orElse(null));
        return usuarioAssinaturaResponseDTO;
    }

    /**
     * Busca todos os relacionamentos de usuario e assinatura
     * @return Lista de relacionamentos
     */
    public List<UsuarioAssinaturaResponseDTO> buscarTodos(){
        return fromModel(usuarioAssinaturaRepository.findAll());
    }

    /**
     * Cria um novo relacionamento entre usuario e assinatura
     * @param usuarioAssinaturaDTO relacionamento a ser criado
     * @return Relacionamento criado
     */
    public UsuarioAssinaturaResponseDTO criar(UsuarioAssinaturaRequestDTO usuarioAssinaturaDTO){
        Usuario_Assinatura usuarioAssinatura = toModel(usuarioAssinaturaDTO);
        return modelToDTO(usuarioAssinaturaRepository.save(usuarioAssinatura));
    }

    /**
     * Atualiza um relacionamento entre usuario e assinatura
     * @param novo relacionamento a ser atualizado
     * @param id id do relacionamento a ser atualizado
     * @return Relacionamento atualizado
     */
    public UsuarioAssinaturaResponseDTO atualizar(UsuarioAssinaturaRequestDTO novo, String id){
        Usuario_Assinatura usuarioAssinatura = usuarioAssinaturaRepository.findById(UUID.fromString(id)).orElse(null);
        if(usuarioAssinatura != null){
            usuarioAssinatura.setDataInicio(Timestamp.valueOf(novo.getDataInicio()));
            usuarioAssinatura.setDataFim(Timestamp.valueOf(novo.getDataFim()));
            usuarioAssinatura.setStatus(Status_Assinatura.valueOf(novo.getStatus()));
            usuarioAssinatura.setUsuario(usuarioService.buscarPorIDModel(novo.getUsuario()));
            usuarioAssinatura.setAssinatura(assinaturaService.buscarPorIdModel(novo.getUsuario()));
            return modelToDTO(usuarioAssinaturaRepository.save(usuarioAssinatura));
        }
        return null;
    }

    /**
     * Deleta um relacionamento
     * @param id id do relacionamento a ser deletado
     */
    public void deletar(String id){
        usuarioAssinaturaRepository.deleteById(UUID.fromString(id));
    }

    private static UsuarioAssinaturaResponseDTO modelToDTO(Usuario_Assinatura usuarioAssinatura) {
        return UsuarioAssinaturaResponseDTO.builder()
                .Id(String.valueOf(usuarioAssinatura.getId()))
                .dataInicio(String.valueOf(usuarioAssinatura.getDataInicio()))
                .dataFim(String.valueOf(usuarioAssinatura.getDataFim()))
                .status(String.valueOf(usuarioAssinatura.getStatus()))
                .usuario(String.valueOf(usuarioAssinatura.getUsuario()))
                .assinatura(String.valueOf(usuarioAssinatura.getAssinatura()))
                .build();
    }

    private static List<UsuarioAssinaturaResponseDTO> fromModel(List<Usuario_Assinatura> usuarioAssinaturas) {
        return usuarioAssinaturas.stream().map(Usuario_AssinaturaService::modelToDTO).collect(Collectors.toList());
    }

    private Usuario_Assinatura toModel(UsuarioAssinaturaRequestDTO usuarioAssinaturaDTO) {
        Usuario_Assinatura usuarioAssinatura = new Usuario_Assinatura();
        usuarioAssinatura.setDataInicio(Timestamp.valueOf(usuarioAssinaturaDTO.getDataInicio()));
        usuarioAssinatura.setDataFim(Timestamp.valueOf(usuarioAssinaturaDTO.getDataFim()));
        usuarioAssinatura.setStatus(Status_Assinatura.valueOf(usuarioAssinaturaDTO.getStatus()));
        usuarioAssinatura.setUsuario(usuarioService.buscarPorIDModel(usuarioAssinaturaDTO.getUsuario()));
        usuarioAssinatura.setAssinatura(assinaturaService.buscarPorIdModel(usuarioAssinaturaDTO.getAssinatura()));
        return usuarioAssinatura;
    }
}
