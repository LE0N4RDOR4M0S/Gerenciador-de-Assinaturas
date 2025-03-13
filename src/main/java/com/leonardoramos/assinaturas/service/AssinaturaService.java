package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.model.Assinatura;
import com.leonardoramos.assinaturas.repository.AssinaturaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Classe de serviço para assinaturas
 */
@Service
public class AssinaturaService {

    private final AssinaturaRepository assinaturaRepository;

    public AssinaturaService(AssinaturaRepository assinaturaRepository){
        this.assinaturaRepository = assinaturaRepository;
    }

    /**
     *  Busca uma assinatura pelo id
     * @param id id da assinatura em String
     * @return Assinatura correspondente ao id
     * @throws IllegalArgumentException caso o id seja inválido
     */
    public Assinatura buscarPorId(String id){
        return assinaturaRepository.findById(UUID.fromString(id)).orElse(null);
    }

    /**
     * Busca todas as assinaturas
     * @return Lista de assinaturas
     */
    public List<Assinatura> buscarTodas(){
        return assinaturaRepository.findAll();
    }

    /**
     * Cria uma nova assinatura
     * @param assinatura assinatura a ser criada
     * @return Assinatura criada
     * @throws IllegalArgumentException caso a assinatura seja inválida
     */
    public Assinatura criar(Assinatura assinatura){
        return assinaturaRepository.save(assinatura);
    }

    /**
     * Atualiza uma assinatura
     * @param id id da assinatura a ser atualizada
     * @param novaAssinatura nova assinatura
     * @return Assinatura atualizada
     * @throws IllegalArgumentException caso a assinatura seja inválida
     */
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

    /**
     * Deleta uma assinatura
     * @param id id da assinatura a ser deletada
     * @throws EmptyResultDataAccessException se a assinatura não existir
     */
    public void deletar(String id){
        assinaturaRepository.deleteById(UUID.fromString(id));
    }
}

