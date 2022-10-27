create table cliente(
    numero_telefone varchar(12) not null,
    nome varchar(50) not null,
    primary key (numero_telefone)
);

create table funcionario(
    id smallint not null auto_increment,
    nome varchar(25) not null,
    sobrenome varchar(25) not null,
    numero_telefone varchar(12) not null unique,
    password varchar(100) not null,
    primary key(id)
);

create table pedido(
    id int not null auto_increment,
    cliente_id varchar(12) not null references cliente(numero_telefone),
    status enum('CRIADO','CONCLUIDO','CANCELADO') not null default 'CRIADO',
    primary key(id)
);
create table item_pedido(
    id varchar(36) not null unique,
    pedido_id varchar(12) not null references pedido(id),
    descricao varchar(150) not null,
    primary key(id)
);