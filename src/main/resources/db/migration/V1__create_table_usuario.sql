CREATE TABLE usuario
(
  id UUID,
  nome VARCHAR NOT NULL,
  email VARCHAR NOT NULL,
  senha VARCHAR NOT NULL,
  data_criacao TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);