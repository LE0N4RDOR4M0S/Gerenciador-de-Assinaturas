package com.leonardoramos.assinaturas.service;

import com.leonardoramos.assinaturas.Enum.MetodoPagamento;
import com.leonardoramos.assinaturas.Enum.StatusPagamento;
import com.leonardoramos.assinaturas.dtos.Pagamento.PagamentoRequestDTO;
import com.leonardoramos.assinaturas.dtos.Pagamento.PagamentoResponseDTO;
import com.leonardoramos.assinaturas.model.Pagamento;
import com.leonardoramos.assinaturas.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Classe de serviço para pagamentos
 */
@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final AssinaturaService assinaturaService;
    private final UsuarioService usuarioService;

    public PagamentoService(PagamentoRepository pagamentoRepository, AssinaturaService assinaturaService, UsuarioService usuarioService) {
        this.pagamentoRepository = pagamentoRepository;
        this.assinaturaService = assinaturaService;
        this.usuarioService = usuarioService;
    }

    /**
     * Busca um pagamento pelo id
     * @param id id do pagamento em String
     * @return Pagamento correspondente ao id
     * @throws IllegalArgumentException caso o id seja inválido
     */
    public PagamentoResponseDTO buscarPorID(String id) {
        return PagamentoResponseDTO.fromModel(Objects.requireNonNull(
                pagamentoRepository.findById(UUID.fromString(id)).orElse(null)));
    }

    /**
     * Busca todos os pagamentos
     * @return Lista de pagamentos
     */
    public List<PagamentoResponseDTO> buscarTodos() {
        return PagamentoResponseDTO.fromModel(pagamentoRepository.findAll());
    }

    /**
     * Cria um novo pagamento
     * @param pagamentoDTO pagamento a ser criado
     * @return Pagamento criado
     * @throws IllegalArgumentException caso o pagamento seja inválido
     */
    public PagamentoResponseDTO criar(PagamentoRequestDTO pagamentoDTO) {
        Pagamento pagamento = DTOToModel(pagamentoDTO);
        return PagamentoResponseDTO.fromModel(pagamentoRepository.save(pagamento));
    }

    /**
     * Atualiza um pagamento
     * @param pagamento pagamento a ser atualizado
     * @param id id do pagamento a ser atualizado
     * @return Pagamento atualizado
     * @throws IllegalArgumentException caso o pagamento seja inválido
     */
    public PagamentoResponseDTO atualizar(PagamentoRequestDTO pagamento, String id) {
        Pagamento pagamentoAtual = pagamentoRepository.findById(UUID.fromString(id)).orElse(null);
        if (pagamentoAtual != null) {
            pagamentoAtual.setMetodo_pagamento(MetodoPagamento.valueOf(pagamento.getMetodo_pagamento()));
            pagamentoAtual.setStatus_pagamento(StatusPagamento.valueOf(pagamento.getStatus_pagamento()));
            pagamentoAtual.setData_pagamento(Timestamp.valueOf(pagamento.getData_pagamento()));
            pagamentoAtual.setAssinatura(assinaturaService.buscarPorIdModel(pagamento.getAssinatura()));
            pagamentoAtual.setUsuario(usuarioService.buscarPorIDModel(pagamento.getUsuario()));
            pagamentoAtual.setValor(pagamento.getValor());
            return PagamentoResponseDTO.fromModel(pagamentoRepository.save(pagamentoAtual));
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


    /**
     * Converte um PagamentoRequestDTO para um Pagamento
     * @param pagamentoDTO DTO a ser convertido
     * @return Pagamento convertido
     */
    public Pagamento DTOToModel(PagamentoRequestDTO pagamentoDTO) {
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(pagamentoDTO.getValor());
        pagamento.setMetodo_pagamento(MetodoPagamento.valueOf(pagamentoDTO.getMetodo_pagamento()));
        pagamento.setStatus_pagamento(StatusPagamento.valueOf(pagamentoDTO.getStatus_pagamento()));
        pagamento.setData_pagamento(Timestamp.valueOf(pagamentoDTO.getData_pagamento()));
        pagamento.setAssinatura(assinaturaService.buscarPorIdModel(pagamentoDTO.getAssinatura()));
        pagamento.setUsuario(usuarioService.buscarPorIDModel(pagamentoDTO.getUsuario()));
        return pagamento;
    }
}
