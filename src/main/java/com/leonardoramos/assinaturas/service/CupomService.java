package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.model.Cupom;
import com.leonardoramos.assinaturas.repository.CupomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Classe de serviço para cupons
 */
@Service
public class CupomService {

    private final CupomRepository cupomRepository;

    public CupomService(CupomRepository cupomRepository) {
        this.cupomRepository = cupomRepository;
    }

    /**
     * Busca um cupom pelo id
     * @param id id do cupom em String
     * @return Cupom correspondente ao id
     * @throws IllegalArgumentException caso o id seja inválido
     */
    public Cupom buscarPorID(String id) {
        return cupomRepository.findById(UUID.fromString(id)).orElse(null);
    }

    /**
     * Busca todos os cupons
     * @return Lista de cupons
     */
    public List<Cupom> buscarTodos() {
        return cupomRepository.findAll();
    }

    /**
     * Cria um novo cupom
     * @param cupom cupom a ser criado
     * @return Cupom criado
     * @throws IllegalArgumentException caso o cupom seja inválido
     */
    public Cupom criar(Cupom cupom) {
        return cupomRepository.save(cupom);
    }

    /**
     * Atualiza um cupom
     * @param cupom cupom a ser atualizado
     * @param id id do cupom a ser atualizado
     * @return Cupom atualizado
     * @throws IllegalArgumentException caso o cupom seja inválido
     */
    public Cupom atualizar(Cupom cupom, String id) {
        Cupom cupomAtual = cupomRepository.findById(UUID.fromString(id)).orElse(null);
        if (cupomAtual == null) {
            return null;
        }
        cupomAtual.setCodigo(cupom.getCodigo());
        cupomAtual.setDesconto_percentual(cupom.getDesconto_percentual());
        cupomAtual.setExpiracao(cupom.getExpiracao());
        cupomAtual.setAtivo(cupom.isAtivo());
        cupomAtual.setAssinatura(cupom.getAssinatura());
        return cupomRepository.save(cupomAtual);
    }

    /**
     * Deleta um cupom
     * @param id id do cupom a ser deletado
     */
    public void deletar(String id) {
        cupomRepository.deleteById(UUID.fromString(id));
    }
}
