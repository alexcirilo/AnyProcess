create database if not exists anyprocess;

use anyprocess;

create table tipo_processo(
id int(11) not null auto_increment,
nome varchar(255) not null unique,
primary key(id)
);

create table processo(
id int(11) not null auto_increment,
numero_processo int(11) not null,
data_entrada date not null,
valor_recurso decimal(19,4) not null,
objetivo varchar(255),
tipo_processo_id int(11) not null,
primary key (id),
foreign key (tipo_processo_id) references tipo_processo(id)
);

