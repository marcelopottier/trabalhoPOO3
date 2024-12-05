CREATE TABLE categorias (
    categoria_id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    data_criacao TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);
