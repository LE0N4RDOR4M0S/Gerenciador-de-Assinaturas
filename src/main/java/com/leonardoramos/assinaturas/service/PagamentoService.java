package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.model.Pagamento;
import com.leonardoramos.assinaturas.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento buscarPorID(String id) {
        return pagamentoRepository.findById(UUID.fromString(id)).orElse(null);
    }

    public List<Pagamento> buscarTodos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento criar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

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

    public void deletar(String id) {
        pagamentoRepository.deleteById(UUID.fromString(id));
    }
}
