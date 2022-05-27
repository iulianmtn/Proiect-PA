create table facultati
(
    id int primary key,
    nume not null
)

CREATE SEQUENCE fac_seq START WITH 1;

CREATE OR REPLACE TRIGGER fac_id
before insert on FACULTATI
for each row
begin
    :new.id := fac_seq.nextval;
end;



create table camere
(
id INT primary key,
id_facultate int not null,
capacitate int not null,
name varchar2(30),
constraint fac_cam_fk foreign key (id_facultate) references camere (id)
);

CREATE SEQUENCE cam_seq START WITH 1;

CREATE OR REPLACE TRIGGER cam_id
before insert on camere
for each row
begin
    :new.id := cam_seq.nextval;
end;


create table events
(
id int primary key,
id_camera int,
id_facultate int not null,
nume varchar2(60) not null,
day varchar2(15) not null,
inceput int not null,
sfarsit int not null,
an int not null,
grupa int not null,
semian varchar2(2) not null,
tip number(1,0) not null,
constraint cam_event_fk foreign key (id_camera) references camere (id)
)

CREATE SEQUENCE ev_seq START WITH 1;

create or replace trigger ev_id
before insert on events
for each row
begin
    :new.id := ev_seq.nextval;
end;


insert into facultati (nume) values ('facultate depeale');
select * from facultati;
