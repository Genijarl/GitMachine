
use classlist;

create table clist (
list_no integer(11)not null auto_increment,
list_fname varchar (30),
list_lname varchar (30),
constraint pk_clist primary key (list_no)
);

select * from clist;

create table files (
id int(4) not null auto_increment,
title varchar(20),
f_file longblob not null,
constraint files_pk primary key(id)
);
select * From files;
