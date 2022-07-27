create table artigo(
id serial primary key,
slug varchar(100) unique not null,
titulo varchar(60) not null,
corpo text not null,
data_criacao TIMESTAMP DEFAULT NOW(),
data_actualizacao TIMESTAMP null,
favorito BOOLEAN DEFAULT FALSE,
numero_favoritos Int null,
tags varchar(250) NOT NULL
);
