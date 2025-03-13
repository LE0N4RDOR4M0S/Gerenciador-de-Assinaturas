package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.model.Usuario_Assinatura;
import com.leonardoramos.assinaturas.repository.Usuario_AssinaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Classe de serviço para usuários e assinaturas
 */
@Service
public class Usuario_AssinaturaService {

    private final Usuario_AssinaturaRepository usuarioAssinaturaRepository;

    public Usuario_AssinaturaService(Usuario_AssinaturaRepository usuarioAssinaturaRepository) {
        this.usuarioAssinaturaRepository = usuarioAssinaturaRepository;
    }

    /**
     * Busca um relacionamento usuario e assinatura pelo id
     * @param id id do usuário e assinatura em String
     * @return Relacionamento correspondente ao id
     */
    public Usuario_Assinatura buscarPorId(String id) {
        return usuarioAssinaturaRepository.findById(UUID.fromString(id)).orElse(null);
    }

    /**
     * Busca todos os relacionamentos de usuario e assinatura
     * @return Lista de relacionamentos
     */
    public List<Usuario_Assinatura> buscarTodos(){
        return usuarioAssinaturaRepository.findAll();
    }

    /**
     * Cria um novo relacionamento entre usuario e assinatura
     * @param usuarioAssinatura relacionamento a ser criado
     * @return Relacionamento criado
     */
    public Usuario_Assinatura criar(Usuario_Assinatura usuarioAssinatura){
        return usuarioAssinaturaRepository.save(usuarioAssinatura);
    }

    /**
     * Atualiza um relacionamento entre usuario e assinatura
     * @param novo relacionamento a ser atualizado
     * @param id id do relacionamento a ser atualizado
     * @return Relacionamento atualizado
     */
    public Usuario_Assinatura atualizar(Usuario_Assinatura novo, String id){
        Usuario_Assinatura usuarioAssinatura = usuarioAssinaturaRepository.findById(UUID.fromString(id)).orElse(null);
        if(usuarioAssinatura != null){
            usuarioAssinatura.setDataInicio(novo.getDataInicio());
            usuarioAssinatura.setDataFim(novo.getDataFim());
            usuarioAssinatura.setStatus(novo.getStatus());
            usuarioAssinatura.setUsuario(novo.getUsuario());
            usuarioAssinatura.setAssinatura(novo.getAssinatura());
            return usuarioAssinaturaRepository.save(usuarioAssinatura);
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
}
