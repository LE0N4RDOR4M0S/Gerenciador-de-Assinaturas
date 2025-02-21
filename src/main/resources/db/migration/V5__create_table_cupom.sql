CREATE TABLE cupom(
    id UUID,
    codigo VARCHAR NOT NULL,
    desconto_percentual DECIMAL NOT NULL,
    expiracao TIMESTAMP NULL,
    id_assinatura UUID,
    PRIMARY KEY (id),
    CONSTRAINT FK_assinatura_TO_cupom
        FOREIGN KEY (id_assinatura)
            REFERENCES assinatura(id)
);
