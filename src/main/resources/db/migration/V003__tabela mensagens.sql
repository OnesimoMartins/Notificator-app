create table mensagem(
id bigint auto_increment,
data timestamp not null default now(),
cliente_id varchar(12) not null references cliente(numero_telefone),
primary key(id)
);