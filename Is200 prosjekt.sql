drop database classlist;
create database if not exists classlist; 
use classlist;

create table clist (
list_no integer(11)not null auto_increment,
list_fname varchar (30),
list_lname varchar (30),
constraint pk_clist primary key (list_no)
); 

insert into clist (`list_fname`, `list_lname`)
values ('Knut Andreas', 'Aas');

create table modulelist (
m_id int not null auto_increment, 
m_name varchar (30),
m_description varchar (1250), 
m_resources varchar (1250),
m_assignment varchar (1250),
m_evaluation varchar (1000),

constraint pk_modulelist primary key (m_id)
);

insert into modulelist (`m_name`,`m_description`, `m_resources`, `m_assignment`, `m_evaluation`)
values 
( 'Modul 1', 'Bruke BlueJ, bl.a. til å: Åpne, lagre, og lukke prosjekter. Lage objekter og kalle metoder i objektene, med og uten parametere.
 Bruke editoren til å se på kildekoden til en klasse. Kunne kompilere prosjektet. Litt java, du skal f.eks. Kunne kjenne igjen en klassedefinisjon, 
 og kunne finne navnet på klassen. Kjenne til forskjellige typer data. Kalle metoder med et objekt som parameter. Kalle metoder som returnerer en verdi
 Kjenne forskjellen mellom klasser og objekter', 'Læreboka (Lenker til en ekstern side.)Lenker til en ekstern side., kap. 1', 'Lag en video der du forklarer læringsmålene i modulen. 
 Bruk Camtasia Relay eller annet egnet verktøy for skjermopptak. Link skal inn på bloggen. (PS: Max 5 min).', 'Godkjent/Ikke godkjent'),
  
('Modul 2', 'Du har fullført modulen når du kan: lese en klassedefinisjon, og kunne fortelle: hva klassen heter ,hvilke felt den har, hva de heter og hvilken type de har, 
hvilke metoder den har, og hva metodene heter. Beskrive parametere (med navn og type) og returverdi for alle metodene og kjenner forskjellen på forskjellige slags metoder (constructors, getters, setters) og vet hva de brukes til
Kan skrive en klassedefinisjon med felt og metoder i riktig rekkefølge med metoder som bruker tilordning, if-setninger og utskrifter', 'Læreboka, kap. 2', 
'Skriv en klasse selv fra scratch. Prøv å finne på noe mere orginalt enn en kopi av eksemplene i boka (som f.eks. sjokoladeautomat osv...)','Godkjent/Ikke godkjent' ),

('Modul 3', 'Du har fullført modulen når du kan: forklare hva som menes med abstraksjon og modularisering, kan bruke debuggeren i BlueJ. 
Har lært litt mer java, og kan forklare: forskjellen på primitive typer og objekttyper, kan skrive kode som lager nye objekter, kan skrive kode som kaller metoder i samme objekt, og i andre objekter
kan tegne klassediagrammer og objektdiagrammer
', 'Læreboka, kap. 3', 'Lag et program fra scratch med flere klasser, der en klasse blir brukt av en annen klasse Programmet skal bruke if-setninger. Skriv en oppsumering om det du har lært så langt på bloggen din.  
Lag en video der du går gjennom og forklarer programmet, og bruker denne gjennomgangen av programmet til å forklare/illustrere læringsmålene. Link til video legges på bloggen.', 'Godkjent/Ikke godkjent'),

('Modul 4', 'Du har fullført modulen når du: vet når du trenger samlinger av objekter, kan bruke klassen ArrayList, kan gjøre rede for de viktigste metodene i ArrayList, 
vet hvordan du spesifiserer hvilken type objekter ei liste kan inneholde, kan skrive metoder som setter inn, finner og fjerner objekter i ei liste, 
kan bruke for-each løkker til å gå gjennom ei liste, kan bruke while-løkker og iteratorer til å gå gjennom ei løkke. Vet hva en array er, og når det er fornuftig å bruke array 
og vet om standardbibliotektet. Vet hvorfor vi bruker import-setninger', 'Læreboka, kap.4', 'Lag ditt eget prosjekt fra bunnen av. Skriv all koden selv og bruk ting du har lært i modul 1-4. Du må kunne forklare læringsmålene i modul 4, samt de 3 foregående modulene, helst ved å vise til prosjektet ditt. ', 'Godkjent/Ikke godkjent'),

('Modul 5', 'Du har fullført modulen når du kan: bruke verb/substantiv metoden til å finne ut hvilke klasser du trenger for å løse et problem og hvilke metoder klassene skal ha. 
kan bruke scenarier (evt. med CRC kort) til å sjekke at du har funnet klassene og metodene du trenger. 
Vet hva et design pattern er', 'Læringsboka, kap. 13', 'Ta utgangspunkt i en beskrivelse av et system, set fra brukerens perspektiv. 
Du kan bruke innledningen til et av eksemplene i læreboka, eller du kan lage noen brukerhistorier for et eksempel du velger selv. 
Bruk substantiv-verb-metoden til finne ut hvilke klasser og metoder du må ha for at systemet skal fungere. Skriv deretter CRC kort. 
Ta med systembeskrivelsen og dokumentasjon av designet til foreleser eller hjelpelærer for godkjenning', 'Godkjent/Ikke godkjent');

select * from modulelist;

create table files (
id int(4) not null auto_increment,
title varchar(50),
f_file longblob not null,
constraint files_pk primary key(id)
);


select * from files;


create table outgoingEmail (
mottaker_id integer auto_increment,
epost_adr varchar(50),
epost_emne varchar(50),
epost_melding varchar(5000),
email_sendt datetime,
constraint pk_outgoingEmail primary key (mottaker_id)
);

select * from outgoingEmail;

drop table outgoingEmail;

create table innboks (
inn_nr integer auto_increment,
inn_sender varchar(50),
inn_emne varchar(50),
inn_meld varchar(5000),
constraint pk_innboks primary key (inn_nr)
);

insert into innboks (`inn_sender`, `inn_emne`, `inn_meld`)
values ('jarlsandreassen@uia.no', 'IS-202', 'Halla gutta! I morgen er det viktig at vi møter på grupperom B 1 337 
klokken 10:15!'),
('kaaas@uia.no', 'IS-200', 'Husk at rapporten skal leveres i morgen klokken 16:00. Alle må møte på skolen klokken 10:15');


select * from files;

create table forumlist(
f_id integer not null auto_increment, 
f_title varchar (45), 
f_content varchar (2000),

constraint f_id_pk primary key (f_id)
);

insert into forumlist (`f_title`,`f_content`)
values 
('IS109', 'Hvor mange moduler må vi gjøre dette semesteret?'),
('Hvike oppgaver er obligatoriske?', 'Hvor mange moduler må vi gjøre dette semesteret?'),
('IS110', 'Kommer eksamen til å bli lik de tidligere eksamene?'); 


select *from forumlist;

create table users (
    username varchar(32) not null primary key,
    password varchar(32) not null
);

create table roles (
    username varchar(32) not null,
    rolename varchar(32) not null,
    primary key (username,rolename)
);

insert into users values ('student', 'student');
insert into users values ('foreleser', 'foreleser');
insert into users values ('Jarl', 'passord');
insert into users values ('Sondre', 'passord');
insert into users values ('Hallgeir', 'passord');

insert into roles values ('student', 'RolodexUser');
insert into roles values ('foreleser', 'RolodexAdmin');
insert into roles values ('Jarl', 'RolodexUser');
insert into roles values ('Sondre', 'RolodexUser');
insert into roles values ('Hallgeir', 'RolodexAdmin');

select * from users;
select * from roles;
