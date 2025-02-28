package com.leonardoramos.assinaturas.Enum;

public enum StatusPagamento {
    PENDENTE("pendente"),
    CONFIRMADO("confirmado"),
    CANCELADO("cancelado"),
    FALHADO("falhado");

    private final String value;

    StatusPagamento() {
        this.value = "pendente";
    }

    StatusPagamento(String value) {
        this.value = value;
    }

    StatusPagamento(int i) {
        this.value = switch (i) {
            case 0 -> "pendente";
            case 1 -> "confirmado";
            case 2 -> "cancelado";
            case 3 -> "falhado";
            default -> throw new IllegalArgumentException("Valor de status de pagamento inválido: " + i);
        };
    }

    public String getValue() {
        return value;
    }
}
