package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.model.Assinatura;
import com.leonardoramos.assinaturas.repository.AssinaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AssinaturaService {

    private final AssinaturaRepository assinaturaRepository;

    public AssinaturaService(AssinaturaRepository assinaturaRepository){
        this.assinaturaRepository = assinaturaRepository;
    }

    public Assinatura buscarPorId(String id){
        return assinaturaRepository.findById(UUID.fromString(id)).orElse(null);
    }

    public List<Assinatura> buscarTodas(){
        return assinaturaRepository.findAll();
    }

    public Assinatura criar(Assinatura assinatura){
        return assinaturaRepository.save(assinatura);
    }

    public Assinatura atualizar(String id, Assinatura novaAssinatura) {
        Assinatura assinatura = assinaturaRepository.findById(UUID.fromString(id)).orElse(null);
        if (assinatura != null) {
            assinatura.setNome(novaAssinatura.getNome());
            assinatura.setDescricao(novaAssinatura.getDescricao());
            assinatura.setPreco(novaAssinatura.getPreco());
            assinatura.setLimit_usuario(novaAssinatura.getLimit_usuario());
            assinatura.setDuracao_dias(novaAssinatura.getDuracao_dias());
            assinatura.setCategoria(novaAssinatura.getCategoria());
        }
        return assinaturaRepository.save(assinatura);
    }

    public void deletar(String id){
        assinaturaRepository.deleteById(UUID.fromString(id));
    }
}

