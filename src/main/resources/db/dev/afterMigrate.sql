delete from cliente;
delete from item_pedido;
delete from pedido;
delete from funcionario;
delete from cargo;

alter table cargo auto_increment=1;
alter table cliente auto_increment=1;
alter table pedido auto_increment=1;
alter table funcionario auto_increment=1;

insert into cargo(descricao) values ('Funcionário'),('Administrador');

insert into cliente(numero_telefone,nome) values
("931897389","Alfredo Mateus"),("913456623","Lucas Pedro"),("920876879","Marcos Abreu")
,("932768904","Tomás Teles"),("956789012","Monteiro Cruz"),("947890980","Alberto Domingos")
,("923655467","Paulo Jesus");

insert into pedido(cliente_id,status) values
('931897389','CRIADO'),('923890765','CRIADO'),('923890765','CONCLUIDO')
,("913456623",'CRIADO'),('920876879','CRIADO'),("932768904",'CRIADO'),('956789012','CRIADO')
,("923655467",'CRIADO'),("947890980",'CRIADO');

insert into item_pedido(id,pedido_id,descricao) values
("wuoeuqw", 1,'nike air force preta'),("yuio",2,'jordan 2001 (azul)'),("yuio2",2,'sapato castanho'),
("yuio3",3,'sapato preto tamnho 23'),("yuio4",4,'nike f4 tamnho 23'),("yuio5",5,'sebago amarelo')
,("yuio6",6,'snadalhas'),("yuio7",7,'tenis'),("yuio8",8,'Adidas');

insert into funcionario(nome,sobrenome,numero_telefone,password,cargo_id) values
('Aurio','suchel','923456876','encode',2),('helena','Batista','913456876','encode',1),
('Mauro','Pinto','943456876','encode',1),('Rogerio','Menezes','953456876','encode',1)
,('Rogerio','Menezes','953450876','encode',1),('Rogerio','Menezes','953456817','encode',1)
,('Rogerio','Menezes','953456674','encode',1);