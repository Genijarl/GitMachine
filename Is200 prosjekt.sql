create schema classlist; 
use classlist;

create table clist (
list_no integer(11)not null auto_increment,
list_fname varchar (30),
list_lname varchar (30),
constraint pk_clist primary key (list_no)
);

insert into clist (`list_fname`, `list_lname`)
values ('Jarl', 'Andreassen');

select * from clist;

drop table clist