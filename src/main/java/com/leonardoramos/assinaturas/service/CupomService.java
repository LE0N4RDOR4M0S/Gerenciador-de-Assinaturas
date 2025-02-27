package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.model.Cupom;
import com.leonardoramos.assinaturas.repository.CupomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CupomService {

    private final CupomRepository cupomRepository;

    public CupomService(CupomRepository cupomRepository) {
        this.cupomRepository = cupomRepository;
    }

    public Cupom buscarPorID(String id) {
        return cupomRepository.findById(UUID.fromString(id)).orElse(null);
    }

    public List<Cupom> buscarTodos() {
        return cupomRepository.findAll();
    }

    public Cupom criar(Cupom cupom) {
        return cupomRepository.save(cupom);
    }

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

    public void deletar(String id) {
        cupomRepository.deleteById(UUID.fromString(id));
    }
}
