create sequence Corrector_SEQ start with 1 increment by 50;
create table Corrector (id bigint not null, apellidos varchar(255) not null, correoElectronico varchar(255), identificadorUsuario bigint, maxExamCorregir integer not null, nombre varchar(255) not null, telefono varchar(255), MATERIA bigint, primary key (id));
create table Materia (id bigint not null, anio integer not null, idConvocatoria bigint, nombre varchar(255) not null, primary key (id));
alter table if exists Corrector add constraint FK3t0a9ea6ujqoyi2orpq33il9l foreign key (MATERIA) references Materia;
<<<<<<< Updated upstream
=======
create sequence Corrector_SEQ start with 1 increment by 50;
create table Corrector (id bigint not null, apellidos varchar(255) not null, correoElectronico varchar(255), identificadorUsuario bigint, maxExamCorregir integer not null, nombre varchar(255) not null, telefono varchar(255), MATERIA bigint, primary key (id));
create table Materia (id bigint not null, anio integer not null, idConvocatoria bigint, nombre varchar(255) not null, primary key (id));
alter table if exists Corrector add constraint FK3t0a9ea6ujqoyi2orpq33il9l foreign key (MATERIA) references Materia;
>>>>>>> Stashed changes
