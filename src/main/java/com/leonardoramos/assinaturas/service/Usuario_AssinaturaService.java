package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.model.Usuario_Assinatura;
import com.leonardoramos.assinaturas.repository.Usuario_AssinaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class Usuario_AssinaturaService {

    private final Usuario_AssinaturaRepository usuarioAssinaturaRepository;

    public Usuario_AssinaturaService(Usuario_AssinaturaRepository usuarioAssinaturaRepository) {
        this.usuarioAssinaturaRepository = usuarioAssinaturaRepository;
    }

    public Usuario_Assinatura buscarPorId(String id) {
        return usuarioAssinaturaRepository.findById(UUID.fromString(id)).orElse(null);
    }

    public List<Usuario_Assinatura> buscarTodos(){
        return usuarioAssinaturaRepository.findAll();
    }

    public Usuario_Assinatura criar(Usuario_Assinatura usuarioAssinatura){
        return usuarioAssinaturaRepository.save(usuarioAssinatura);
    }

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

    public void deletar(String id){
        usuarioAssinaturaRepository.deleteById(UUID.fromString(id));
    }
}
