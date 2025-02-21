CREATE TABLE logs_auditoria
(
    id UUID,
    acao TEXT NOT NULL,
    data TIMESTAMP NOT NULL,
    id_usuario UUID NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_usuario_TO_auditoria
        FOREIGN KEY (id_usuario)
            REFERENCES usuario(id)
);