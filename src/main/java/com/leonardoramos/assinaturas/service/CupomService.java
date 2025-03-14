package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.dtos.Cupom.CupomRequestDTO;
import com.leonardoramos.assinaturas.dtos.Cupom.CupomResponseDTO;
import com.leonardoramos.assinaturas.model.Cupom;
import com.leonardoramos.assinaturas.repository.CupomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Classe de serviço para cupons
 */
@Service
public class CupomService {

    private final CupomRepository cupomRepository;
    private final AssinaturaService assinaturaService;

    public CupomService(CupomRepository cupomRepository, AssinaturaService assinaturaService) {
        this.cupomRepository = cupomRepository;
        this.assinaturaService = assinaturaService;
    }

    /**
     * Busca um cupom pelo id
     * @param id id do cupom em String
     * @return Cupom correspondente ao id
     * @throws IllegalArgumentException caso o id seja inválido
     */
    public CupomResponseDTO buscarPorID(String id) {
        return CupomResponseDTO.fromModel(Objects.requireNonNull(
                cupomRepository.findById(UUID.fromString(id)).orElse(null)));
    }

    /**
     * Busca todos os cupons
     * @return Lista de cupons
     */
    public List<CupomResponseDTO> buscarTodos() {
        return CupomResponseDTO.fromModel(cupomRepository.findAll());
    }

    /**
     * Cria um novo cupom
     * @param cupomDTO cupom a ser criado
     * @return Cupom criado
     * @throws IllegalArgumentException caso o cupom seja inválido
     */
    public CupomResponseDTO criar(CupomRequestDTO cupomDTO) {
        return CupomResponseDTO.fromModel(
                cupomRepository.save(cupomDTO.toModel()));
    }

    /**
     * Atualiza um cupom
     * @param cupomDTO cupom a ser atualizado
     * @param id id do cupom a ser atualizado
     * @return Cupom atualizado
     * @throws IllegalArgumentException caso o cupom seja inválido
     */
    public CupomResponseDTO atualizar(CupomRequestDTO cupomDTO, String id) {
        Cupom cupomAtual = cupomRepository.findById(UUID.fromString(id)).orElse(null);
        assert cupomAtual != null;
        cupomAtual.setCodigo(cupomDTO.getCodigo());
        cupomAtual.setDesconto_percentual(cupomDTO.getDesconto_percentual());
        cupomAtual.setExpiracao(cupomDTO.getExpiracao());
        cupomAtual.setAtivo(cupomDTO.isAtivo());
        cupomAtual.setAssinatura(assinaturaService
                                    .buscarPorIdModel(cupomDTO.getAssinatura()));
        return CupomResponseDTO.fromModel(
                cupomRepository.save(cupomAtual));
    }

    /**
     * Deleta um cupom
     * @param id id do cupom a ser deletado
     */
    public void deletar(String id) {
        cupomRepository.deleteById(UUID.fromString(id));
    }
}
