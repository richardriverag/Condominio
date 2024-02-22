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
DROP TABLE IF EXISTS DEPARTAMENTO_F;
DROP TABLE IF EXISTS CONDOMINIO_F;

CREATE TABLE METODOPAGO
(
   ID_METODOPAGO        INT NOT NULL AUTO_INCREMENT,
   NOMBRE_METODOPAGO    VARCHAR(20) NOT NULL,
   PRIMARY KEY (ID_METODOPAGO)
);

CREATE TABLE CONDOMINIO_F
(
   ID_CONDOMINIO_F        VARCHAR(20) NOT NULL,
   NOMBRE_CONDOMINIO_F    VARCHAR(100) NOT NULL,
   PRIMARY KEY (ID_CONDOMINIO_F)
);

CREATE TABLE DEPARTAMENTO_F
(
   ID_DEPARTAMENTO_F      INT NOT NULL AUTO_INCREMENT,
   NUMERO_DEPARTAMENTO_F  VARCHAR(20) NOT NULL,
   ID_CONDOMINIO_F        VARCHAR(20) NOT NULL,
   PRIMARY KEY (ID_DEPARTAMENTO_F),
   FOREIGN KEY (ID_CONDOMINIO_F) REFERENCES CONDOMINIO_F(ID_CONDOMINIO_F)
);

CREATE TABLE USUARIO
(
   ID_USUARIO           VARCHAR(20) NOT NULL,
   NOMBRE_USUARIO       VARCHAR(20),
   APELLIDO_USUARIO     VARCHAR(20),
   DIRECCION_USUARIO    VARCHAR(20),
   CORREOELECTRONICO_USUARIO VARCHAR(100),
   TELEFONO_USUARIO     VARCHAR(20),
   ID_CONDOMINIO_F        VARCHAR(20),
   TIPO_USUARIO         VARCHAR(20),
   PRIMARY KEY (ID_USUARIO),
   FOREIGN KEY (ID_CONDOMINIO_F) REFERENCES CONDOMINIO_F(ID_CONDOMINIO_F)
);

CREATE TABLE PAGO
(
   ID_PAGOS             INT NOT NULL AUTO_INCREMENT,
   ID_METODOPAGO        INT NOT NULL,
   ID_USUARIO           VARCHAR(20) NOT NULL,
   FECHA_PAGO           DATE NOT NULL,
   MONTO_PAGO           FLOAT(10,2) NOT NULL,
   TIPO_PAGO            VARCHAR(60) NOT NULL,				 	/*--3 TIPOS DE INGRESO: EGRESO ORDINARIO, INGRESO EXTRAORDINARIO, INGRESO ORDINARIO*/
   FECHAVENCIMIENTO_PAGO DATE NOT NULL,
   ESTADO_PAGO          VARCHAR(10) NOT NULL,		 			/*2 ESTADOS: VIGENTE, ANULADO*/
   DESCRIPCION			VARCHAR(200) default 'ORDINARIO',		/*SOLO EXTRAORDINARIOS DEBEN ESPECIFICAR*/
   PRIMARY KEY (ID_PAGOS),
   FOREIGN KEY (ID_METODOPAGO) REFERENCES METODOPAGO(ID_METODOPAGO),
   FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO)
);

CREATE TABLE CUOTA 												/*SI UN PAGO SE ANULA LAS CUOTAS SE ELIMINAN*/
(
   ID_PAGOS             INT NOT NULL,
   ID_CUOTA             INT NOT NULL AUTO_INCREMENT,
   NUM_CUOTA            INT NOT NULL,
   MONTO_CUOTA          FLOAT(10,2) NOT NULL,
   FECHAV_CUOTA         DATE NOT NULL,
   ESTADO_CUOTA         CHAR(20) NOT NULL,  					/*2 ESTADOS: PENDIENTE O PAGADO*/
   PRIMARY KEY (ID_CUOTA),
   FOREIGN KEY (ID_PAGOS) REFERENCES PAGO(ID_PAGOS)
);

-- Insertar 10 registros en la tabla METODOPAGO
INSERT INTO METODOPAGO (NOMBRE_METODOPAGO) VALUES 
('Efectivo'),
('Tarjeta'),
('Transferencia'),
('Cheque'),
('PayPal'),
('Bitcoin'),
('Stripe'),
('Venmo'),
('Zelle'),
('Apple Pay');
SELECT * FROM METODOPAGO;

-- Insertar 10 registros en la tabla CONDOMINIO_F
INSERT INTO CONDOMINIO_F (ID_CONDOMINIO_F, NOMBRE_CONDOMINIO_F) VALUES 
('1', 'Condominio A'),
('2', 'Condominio B'),
('3', 'Condominio C'),
('4', 'Condominio D'),
('5', 'Condominio E'),
('6', 'Condominio F'),
('7', 'Condominio G'),
('8', 'Condominio H'),
('9', 'Condominio I'),
('10', 'Condominio J');
SELECT * FROM CONDOMINIO_F;

