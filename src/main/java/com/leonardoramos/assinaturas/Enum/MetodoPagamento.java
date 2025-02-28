package com.leonardoramos.assinaturas.Enum;

public enum MetodoPagamento {
    CARTAO_CREDITO("cartao_credito"),
    BOLETO("boleto"),
    PIX("pix");

    private final String value;

    MetodoPagamento() {
        this.value = "cartao_credito";
    }

    MetodoPagamento(String value) {
        this.value = value;
    }

    MetodoPagamento(int i) {
        this.value = switch (i) {
            case 0 -> "cartao_credito";
            case 1 -> "boleto";
            case 2 -> "pix";
            default -> throw new IllegalArgumentException("Valor de método de pagamento inválido: " + i);
        };
    }

    public String getValue() {
        return value;
    }
}