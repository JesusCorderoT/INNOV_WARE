create database innovware;
use innovware;

create table usuario (
id_usuario int primary key auto_increment,
nombre varchar(20) not null,
apellidos text not null,
telefono varchar(11) not null,
usuario varchar(20)not null,
contrasena varchar(20)not null,
genero varchar(10)not null,
correo_electronico varchar(25) not null unique,
codigo_verificacion varchar(20),
nivel int not null,estado varchar(15))engine=innodb;

create table administrador (
id_administrador int primary key auto_increment, 
nombre text not null,
apellidos text not null,
telefono varchar(11) not null,
correo_electronico varchar(25) not null unique,
nombre_empresa text,
codigo_verificacion varchar(20) not null)engine=innodb;

create table cliente (
id_cliente int primary key auto_increment, 
nombre text not null,
apellidos text not null,
telefono varchar(11) not null,
correo_electronico varchar(25) not null unique,
nombre_empresa text,
codigo_verificacion varchar(20) not null)engine=innodb;

create table productos (
id_producto int primary key auto_increment,
nombre_producto text not null,
descripcion varchar(150) not null,
costo decimal(9,2) not null,
calificacion int,
imagen_producto MEDIUMBLOB)engine=innodb;


create table servicios (
id_servicio int primary key auto_increment,
nombre_servicio text not null,
costo decimal(9,2) not null,
imagen_servicio MEDIUMBLOB)engine=innodb;


create table calificacion_servicio(
id_servicio int primary key auto_increment,
id_cliente int not null,
calificacion int not null,
comentario varchar(250) not null)engine=innodb;

 create table detalle_servicio(
 id_detalle int primary key auto_increment,
 descripcion varchar(150) not null)engine=innovdb;

create table cotizaciones (
id_cotizacion int primary key auto_increment,
descripcion_productos varchar(250) not null,
total_cotizacion decimal(9,2)not null,
fecha date not null)engine=innodb;

create table lista_pendientes (
id_pendiente int primary key auto_increment,
descripcion_productos varchar(250) not null)engine=innodb;

create table agenda (id_agenda int auto_increment,
nombre_completo text not null,
nombre_empresa text,
asunto varchar(150),
fecha date not null,
hora time not null,
estado varchar(30),
folio varchar(30) not null,
primary key(id_agenda,fecha,hora))engine=innodb;

create table boletin (
id_boletin int primary key auto_increment,
titulo_noticia text not null,
descripcion_noticia varchar(250) not null,
autor text not null,
fecha date not null,
imagen_boletin MEDIUMBLOB)engine=innodb;

create table comentario (
id_comentario int primary key auto_increment,
nombre_cliente text not null,
descripcion_noticia varchar(250) not null,
fecha date not null)engine=innodb;

insert into usuario values(null,"carlos daniel","ortega castelan","5512345874","saogamer23@gmail.com","","sdfsdf");

insert into productos values (default,"Audifonos","Son JBL",350,5,"images/home/jbl.jpg");
insert into productos values (default,"Bocina","Bocina BOSE etc..",1100,5,"images/home/bose.jpg");
insert into productos values (default,"Cargador","Cargador de laptop HP",250,5,"images/home/cargadorhp.jpg");
insert into servicios values (default,"Office",100,"images/home/office.jpeg");
insert into detalle_servicio values (default,"Licenciamiento de office por 1 año");
insert into servicios values (default,"Antivirus",200,"images/home/macaffe.jpg");
insert into detalle_servicio values (default,"Licenciamiento de McAffe por 1 año");
insert into servicios values (default,"PhotoShop",150,"images/home/pshop.png");
insert into detalle_servicio values (default,"Licenciamiento de PhotoShop por 1 año");


DELIMITER //
CREATE PROCEDURE selectServicios()
BEGIN
SELECT * FROM servicios;
END	
//

CREATE PROCEDURE selectServicio(
IN _id_servicio int
)
BEGIN
SELECT * FROM servicios WHERE id_servicio = _id_servicio;
END	
//

DELIMITER //
CREATE PROCEDURE selectProd()
BEGIN
SELECT * FROM productos;
END	
//

//
CREATE PROCEDURE selectProdus(
IN _id_pro int
)
BEGIN
SELECT * FROM productos WHERE id_producto = _id_pro;
END	
//