-- Insertar 10 registros en la tabla DEPARTAMENTO_F_F
INSERT INTO DEPARTAMENTO_F (NUMERO_DEPARTAMENTO_F, ID_CONDOMINIO_F) VALUES 
('101', '1'),
('102', '1'),
('201', '2'),
('202', '2'),
('301', '3'),
('302', '3'),
('401', '4'),
('402', '4'),
('501', '5'),
('502', '5');
SELECT * FROM DEPARTAMENTO_F;

-- Insertar 10 registros en la tabla USUARIO
INSERT INTO USUARIO (ID_USUARIO, NOMBRE_USUARIO, APELLIDO_USUARIO, DIRECCION_USUARIO, CORREOELECTRONICO_USUARIO, TELEFONO_USUARIO, ID_CONDOMINIO_F, TIPO_USUARIO) VALUES 
('1', 'Juan', 'Perez', 'Calle 123', 'juan@example.com', '123456789', '1', 'Propietario'),
('2', 'Maria', 'Gomez', 'Avenida 456', 'maria@example.com', '987654321', '2', 'Inquilino'),
('3', 'Carlos', 'Lopez', 'Carrera 789', 'carlos@example.com', '456789123', '3', 'Propietario'),
('4', 'Ana', 'Martinez', 'Calle 456', 'ana@example.com', '321654987', '4', 'Inquilino'),
('5', 'Pedro', 'Rodriguez', 'Avenida 789', 'pedro@example.com', '789123456', '5', 'Propietario'),
('6', 'Luisa', 'Fernandez', 'Carrera 123', 'luisa@example.com', '159357468', '6', 'Inquilino'),
('7', 'Sofia', 'Diaz', 'Calle 789', 'sofia@example.com', '357159486', '7', 'Propietario'),
('8', 'Jorge', 'Hernandez', 'Avenida 123', 'jorge@example.com', '486357159', '8', 'Inquilino'),
('9', 'Laura', 'Sanchez', 'Carrera 456', 'laura@example.com', '624185379', '9', 'Propietario'),
('10', 'Pablo', 'Gonzalez', 'Calle 789', 'pablo@example.com', '931862475', '10', 'Inquilino');
SELECT * FROM USUARIO;

-- Insertar 10 registros en la tabla PAGO
INSERT INTO PAGO (ID_METODOPAGO, ID_USUARIO, FECHA_PAGO, MONTO_PAGO, TIPO_PAGO, FECHAVENCIMIENTO_PAGO, ESTADO_PAGO, DESCRIPCION) VALUES 
(1, '1', '2024-02-22', 100.00, 'INGRESO ORDINARIO', '2024-03-22', 'VIGENTE', 'Cuota mensual'),
(2, '2', '2024-02-23', 150.00, 'INGRESO ORDINARIO', '2024-03-23', 'VIGENTE', 'Cuota mensual'),
(3, '3', '2024-02-24', 200.00, 'INGRESO ORDINARIO', '2024-03-24', 'VIGENTE', 'Cuota mensual'),
(4, '4', '2024-02-25', 250.00, 'INGRESO ORDINARIO', '2024-03-25', 'VIGENTE', 'Cuota mensual'),
(5, '5', '2024-02-26', 300.00, 'INGRESO ORDINARIO', '2024-03-26', 'VIGENTE', 'Cuota mensual'),
(6, '6', '2024-02-27', 350.00, 'INGRESO ORDINARIO', '2024-03-27', 'VIGENTE', 'Cuota mensual'),
(7, '7', '2024-02-28', 400.00, 'INGRESO ORDINARIO', '2024-03-28', 'VIGENTE', 'Cuota mensual'),
(8, '8', '2024-02-29', 450.00, 'INGRESO ORDINARIO', '2024-03-29', 'VIGENTE', 'Cuota mensual'),
(9, '9', '2024-03-01', 500.00, 'INGRESO ORDINARIO', '2024-03-30', 'VIGENTE', 'Cuota mensual'),
(10, '10', '2024-03-02', 550.00, 'INGRESO ORDINARIO', '2024-03-31', 'VIGENTE', 'Cuota mensual');
SELECT * FROM PAGO;

-- Insertar 10 registros en la tabla CUOTA
INSERT INTO CUOTA (ID_PAGOS, NUM_CUOTA, MONTO_CUOTA, FECHAV_CUOTA, ESTADO_CUOTA) VALUES 
(1, 1, 100.00, '2024-02-22', 'PENDIENTE'),
(2, 1, 150.00, '2024-02-23', 'PENDIENTE'),
(3, 1, 200.00, '2024-02-24', 'PENDIENTE'),
(4, 1, 250.00, '2024-02-25', 'PENDIENTE'),
(5, 1, 300.00, '2024-02-26', 'PENDIENTE'),
(6, 1, 350.00, '2024-02-27', 'PENDIENTE'),
(7, 1, 400.00, '2024-02-28', 'PENDIENTE'),
(8, 1, 450.00, '2024-02-29', 'PENDIENTE'),
(9, 1, 500.00, '2024-03-01', 'PENDIENTE'),
(10, 1, 550.00, '2024-03-02', 'PENDIENTE');
SELECT * FROM CUOTA;

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
