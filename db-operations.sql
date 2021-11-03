-- create a dataabse; 
create database ecomdb;
-- use db;
use ecomdb;

select database();


create table eproducts( pid bigint primary key auto_increment ,  name varchar(100), 
price decimal(10,2), create_date timestamp default now(), 
expire_date timestamp default now() );


desc eproducts;

insert into eproducts(name,price) values ("Apple Mac book xyz series",9786745.45);
insert into eproducts(name,price) values ("Hp book xyz series",226745.45);
insert into eproducts(name,price) values ("Dell Mac book xyz series",8786745.45);