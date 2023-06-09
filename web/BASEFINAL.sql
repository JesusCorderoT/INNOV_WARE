create database innovware;
use innovware;

create table usuario(id_usuario int(15) auto_increment,
nombre text not null,
apellidos text not null,
telefono varchar(11)not null,
usuario varchar(20)not null,
contrasena varchar(20)not null,
genero varchar(10)not null,
correo_electronico varchar(25)not null,
codigo_verificacion varchar(20)not null,
nivel int(15)not null,
estado varchar(15)not null,
correo_enviado varchar(15),
primary key(usuario),
key id_usuario(id_usuario))engine=INNODB;


create table administrador (id_administrador int primary key auto_increment, 
nombre text not null,apellidos text not null,telefono varchar(11) not null, 
correo_electronico varchar(25) not null unique,nombre_empresa text,codigo_verificacion 
varchar(20) not null)engine=innodb;


create table cliente (id_cliente int primary key auto_increment, nombre text not null,
apellidos text not null,telefono varchar(11) not null,correo_electronico varchar(25) not null unique,
nombre_empresa text,codigo_verificacion varchar(20) not null)engine=innodb;




create table servicios (
id_servicio int primary key auto_increment,
nombre_servicio text not null,
costo decimal(9,2) not null,
categoria varchar (30),
imagen_servicio MEDIUMBLOB)engine=innodb;


create table calificacion_servicio(id_servicio int primary key auto_increment,
id_cliente int not null,calificacion int not null,
comentario varchar(250) not null)engine=innodb;

 create table detalle_servicio(id_detalle int primary key auto_increment,
descripcion varchar(150) not null)engine=innodb;

create table cotizaciones (id_cotizacion int primary key auto_increment,
descripcion_productos varchar(250) not null,total_cotizacion decimal(9,2)not null,
fecha date not null, id_usuario int, 
foreign key (id_usuario) references usuario (id_usuario))engine=innodb;

create table lista_pendientes (id_pendiente int primary key auto_increment,
descripcion_productos varchar(250) not null, id_usuario int,
foreign key (id_usuario) references usuario (id_usuario))engine=innodb;

create table agenda (id_agenda int auto_increment,nombre_completo text not null,
nombre_empresa text,asunto varchar(150),fecha date unique not null,hora time unique not null,
estado varchar(30),folio varchar(30) not null,primary key(id_agenda,fecha,hora))engine=innodb;

create table boletin (id_boletin int primary key auto_increment,titulo_noticia text not null,
descripcion_noticia varchar(250) not null,autor text not null,fecha date not null,
imagen_boletin MEDIUMBLOB)engine=innodb;

create table reporte(id_reporte int primary key auto_increment,
usuario varchar(50)not null,
foreign key (usuario)references usuario(usuario)on delete cascade,
descripccion_reporte text(100)not null,
titulo_noticia varchar(20)not null)engine=INNODB;


create table comentario(
id_comentario int primary key auto_increment,
usuario varchar(20)not null,
foreign key (usuario)references usuario(usuario)on delete cascade,
descripcion_noticia varchar(250)not null,
fecha date not null)engine=INNODB;

create table productos (id_producto int primary key auto_increment,
nombre_producto text not null,
descripcion varchar(500) not null,
costo decimal(9,2) not null,
calificacion int,
imagen_producto MEDIUMBLOB, 
existencia_producto enum ('Si','No'))engine=innodb;


insert into productos values (default,"Teclado","TECLADO PARA GAMER CON TECLAS MULTIMEDIA, 3 COLORES DE LUCES",560,5,"images/home/teclado.jpg","SI");
insert into productos values (default,"Mouse","MOUSE GAMER REDRAGON M607 GRIFFIN RGB 7200DP",1379,5,"images/home/mouse1.jpg","SI");
insert into productos values (default,"Audifonos","Audífonos Gamer Onikuma K6 Retroiluminado Led con Micrófono para PC Ps4 Xbox One",3499,5,"images/home/audi.jpg","SI");
insert into productos values (default,"Cargador","Cargador de laptop HP",250,5,"images/home/cargadorhp.jpg","SI");
insert into productos values (default,"Audifonos","Son JBL",350,5,"images/home/jbl.jpg","SI");
insert into productos values (default,"Bocina","Bocina BOSE",1100,5,"images/home/bose.jpg","SI");


insert into servicios values (1,"Office",100,"Licenciamiento","images/home/office.jpeg");
insert into detalle_servicio values (1,"Licenciamiento de office por 1 año");
insert into servicios values (2,"PhotoShop",150,"Licenciamiento","images/home/pshop.png");
insert into detalle_servicio values (2,"Licenciamiento de PhotoShop por 1 año");
insert into servicios values (3,"Ciber 1",4999,"Licenciamiento","images/home/lenovo1.jpg");
insert into detalle_servicio values (3,"Ciber con computadora All In One Lenovo F0D8003VLD AMD A4 4 GB RAM 1TB DD");
insert into servicios values (4,"Ciber 2",3999,"Licenciamiento","images/home/hp1.jpg");
insert into detalle_servicio values (4,"Ciber con computadora HP 260-P100B Pentium 19.5 Negro");
insert into servicios values (5,"AutoCad",1000,"Licenciamiento","images/home/autocad.png");
insert into detalle_servicio values (5,"Licenciamiento de AutoCad por 1 año");
insert into servicios values (6,"Antivirus",200,"Licenciamiento","images/home/macaffe.jpg");
insert into detalle_servicio values (6,"Licenciamiento de McAffe por 1 año");


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
