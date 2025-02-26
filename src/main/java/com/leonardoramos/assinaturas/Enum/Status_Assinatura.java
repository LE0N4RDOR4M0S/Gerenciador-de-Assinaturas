package com.leonardoramos.assinaturas.Enum;

public enum Status_Assinatura {
    ATIVO("ativo"),
    EXPIRADO("expirado"),
    CANCELADO("cancelado");

    private final String value;

    Status_Assinatura() {
        this.value = "ativo";
    }

    Status_Assinatura(String value) {
        this.value = value;
    }

    Status_Assinatura(int i) {
        this.value = switch (i) {
            case 0 -> "ativo";
            case 1 -> "expirado";
            case 2 -> "cancelado";
            default -> throw new IllegalArgumentException("Valor de status para assinatura inválido: " + i);
        };
    }

    public String getValue() {
        return value;
    }
}
