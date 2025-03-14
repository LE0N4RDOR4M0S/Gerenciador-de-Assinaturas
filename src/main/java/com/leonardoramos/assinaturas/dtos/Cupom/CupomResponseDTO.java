package com.leonardoramos.assinaturas.dtos.Cupom;

import com.leonardoramos.assinaturas.dtos.Assinatura.AssinaturaResponseDTO;
import com.leonardoramos.assinaturas.model.Cupom;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@Schema(name = "CupomReponseDTO", description = "DTO para response de cupom")
public class CupomResponseDTO {
    @Schema(description = "ID do cupom", example = "123e4567-e89b-12d3-a456-426614174000")
    private String id;

    @Schema(description = "Código do cupom", example = "CUPOM10")
    private String codigo;

    @Schema(description = "Valor do cupom", example = "10")
    private String descontoPercentual;

    @Schema(description = "Data de validade do cupom", example = "2022-12-31T23:59:59")
    private String dataValidade;

    @Schema(description = "Validade do cupom", example = "false")
    private Boolean ativo;

    @Schema(description = "Assinatura para qual o cupom é válido")
    private AssinaturaResponseDTO assinatura;

    public static CupomResponseDTO fromModel(Cupom cupom) {
        return CupomResponseDTO.builder()
                .id(cupom.getId().toString())
                .codigo(cupom.getCodigo())
                .descontoPercentual(String.valueOf(cupom.getDesconto_percentual()))
                .dataValidade(cupom.getExpiracao().toString())
                .ativo(cupom.isAtivo())
                .assinatura(AssinaturaResponseDTO.fromModel(cupom.getAssinatura()))
                .build();
    }

    public static List<CupomResponseDTO> fromModel(List<Cupom> cupons) {
        return cupons.stream().map(CupomResponseDTO::fromModel).collect(Collectors.toList());
    }

}
