package com.leonardoramos.assinaturas.dtos.Pagamento;

import com.leonardoramos.assinaturas.dtos.Assinatura.AssinaturaResponseDTO;
import com.leonardoramos.assinaturas.model.Pagamento;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@Schema(name = "PagamentoResponseDTO", description = "DTO para response de pagamentos")
public class PagamentoResponseDTO {
    @Schema(description = "ID do pagamento", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Valor do pagamento", example = "10.00")
    private double valor;

    @Schema(description = "Método de pagamento", example = "CARTAO_CREDITO")
    private String metodoPagamento;

    @Schema(description = "Status do pagamento", example = "PENDENTE")
    private String statusPagamento;

    @Schema(description = "Data do pagamento", example = "2022-12-31T23:59:59")
    private String dataPagamento;

    @Schema(description = "Assinatura para qual o pagamento foi realizado")
    private AssinaturaResponseDTO assinaturaResponseDTO;

    @Schema(description = "Usuário que realizou o pagamento")
    private String usuario;//TODO: Implementar DTO de Usuário

    public static PagamentoResponseDTO fromModel(Pagamento pagamento) {
        return PagamentoResponseDTO.builder()
                .id(pagamento.getId().toString())
                .valor(pagamento.getValor())
                .metodoPagamento(pagamento.getMetodo_pagamento().toString())
                .statusPagamento(pagamento.getStatus_pagamento().toString())
                .dataPagamento(pagamento.getData_pagamento().toString())
                .assinaturaResponseDTO(AssinaturaResponseDTO.fromModel(pagamento.getAssinatura()))
                .usuario(pagamento.getUsuario().toString())
                .build();
    }

    public static List<PagamentoResponseDTO> fromModel(List<Pagamento> pagamentos) {
        return pagamentos.stream().map(PagamentoResponseDTO::fromModel).collect(Collectors.toList());
    }
}
