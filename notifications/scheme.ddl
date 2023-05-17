create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO integer, primary key (id));
alter table if exists Fallo add constraint FKevppjjanfu18rr55nsxaxg3ey foreign key (NOTIFICACION) references Notificacion;
alter table if exists Notificacion add constraint FKn3r08ap2t4vof7cwqty8o67vw foreign key (DESTINATARIO) references Destinatario;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO integer, primary key (id));
alter table if exists Fallo add constraint FKevppjjanfu18rr55nsxaxg3ey foreign key (NOTIFICACION) references Notificacion;
alter table if exists Notificacion add constraint FKn3r08ap2t4vof7cwqty8o67vw foreign key (DESTINATARIO) references Destinatario;
