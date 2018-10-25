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
values ('Knut Andreas', 'Aas'),
('Morten Abel');

create table modulelist (
m_id int (10), 
m_name varchar (30),
m_description varchar (1250), 
m_resources varchar (1250),
m_assignment varchar (1250),
constraint pk_modulelist primary key (m_id)
);

insert into modulelist (`m_id`,`m_name`,`m_description`, `m_resources`, `m_assignment`)
values 
('1', 'Modul 1', 'Bruke BlueJ, bl.a. til å: Åpne, lagre, og lukke prosjekter. Lage objekter og kalle metoder i objektene, med og uten parametere.
 Bruke editoren til å se på kildekoden til en klasse. Kunne kompilere prosjektet. Litt java, du skal f.eks. Kunne kjenne igjen en klassedefinisjon, 
 og kunne finne navnet på klassen. Kjenne til forskjellige typer data. Kalle metoder med et objekt som parameter. Kalle metoder som returnerer en verdi
 Kjenne forskjellen mellom klasser og objekter', 'Læreboka (Lenker til en ekstern side.)Lenker til en ekstern side., kap. 1', 'Lag en video der du forklarer læringsmålene i modulen. 
 Bruk Camtasia Relay eller annet egnet verktøy for skjermopptak. Link skal inn på bloggen. (PS: Max 5 min).' ),
  
('2', 'Modul 2', 'Du har fullført modulen når du kan: lese en klassedefinisjon, og kunne fortelle: hva klassen heter ,hvilke felt den har, hva de heter og hvilken type de har, 
hvilke metoder den har, og hva metodene heter. Beskrive parametere (med navn og type) og returverdi for alle metodene og kjenner forskjellen på forskjellige slags metoder (constructors, getters, setters) og vet hva de brukes til
Kan skrive en klassedefinisjon med felt og metoder i riktig rekkefølge med metoder som bruker tilordning, if-setninger og utskrifter', 'Læreboka, kap. 2', 
'Skriv en klasse selv fra scratch. Prøv å finne på noe mere orginalt enn en kopi av eksemplene i boka (som f.eks. sjokoladeautomat osv...)' ),

('3', 'Modul 3', 'Du har fullført modulen når du kan: forklare hva som menes med abstraksjon og modularisering, kan bruke debuggeren i BlueJ. 
Har lært litt mer java, og kan forklare: forskjellen på primitive typer og objekttyper, kan skrive kode som lager nye objekter, kan skrive kode som kaller metoder i samme objekt, og i andre objekter
kan tegne klassediagrammer og objektdiagrammer
', 'Læreboka, kap. 3', 'Lag et program fra scratch med flere klasser, der en klasse blir brukt av en annen klasse Programmet skal bruke if-setninger. Skriv en oppsumering om det du har lært så langt på bloggen din.  
Lag en video der du går gjennom og forklarer programmet, og bruker denne gjennomgangen av programmet til å forklare/illustrere læringsmålene. Link til video legges på bloggen.' ),

('4', 'Modul 4', 'Du har fullført modulen når du: vet når du trenger samlinger av objekter, kan bruke klassen ArrayList, kan gjøre rede for de viktigste metodene i ArrayList, 
vet hvordan du spesifiserer hvilken type objekter ei liste kan inneholde, kan skrive metoder som setter inn, finner og fjerner objekter i ei liste, 
kan bruke for-each løkker til å gå gjennom ei liste, kan bruke while-løkker og iteratorer til å gå gjennom ei løkke. Vet hva en array er, og når det er fornuftig å bruke array 
og vet om standardbibliotektet. Vet hvorfor vi bruker import-setninger', 'Læreboka, kap.4', 'Lag ditt eget prosjekt fra bunnen av. Skriv all koden selv og bruk ting du har lært i modul 1-4. Du må kunne forklare læringsmålene i modul 4, samt de 3 foregående modulene, helst ved å vise til prosjektet ditt. ' ),

('5', 'Modul 5', 'Du har fullført modulen når du kan: bruke verb/substantiv metoden til å finne ut hvilke klasser du trenger for å løse et problem og hvilke metoder klassene skal ha. 
kan bruke scenarier (evt. med CRC kort) til å sjekke at du har funnet klassene og metodene du trenger. 
Vet hva et design pattern er', 'Læringsboka, kap. 13', 'Ta utgangspunkt i en beskrivelse av et system, set fra brukerens perspektiv. 
Du kan bruke innledningen til et av eksemplene i læreboka, eller du kan lage noen brukerhistorier for et eksempel du velger selv. 
Bruk substantiv-verb-metoden til finne ut hvilke klasser og metoder du må ha for at systemet skal fungere. Skriv deretter CRC kort. 
Ta med systembeskrivelsen og dokumentasjon av designet til foreleser eller hjelpelærer for godkjenning' );

select * from clist;
select * from modulelist;

create table files (
id int(4) not null auto_increment,
title varchar(20),
f_file longblob not null,
constraint files_pk primary key(id)
);

select * from files;
