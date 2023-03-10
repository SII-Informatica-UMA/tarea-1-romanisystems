CREATE TABLE NOTIFICACION (ID INTEGER NOT NULL, MENSAJE VARCHAR NOT NULL, TIPO VARCHAR NOT NULL, LISTA INTEGER, PRIMARY KEY (ID))
CREATE TABLE DESTINATARIO (ID INTEGER NOT NULL, CORREOELECTRONICO VARCHAR NOT NULL, NOMBRE VARCHAR NOT NULL, TELEFONO VARCHAR, TIPO VARCHAR NOT NULL, PRIMARY KEY (ID))
CREATE TABLE FALLO (ID INTEGER NOT NULL, CODE INTEGER NOT NULL, MENSAJE VARCHAR NOT NULL, NOTIFICACION INTEGER, PRIMARY KEY (ID))
CREATE TABLE LISTA (ID INTEGER NOT NULL, PRIMARY KEY (ID))
CREATE TABLE lista_destinatario (destinatario_id INTEGER NOT NULL, lista_id INTEGER NOT NULL, PRIMARY KEY (destinatario_id, lista_id))
ALTER TABLE NOTIFICACION ADD CONSTRAINT FK_NOTIFICACION_LISTA FOREIGN KEY (LISTA) REFERENCES LISTA (ID)
ALTER TABLE FALLO ADD CONSTRAINT FK_FALLO_NOTIFICACION FOREIGN KEY (NOTIFICACION) REFERENCES NOTIFICACION (ID)
ALTER TABLE lista_destinatario ADD CONSTRAINT FK_lista_destinatario_lista_id FOREIGN KEY (lista_id) REFERENCES LISTA (ID)
ALTER TABLE lista_destinatario ADD CONSTRAINT FK_lista_destinatario_destinatario_id FOREIGN KEY (destinatario_id) REFERENCES DESTINATARIO (ID)
