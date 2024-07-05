create database oficinaPolaco;

use oficinaPolaco;

create table Cliente(
nome varchar(100) not null,
rg varchar(15)not null,
cpf VARCHAR(15)not null primary key,
telefone VARCHAR(15)not null,
rua varchar(100) not null,
numero int(6) not null,
cep varchar(10)not null,
bairro varchar(20) not null,
cidade varchar(20) not null,
estado varchar(5)not null
);

create table Veiculo(
idVeiculo int(10) not null auto_increment primary key,
fabricante varchar(20)not null,
modelo varchar(20)not null,
anoFabricacao int(4)not null,
anoModelo int(4)not null,
hodometroAnterior int(6)not null,
placa varchar(7)not null,
cpfCliente VARCHAR(15)not null,
key fk_Cliente(cpfCliente),
constraint foreign key(cpfCliente) references Cliente(cpf));

create table Orcamento(
idOrcamento int not null primary key auto_increment,
hodometroAntigo int(10)not null,
hodometroAtual int(10) not null,
dataServico date not null,
veiculoId int not null,
key fk_Veiculo(veiculoId),
constraint foreign key(veiculoId) references Veiculo(idVeiculo)
);

create table Peca(
idPeca int(10) not null primary key auto_increment,
descricao varchar(200) not null,
valorUnitario decimal(8,2)not null,
quantidade decimal(8,2)not null,
porcento int(4)not null,
orcamentoId int not null,
valorTotal decimal(8,2)not null,
valorPunt decimal(8,2)not null,
key fk_Orcamento(orcamentoId),
constraint foreign key(orcamentoId) references Orcamento(idOrcamento));

create table Funcionario(
nome varchar(100) not null,
cpf varchar(15) not null primary key,
login varchar(30),
senha varchar(30),
descPessoa varchar(30));

select * from Cliente;

select * from veiculo;

select * from orcamento;

select * from peca;

SELECT oficinapolaco.orcamento.`idOrcamento`,
	oficinapolaco.orcamento.`hodometroAntigo`,
	oficinapolaco.orcamento.`hodometroAtual`,
	oficinapolaco.orcamento.`dataServico`,
	oficinapolaco.orcamento.`dataServico`,
	oficinapolaco.peca.descricao,
	oficinapolaco.peca.`valorUnitario`,
	oficinapolaco.peca.`valorTotal`,
	oficinapolaco.peca.quantidade,
	oficinapolaco.peca.porcento,
	oficinapolaco.veiculo.placa,
	oficinapolaco.veiculo.modelo,
	oficinapolaco.veiculo.`anoModelo`,
	oficinapolaco.veiculo.`anoFabricacao`,
	oficinapolaco.veiculo.fabricante,
	oficinapolaco.cliente.nome,
	oficinapolaco.cliente.cpf,
	oficinapolaco.cliente.telefone,
	oficinapolaco.cliente.rua,
	oficinapolaco.cliente.numero,
	oficinapolaco.cliente.cep
FROM oficinapolaco.peca
	INNER JOIN oficinapolaco.orcamento ON 
	 oficinapolaco.peca.`orcamentoId` = oficinapolaco.orcamento.`idOrcamento` 
	INNER JOIN oficinapolaco.veiculo ON 
	 oficinapolaco.orcamento.`veiculoId` = oficinapolaco.veiculo.`idVeiculo` 
	INNER JOIN oficinapolaco.cliente ON 
	 oficinapolaco.cliente.cpf = oficinapolaco.veiculo.`cpfCliente` 
WHERE 
	 oficinapolaco.orcamento.`idOrcamento` = 6