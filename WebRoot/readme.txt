创建库和表

create database itheima;

use itheima;

create table customer(
id varchar(40) primary key,
name varchar(40) not null,
gender varchar(4) not null,
cellphone varchar(20) not null,
qq varchar(20) not null,
email varchar(100) not null,
address varchar(255),
customerStatus varchar(40)not null,
infoSource varchar(40),
description varchar(255),
regTime date
);

create table customerStatus(
id varchar(40) primary key,
name varchar(40) not null,
description varchar(255)
);

create table infoSource (
id varchar(40) primary key,
name varchar(40) not null,
description varchar(255)
);