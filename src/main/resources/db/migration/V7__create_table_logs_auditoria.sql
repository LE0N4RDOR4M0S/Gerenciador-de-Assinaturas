CREATE TABLE logs_auditoria
(
    id UUID PRIMARY KEY,
    operacao TEXT NOT NULL,
    entidade VARCHAR NOT NULL,
    data_hora TIMESTAMP NOT NULL,
    usuario VARCHAR NOT NULL
);