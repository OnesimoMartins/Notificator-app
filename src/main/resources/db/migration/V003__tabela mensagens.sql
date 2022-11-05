create table cargo(
id smallint auto_increment,
descricao varchar(100) not null,
primary key(id)
);

alter table funcionario add column cargo_id smallint not null references cargo(id);
