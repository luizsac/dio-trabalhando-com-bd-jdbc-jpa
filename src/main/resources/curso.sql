CREATE TABLE IF NOT EXISTS curso (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(80) NOT NULL,
	duracao_horas INT NOT NULL
);

INSERT INTO curso (nome, duracao_horas) VALUES ('PostgreSQL', 9);
INSERT INTO curso (nome, duracao_horas) VALUES ('Programação em Java Básico', 8);
INSERT INTO curso (nome, duracao_horas) VALUES ('Streams e Collections', 6);
INSERT INTO curso (nome, duracao_horas) VALUES ('Git e GitHub', 2);

SELECT id, nome, duracao_horas FROM curso;