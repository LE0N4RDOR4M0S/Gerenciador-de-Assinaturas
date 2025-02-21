CREATE TABLE assinatura(
    id UUID,
    nome VARCHAR NOT NULL,
    limite_usuario INT NOT NULL    ,
    preco DECIMAL NOT NULL,
    duracao_dias INT NOT NULL,
    descricao TEXT NOT NULL,
    categoria_id UUID NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_categoria_TO_assinatura
        FOREIGN KEY (categoria_id)
            REFERENCES categoria(id)
);
