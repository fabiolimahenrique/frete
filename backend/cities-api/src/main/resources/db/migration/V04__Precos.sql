DROP TABLE IF EXISTS "preco" CASCADE;

CREATE TABLE preco (
  id     bigserial NOT NULL,
  faixa1   bigserial,
  faixa2   bigserial,
  valor numeric(19,2),
  /* Keys */
  CONSTRAINT preco_pkey
    PRIMARY KEY (id)
);

INSERT INTO "preco" (id, faixa1, faixa2, valor) VALUES
(1, 1, 500, 10500),
(2, 501, 1000, 20100),
(3, 1001, 2000, 30189),
(4, 2001, 5000, 40900),
(5, 5001, 50000, 130600)