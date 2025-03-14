package com.leonardoramos.assinaturas.dtos.Pagamento;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@Schema(name = "PagamentoRequestDTO", description = "DTO para requisição de pagamentos")
public class PagamentoRequestDTO {
    @Schema(description = "Valor do pagamento", example = "10.00")
    private double valor;

    @Schema(description = "Método de pagamento", example = "CARTAO_CREDITO")
    private String metodo_pagamento;

    @Schema(description = "Status do pagamento", example = "PENDENTE")
    private String status_pagamento;

    @Schema(description = "Data do pagamento", example = "2022-12-31T23:59:59")
    private String data_pagamento;

    @Schema(description = "Assinatura para qual o pagamento foi realizado", example = "123e4567-e89b-12d3-a456-426614174000")
    private String assinatura;

    @Schema(description = "Usuário que realizou o pagamento", example = "123e4567-e89b-12d3-a456-426614174000")
    private String usuario;
}
