CREATE TYPE metodo_pagamento AS ENUM ('cartao_credito', 'boleto', 'pix');
CREATE TYPE status_pagamento AS ENUM ('pendente', 'confirmado', 'cancelado','falhado');
CREATE TABLE pagamento(
    id UUID,
    valor DECIMAL NOT NULL,
    id_usuario UUID NOT NULL,
    id_assinatura UUID NOT NULL,
    metodo_pagamento metodo_pagamento NOT NULL,
    status status_pagamento NOT NULL,
    data_pagamento TIMESTAMP NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_usuario_TO_pagamento
        FOREIGN KEY (id_usuario)
            REFERENCES usuario (id),
    CONSTRAINT FK_assinatura_TO_pagamento
        FOREIGN KEY (id_assinatura)
            REFERENCES assinatura (id)
);