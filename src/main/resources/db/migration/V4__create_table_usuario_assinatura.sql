CREATE TYPE status_assinatura AS ENUM ('ativo', 'expirado', 'cancelado');

CREATE TABLE assinatura_usuario
(
    id UUID,
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP NOT NULL,
    status status_assinatura NOT NULL,
    id_usuario UUID NOT NULL,
    id_assinatura UUID NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_usuario_TO_assinatura_usuario
        FOREIGN KEY (id_usuario)
            REFERENCES usuario(id),
    CONSTRAINT FK_assinatura_TO_assinatura_usuario
        FOREIGN KEY (id_assinatura)
            REFERENCES assinatura(id)
);