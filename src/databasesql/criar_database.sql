CREATE DATABASE Aluguel_Vestido

USE Aluguel_Vestido

CREATE TABLE vestido(
	id						INT					NOT NULL,
	tamanho					INT					NOT NULL,
	cor						VARCHAR(20)			NOT NULL,
	marca					VARCHAR(40)			NOT NULL,
	finalidade				VARCHAR(50)			NOT NULL,
	disponivel				BIT					NOT NULL,
	valor					DECIMAL(5, 2)		NOT NULL,
	PRIMARY KEY(id)
)

CREATE TABLE estoque(
	vestidoID				INT					NOT NULL,
	quantidade				INT					NOT NULL
	FOREIGN KEY(vestidoID)	REFERENCES 	vestido(id)
)

CREATE TABLE pessoa(
	cpf						CHAR(11)			NOT NULL,
	senha					VARCHAR(50)			NOT NULL,
	nome					VARCHAR(20)			NOT NULL,
	sobrenome				VARCHAR(100)		NOT NULL,
	end_cep					VARCHAR(8)			NOT NULL,
	end_logradouro			VARCHAR(100)		NOT NULL,
	end_numero				VARCHAR(10)			NOT NULL,
	end_complemento			VARCHAR(30)
	PRIMARY KEY(cpf)
)

CREATE TABLE cliente(
	pessoaCPF				CHAR(11)			NOT NULL,
	email					VARCHAR(60)			NOT NULL
	PRIMARY KEY(pessoaCPF)
	FOREIGN KEY(pessoaCPF)	REFERENCES	pessoa(cpf)	
)

CREATE TABLE telefone_cliente(
	clienteCPF				CHAR(11)			NOT NULL,
	ddd						VARCHAR(2)			NOT NULL,
	numero					VARCHAR(9)			NOT NULL
	PRIMARY KEY(clienteCPF)
	FOREIGN KEY(clienteCPF)	REFERENCES	cliente(pessoaCPF)
)

CREATE TABLE funcionario(
	pessoaCPF				CHAR(11)			NOT NULL,
	salario					DECIMAL(6,2)		NOT NULL
	PRIMARY KEY(pessoaCPF)
	FOREIGN KEY(pessoaCPF)	REFERENCES	pessoa(cpf)
)

CREATE TABLE aluguel(
	id						INT					NOT NULL,
	clientePessoaCPF		CHAR(11)			NOT NULL,
	vestidoID				INT					NOT NULL,
	data_retirada			DATE				NOT NULL,
	data_devolucao			DATE				NOT NULL
	PRIMARY KEY(id)
	FOREIGN KEY(clientePessoaCPF)	REFERENCES cliente(pessoaCPF),
	FOREIGN KEY(vestidoID)			REFERENCES vestido(id)
)

CREATE TABLE pagamento(
	aluguelIID				INT					NOT NULL,
	total_pagar				DECIMAL(6,2)		NOT NULL,
	data_pagamento			DATE				NOT NULL,
	status					VARCHAR(20)			NOT NULL
	PRIMARY KEY(aluguelIID)	
	FOREIGN KEY (aluguelIID)	REFERENCES	aluguel(id)
)

USE Aluguel_Vestido;

-- Inserir dados na tabela pessoa
INSERT INTO pessoa (cpf, senha, nome, sobrenome, end_cep, end_logradouro, end_numero, end_complemento)
VALUES 
('12345678901', 'senha123', 'Maria', 'Silva', '12345678', 'Rua A', '100', 'Apto 101'),
('98765432100', 'senha456', 'João', 'Santos', '87654321', 'Rua B', '200', NULL),
('11122233344', 'senha789', 'Ana', 'Oliveira', '11223344', 'Rua C', '300', 'Casa');

-- Inserir dados na tabela cliente
INSERT INTO cliente (pessoaCPF, email)
VALUES 
('12345678901', 'maria.silva@example.com'),
('98765432100', 'joao.santos@example.com');

-- Inserir dados na tabela funcionario
INSERT INTO funcionario (pessoaCPF, salario)
VALUES 
('11122233344', 3000.00);

-- Inserir dados na tabela vestido
INSERT INTO vestido (id, tamanho, cor, marca, finalidade, disponivel, valor)
VALUES 
(1, 38, 'Vermelho', 'Marca A', 'Festa', 1, 150.00),
(2, 40, 'Azul', 'Marca B', 'Casual', 1, 120.00),
(3, 42, 'Preto', 'Marca C', 'Gala', 0, 200.00);

-- Inserir dados na tabela estoque
INSERT INTO estoque (vestidoID, quantidade)
VALUES 
(1, 10),
(2, 5),
(3, 2);

-- Inserir dados na tabela telefone_cliente
INSERT INTO telefone_cliente (clienteCPF, ddd, numero)
VALUES 
('12345678901', '11', '987654321'),
('98765432100', '21', '912345678');

-- Inserir dados na tabela aluguel
INSERT INTO aluguel (id, clientePessoaCPF, vestidoID, data_retirada, data_devolucao)
VALUES 
(1, '12345678901', 1, '2023-01-10', '2023-01-17'),
(2, '98765432100', 2, '2023-02-15', '2023-02-20');

-- Inserir dados na tabela pagamento
INSERT INTO pagamento (aluguelIID, total_pagar, data_pagamento, status)
VALUES 
(1, 1050.00, '2023-01-17', 'Pago'),
(2, 600.00, '2023-02-20', 'Pago');