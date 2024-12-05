CREATE TABLE produtos (
    produto_id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco NUMERIC(10, 2) NOT NULL CHECK (preco >= 0),
    estoque INT NOT NULL DEFAULT 0 CHECK (estoque >= 0),
    categoria_id INT REFERENCES categorias(categoria_id) ON DELETE SET NULL,
    marca VARCHAR(100),
    cor VARCHAR(50),
    tamanho VARCHAR(50),
    peso NUMERIC(5, 2) CHECK (peso >= 0),
    material VARCHAR(100),
    data_criacao TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
);
