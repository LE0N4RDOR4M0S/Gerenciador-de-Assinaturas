package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.model.Pagamento;
import com.leonardoramos.assinaturas.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Classe de serviço para pagamentos
 */
@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    /**
     * Busca um pagamento pelo id
     * @param id id do pagamento em String
     * @return Pagamento correspondente ao id
     * @throws IllegalArgumentException caso o id seja inválido
     */
    public Pagamento buscarPorID(String id) {
        return pagamentoRepository.findById(UUID.fromString(id)).orElse(null);
    }

    /**
     * Busca todos os pagamentos
     * @return Lista de pagamentos
     */
    public List<Pagamento> buscarTodos() {
        return pagamentoRepository.findAll();
    }

    /**
     * Cria um novo pagamento
     * @param pagamento pagamento a ser criado
     * @return Pagamento criado
     * @throws IllegalArgumentException caso o pagamento seja inválido
     */
    public Pagamento criar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    /**
     * Atualiza um pagamento
     * @param pagamento pagamento a ser atualizado
     * @param id id do pagamento a ser atualizado
     * @return Pagamento atualizado
     * @throws IllegalArgumentException caso o pagamento seja inválido
     */
    public Pagamento atualizar(Pagamento pagamento, String id) {
        Pagamento pagamentoAtual = pagamentoRepository.findById(UUID.fromString(id)).orElse(null);
        if (pagamentoAtual != null) {
            pagamentoAtual.setMetodo_pagamento(pagamento.getMetodo_pagamento());
            pagamentoAtual.setStatus_pagamento(pagamento.getStatus_pagamento());
            pagamentoAtual.setData_pagamento(pagamento.getData_pagamento());
            pagamentoAtual.setAssinatura(pagamento.getAssinatura());
            pagamentoAtual.setUsuario(pagamento.getUsuario());
            pagamentoAtual.setValor(pagamento.getValor());
            return pagamentoRepository.save(pagamentoAtual);
        }
        return null;
    }

    /**
     * Deleta um pagamento
     * @param id id do pagamento a ser deletado
     */
    public void deletar(String id) {
        pagamentoRepository.deleteById(UUID.fromString(id));
    }
}
