package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.dtos.Assinatura.AssinaturaRequestDTO;
import com.leonardoramos.assinaturas.dtos.Assinatura.AssinaturaResponseDTO;
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
    public AssinaturaResponseDTO buscarPorId(String id){
        Assinatura assinatura = assinaturaRepository.findById(UUID.fromString(id)).orElse(null);
        assert assinatura != null;
        return AssinaturaResponseDTO.fromModel(assinatura);
    }

    /**
     * Busca todas as assinaturas
     * @return Lista de assinaturas
     */
    public List<AssinaturaResponseDTO> buscarTodas(){
        List<Assinatura> assinaturas = assinaturaRepository.findAll();
        return AssinaturaResponseDTO.fromModel(assinaturas);
    }

    /**
     * Cria uma nova assinatura
     * @param assinaturaDTO assinatura a ser criada
     * @return Assinatura criada
     * @throws IllegalArgumentException caso a assinatura seja inválida
     */
    public AssinaturaResponseDTO criar(AssinaturaRequestDTO assinaturaDTO){
        Assinatura assinatura = assinaturaDTO.toModel();
        return AssinaturaResponseDTO.fromModel(assinaturaRepository.save(assinatura));
    }

    /**
     * Atualiza uma assinatura
     * @param id id da assinatura a ser atualizada
     * @param novaAssinatura nova assinatura
     * @return Assinatura atualizada
     * @throws IllegalArgumentException caso a assinatura seja inválida
     */
    public AssinaturaResponseDTO atualizar(String id, AssinaturaRequestDTO novaAssinatura) {
        Assinatura assinatura = assinaturaRepository.findById(UUID.fromString(id)).orElse(null);
        if (assinatura != null) {
            assinatura.setNome(novaAssinatura.getNome());
            assinatura.setDescricao(novaAssinatura.getDescricao());
            assinatura.setPreco(novaAssinatura.getPreco());
            assinatura.setLimit_usuario(novaAssinatura.getLimit_usuario());
            assinatura.setDuracao_dias(novaAssinatura.getDuracao_dias());
//            assinatura.setCategoria(novaAssinatura.getCategoria());TODO: Implementar o DTO de Categoria para atualizar
        }
        assert assinatura != null;
        return AssinaturaResponseDTO.fromModel(assinaturaRepository.save(assinatura));
    }

    /**
     * Deleta uma assinatura
     * @param id id da assinatura a ser deletada
     * @throws EmptyResultDataAccessException se a assinatura não existir
     */
    public void deletar(String id){
        assinaturaRepository.deleteById(UUID.fromString(id));
    }

    public Assinatura buscarPorIdModel(String id){
        return assinaturaRepository.findById(UUID.fromString(id)).orElse(null);
    }
}

