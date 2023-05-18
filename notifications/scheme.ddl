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
<<<<<<< Updated upstream
=======
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
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, DESTINATARIO_id integer, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
alter table if exists Notificacion add constraint FK6hfbfsx0vt0d7excefdylpgxq foreign key (DESTINATARIO_id) references Destinatario;
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, destinatario varchar(255), email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
>>>>>>> Stashed changes
create sequence Fallo_SEQ start with 1 increment by 50;
create sequence Notificacion_SEQ start with 1 increment by 50;
create table Destinatario (id integer not null, correoElectronico varchar(255) not null, nombre varchar(255) not null, telefono varchar(255), tipo varchar(255) not null, primary key (id));
create table Fallo (id integer not null, code integer not null, mensaje varchar(255) not null, NOTIFICACION_id bigint, primary key (id));
create table Notificacion (id bigint not null, asunto varchar(255) not null, destinatario varchar(255), email boolean not null, estado varchar(255), mensaje varchar(255) not null, momentoRealEnvio timestamp(6), programacionEnvio timestamp(6), sms boolean not null, tipo varchar(255) not null, primary key (id));
alter table if exists Fallo add constraint FK55imqjvv6b4095yn30a59gsb4 foreign key (NOTIFICACION_id) references Notificacion;
