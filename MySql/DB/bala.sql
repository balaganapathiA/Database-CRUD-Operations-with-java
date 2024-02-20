create database bala;
USE bala;
create table users(
ID int auto_increment primary key, 
NAM varchar(20),AGE int,
CITY varchar(29));

insert into users(NAM,AGE,CITY) values("bala",12,"pkt");

select * from users;
