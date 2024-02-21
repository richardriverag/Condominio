/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Richard
 * Created: 16 feb 2024
 */
create database condominio;
use condominio;

CREATE TABLE Usuario (
  id_usuario int,
  usuario varchar(50) NOT NULL,
  contrasenia varchar(50) NOT NULL,
  nombre varchar(10) NOT NULL,
  apellido varchar(100) NOT NULL,
  email varchar(10) NOT NULL,
  tipoUsuario int DEFAULT NULL,
  PRIMARY KEY (id_usuario)
);

/*===============================================================================================*/
/*=========================TABLAS USADAS POR MODULO FINANZAS GRUPO 1=============================*/
/*===============================================================================================*/
DROP TABLE IF EXISTS CUOTA;
DROP TABLE IF EXISTS METODOPAGO;
DROP TABLE IF EXISTS PAGO;
DROP TABLE IF EXISTS USUARIO;

/*==============================================================*/
/* Table: METODOPAGO                                            */
/*==============================================================*/
CREATE TABLE METODOPAGO
(
   ID_METODOPAGO        INT NOT NULL AUTO_INCREMENT,
   NOMBRE_METODOPAGO    VARCHAR(20) NOT NULL,
   PRIMARY KEY (ID_METODOPAGO)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
CREATE TABLE USUARIO/***************************************************************************TABLA PRUEBA USUARIO************/
(
   ID_USUARIO           VARCHAR(20) NOT NULL,
   NOMBRE_USUARIO       VARCHAR(20),
   APELLIDO_USUARIO     VARCHAR(20),
   DIRECCION_USUARIO    VARCHAR(20),
   CORREOELECTRONICO_USUARIO VARCHAR(100),
   TELEFONO_USUARIO     VARCHAR(20),
   IDCONDOMINIO_USUARIO VARCHAR(20),
   IDUNIDAD_USUARIO     VARCHAR(20),
   TIPO_USUARIO         VARCHAR(20),
   PRIMARY KEY (ID_USUARIO)
);

/*==============================================================*/
/* Table: PAGO                                                  */
/*==============================================================*/
CREATE TABLE PAGO
(
   ID_PAGOS             INT NOT NULL AUTO_INCREMENT,
   ID_METODOPAGO        INT NOT NULL,
   ID_USUARIO           VARCHAR(20) NOT NULL,
   FECHA_PAGO           DATE NOT NULL,
   MONTO_PAGO           FLOAT(10,2) NOT NULL,
   TIPO_PAGO            VARCHAR(10) NOT NULL,
   FECHAVENCIMIENTO_PAGO DATE NOT NULL,
   ESTADO_PAGO          VARCHAR(10) NOT NULL,
   PRIMARY KEY (ID_PAGOS)
);
ALTER TABLE PAGO ADD CONSTRAINT FK_RELATIONSHIP_1 FOREIGN KEY (ID_METODOPAGO)
      REFERENCES METODOPAGO (ID_METODOPAGO);
ALTER TABLE PAGO ADD CONSTRAINT FK_RELATIONSHIP_4 FOREIGN KEY (ID_USUARIO)
      REFERENCES USUARIO (ID_USUARIO);

/*==============================================================*/
/* Table: CUOTA                                                 */
/*==============================================================*/
CREATE TABLE CUOTA
(
   ID_PAGOS             INT NOT NULL,
   ID_CUOTA             INT NOT NULL AUTO_INCREMENT,
   NUM_CUOTA            INT NOT NULL,
   MONTO_CUOTA          FLOAT(10,2) NOT NULL,
   FECHAV_CUOTA         DATE NOT NULL,
   ESTADO_CUOTA         CHAR(20) NOT NULL,
   PRIMARY KEY (ID_CUOTA)
);
ALTER TABLE CUOTA ADD CONSTRAINT FK_RELATIONSHIP_2 FOREIGN KEY (ID_PAGOS)
      REFERENCES PAGO (ID_PAGOS);


INSERT INTO METODOPAGO ( NOMBRE_METODOPAGO) VALUES
('Transferencia'),
('Tarjeta'),
('Efectivo');

select * from metodoPago;

INSERT INTO USUARIO (ID_USUARIO, NOMBRE_USUARIO, APELLIDO_USUARIO, DIRECCION_USUARIO, CORREOELECTRONICO_USUARIO, TELEFONO_USUARIO, IDCONDOMINIO_USUARIO, IDUNIDAD_USUARIO, TIPO_USUARIO) VALUES
('U01', 'Juan', 'Pérez', 'Calle Falsa 123', 'juan.perez@example.com', '123456789', 'C01', 'U01', 'Propietario'),
('U02', 'Ana', 'Gómez', 'Avenida', 'ana.gomez@example.com', '987654321', 'C02', 'U02', 'Propietario');

select * from usuario;

INSERT INTO PAGO (ID_METODOPAGO, ID_USUARIO, FECHA_PAGO, MONTO_PAGO, TIPO_PAGO, FECHAVENCIMIENTO_PAGO, ESTADO_PAGO) VALUES
('1', 'U01', '2023-01-10', 100.00, 'Ingreso', '2023-02-01', 'Pagado'),
('2', 'U02', '2023-01-15', 150.00, 'Egreso', '2023-02-01', 'Pendiente');

select * from PAGO;

INSERT INTO CUOTA (ID_PAGOS,  NUM_CUOTA, MONTO_CUOTA, FECHAV_CUOTA, ESTADO_CUOTA) VALUES
(2, 1, 100.00, '2023-02-01', 'Pagado'),
(1, 2, 150.00, '2023-02-01', 'Pendiente');

select * FROM CUOTA

/*===============================================================================================*/
/*=========================TABLAS USADAS POR MODULO RESERVAS GRUPO 4=============================*/
/*===============================================================================================*/
DROP TABLE IF EXISTS RESERVA;
DROP TABLE IF EXISTS AREACOMUN;

/*=====================ÁREAS COMUNES=====================*/
CREATE TABLE AREACOMUN (
    NOMBRE_AREA VARCHAR(100) PRIMARY KEY,
    ESTADO_AREA ENUM('DISPONIBLE', 'OCUPADO'),
    HORA_INICIO TIME,
    HORA_FIN TIME
);

-- Insertar registros en la tabla AREACOMUN
INSERT INTO AREACOMUN (NOMBRE_AREA, ESTADO_AREA, HORA_INICIO, HORA_FIN) 
VALUES 
('Área de Picnic', 'DISPONIBLE', '00:00:00', '00:00:00'),
('Canchas Múltiples', 'DISPONIBLE', '00:00:00', '00:00:00'),
('Gimnasio', 'OCUPADO', '7:00:00', '13:00:00');

/*=====================RESERVA=====================*/
CREATE TABLE RESERVA (
    ID_RESERVA INT AUTO_INCREMENT PRIMARY KEY,
    AREA_RESERVADA VARCHAR(100),
    FECHA_RESERVA DATE,
    HORA_RESERVA TIME,
    DURACION INT,
    ESTADO_RESERVA ENUM('PROCESADA', 'EN ESPERA', 'CANCELADA'),
    CANCELADO BIT,
    FOREIGN KEY (AREA_RESERVADA) REFERENCES AREACOMUN(NOMBRE_AREA)
);

-- Insertar registros en la tabla RESERVA
INSERT INTO RESERVA (AREA_RESERVADA, FECHA_RESERVA, HORA_RESERVA, DURACION, ESTADO_RESERVA, CANCELADO) 
VALUES 
('Área de Picnic', '2024-02-20', '10:00:00', 2, 'EN ESPERA', 0),
('Canchas Múltiples', '2024-02-21', '11:30:00', 1, 'PROCESADA', 0),
('Gimnasio', '2024-02-22', '14:00:00', 3, 'CANCELADA', 1);

SELECT * FROM AREACOMUN;
SELECT * FROM RESERVA;

/*===============================================================================================*/
/*=========================TABLAS USADAS POR MODULO RESERVAS GRUPO 6=============================*/
/*===============================================================================================*/

-- Drop tables if they already exist
/*DROP TABLE IF EXISTS Comunicado;*/
/*DROP TABLE IF EXISTS Anuncios_Generales;*/

-- Creating table Anuncios_Generales
CREATE TABLE Anuncios_Generales (
    ID_AnunciosGenerales INT PRIMARY KEY,
    ID_Administrador INT,
    ID_Usuario INT,
    Fecha_Anuncio DATE,
    Titulo_Anuncio VARCHAR(50),
    Descripcion_Anuncio VARCHAR(150),
    FOREIGN KEY (ID_Administrador) REFERENCES Administrador(ID_Administrador),
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

-- Creating table Comunicado
CREATE TABLE Comunicado (
    ID_Comunicado INT PRIMARY KEY,
    ID_Administrador INT,
    ID_Usuario INT,
    Fecha_Comunicado DATE,
    Titulo_Comunicado VARCHAR(50),
    Descripcion_Comunicado VARCHAR(150),
    FOREIGN KEY (ID_Administrador) REFERENCES Administrador(ID_Administrador),
    FOREIGN KEY (ID_Usuario) REFERENCES Usuario(ID_Usuario)
);

-- Generar e insertar datos aleatorios para la tabla Anuncios_Generales
INSERT INTO Anuncios_Generales (ID_AnunciosGenerales, ID_Administrador, ID_Usuario, Fecha_Anuncio, Titulo_Anuncio, Descripcion_Anuncio)
VALUES 
(1, 1, 2, '2024-02-17', 'Nuevo horario de atención', 'Se informa a todos los usuarios que a partir del día de mañana el horario de atención será de 8:00 a.m. a 5:00 p.m.'),
(2, 2, 4, '2024-02-17', 'Cambio de ubicación de la oficina', 'Por motivos de remodelación, la oficina se trasladará temporalmente a la siguiente dirección: Calle Principal #123.'),
(3, 3, 1, '2024-02-17', 'Suspensión de servicio de agua', 'Se comunica a los usuarios que el servicio de agua estará suspendido el próximo sábado debido a trabajos de mantenimiento.'),
(4, 4, 3, '2024-02-17', 'Reunión de condominio', 'Recordatorio: La reunión de condominio se llevará a cabo el próximo viernes a las 7:00 p.m. en el salón comunal.'),
(5, 5, 5, '2024-02-17', 'Nueva política de seguridad', 'A partir del mes próximo, se implementará una nueva política de seguridad en el edificio. Se solicita la cooperación de todos los residentes.');

-- Generar e insertar datos aleatorios para la tabla Comunicado
INSERT INTO Comunicado (ID_Comunicado, ID_Administrador, ID_Usuario, Fecha_Comunicado, Titulo_Comunicado, Descripcion_Comunicado)
VALUES 
(1, 2, 3, '2024-02-17', 'Recordatorio de pago de expensas', 'Se recuerda a todos los residentes que el plazo para el pago de expensas vence el próximo viernes.'),
(2, 3, 5, '2024-02-17', 'Fiesta de fin de año', 'Estimados residentes, les informamos que la fiesta de fin de año se llevará a cabo el sábado 20 de diciembre en la terraza del edificio.'),
(3, 4, 2, '2024-02-17', 'Cierre temporal de parqueadero', 'Por motivos de mantenimiento, el parqueadero estará cerrado desde el lunes hasta el miércoles de la próxima semana.'),
(4, 5, 4, '2024-02-17', 'Horario especial de atención', 'Durante la temporada navideña, la administración estará atendiendo en horario extendido.'),
(5, 1, 1, '2024-02-17', 'Asamblea extraordinaria', 'Se convoca a todos los propietarios a una asamblea extraordinaria que se llevará a cabo el próximo domingo a las 10:00 a.m.');
