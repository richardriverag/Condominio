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
  email varchar(100) NOT NULL,
  tipoUsuario int DEFAULT NULL,
  PRIMARY KEY (id_usuario)
);


/*===============================================================================================*/
/*=========================TABLAS USADAS POR MODULO FINANZAS GRUPO 1=============================*/
/*===============================================================================================*/

CREATE TABLE METODOPAGO
(
   ID_METODOPAGO        INT NOT NULL AUTO_INCREMENT,
   NOMBRE_METODOPAGO    VARCHAR(20) NOT NULL,
   PRIMARY KEY (ID_METODOPAGO)
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
   FOREIGN KEY (ID_METODOPAGO) REFERENCES METODOPAGO(ID_METODOPAGO)
);

CREATE TABLE CUOTA 								/*SI UN PAGO SE ANULA LAS CUOTAS SE ELIMINAN*/
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

-- Insertar registros en la tabla METODOPAGO
INSERT INTO METODOPAGO (NOMBRE_METODOPAGO) VALUES
('Efectivo'),
('Tarjeta de crédito'),
('Transferencia'),
('PayPal'),
('Cheque'),
('Criptomoneda'),
('Pago móvil'),
('Vale de comida'),
('Cuenta corriente'),
('Tarjeta de débito');

SELECT * FROM CUOTA;
SELECT * FROM PAGO;
SELECT * FROM METODOPAGO;

/*===============================================NOTA======================================================================================================*/
/*=========================================================================================================================================================*/
/*=============DEBIDO A QUE A FECHA 3/3/2024 A LAS 19:05 NO SE HA ENCONTRADO LAS TABLAS,“CONDOMINIO” Y “DEPARTAMENTO”  ====================================*/
/*===========================SE OPTO POR CREAR TABLAS TEMPORALES CONTINUAR CON EL DESARROLLO===============================================================*/
/*===========================LAS TABLAS TEMPORALES SON: CONDOMINIO_F, DEPARTAMENTO_F ======================================================================*/
/*=========================================================================================================================================================*/


CREATE TABLE CONDOMINIO_F
(
   ID_CONDOMINIO_F        INT NOT NULL AUTO_INCREMENT,
   NOMBRE_CONDOMINIO_F    VARCHAR(50) NOT NULL,
   PRIMARY KEY (ID_CONDOMINIO_F)
);

CREATE TABLE DEPARTAMENTO_F
(
   ID_DEPARTAMENTO_F      INT NOT NULL AUTO_INCREMENT,
   NUMERO_DEPARTAMENTO_F  VARCHAR(20) NOT NULL,
   ID_USUARIO           VARCHAR(20) NOT NULL,
   ID_CONDOMINIO_F        INT NOT NULL,
   PRIMARY KEY (ID_DEPARTAMENTO_F),
   FOREIGN KEY (ID_CONDOMINIO_F) REFERENCES CONDOMINIO_F(ID_CONDOMINIO_F)
);

-- Insertar registros en la tabla Usuario
INSERT INTO Usuario (id_usuario, usuario, contrasenia, nombre, apellido, email, tipoUsuario) VALUES
(1, 'Juan', 'Contraseña1', 'Juan', 'Perez', 'juan@example.com', 1),
(2, 'Maria', 'Contraseña2', 'Maria', 'Lopez', 'maria@example.com', 2),
(3, 'Pedro', 'Contraseña3', 'Pedro', 'Garcia', 'pedro@example.com', 1),
(4, 'Ana', 'Contraseña4', 'Ana', 'Martinez', 'ana@example.com', 1),
(5, 'Carlos', 'Contraseña5', 'Carlos', 'Sanchez', 'carlos@example.com', 1),
(6, 'Laura', 'Contraseña6', 'Laura', 'Rodriguez', 'laura@example.com', 2),
(7, 'Diego', 'Contraseña7', 'Diego', 'Gomez', 'diego@example.com', 2),
(8, 'Sofia', 'Contraseña8', 'Sofia', 'Diaz', 'sofia@example.com', 2),
(9, 'Alejandro', 'Contraseña9', 'Alejandro', 'Hernandez', 'alejandro@example.com', 2),
(10, 'Fernanda', 'Contraseña10', 'Fernanda', 'Torres', 'fernanda@example.com', 2);

-- Insertar registros en la tabla CONDOMINIO_F
INSERT INTO CONDOMINIO_F (NOMBRE_CONDOMINIO_F) VALUES
('Edificio A'),
('Conjunto Residencial B'),
('Torres del Parque'),
('Residencial La Floresta'),
('CONDOMINIO_F El Bosque'),
('Urbanización El Recreo'),
('Complejo Los Pinos'),
('Conjunto Vista Hermosa'),
('Residencial Los Alamos'),
('CONDOMINIO_F Las Palmas');

-- Insertar registros en la tabla DEPARTAMENTO_F
-- Se asumirá que ID_USUARIO y ID_CONDOMINIO_F se asignan aleatoriamente de los datos disponibles en las tablas correspondientes.
INSERT INTO DEPARTAMENTO_F (NUMERO_DEPARTAMENTO_F, ID_USUARIO, ID_CONDOMINIO_F) VALUES
('101', 'USR001', 1),
('202', 'USR002', 2),
('303', 'USR003', 3),
('404', 'USR004', 4),
('505', 'USR005', 5),
('606', 'USR006', 6),
('707', 'USR007', 7),
('808', 'USR008', 8),
('909', 'USR009', 9),
('1010', 'USR010', 10);/*===============================================================================================*/
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

use condominio;
CREATE TABLE Usuario (
  id_usuario int,
  usuario varchar(50) NOT NULL,
  contrasenia varchar(50) NOT NULL,
  nombre varchar(10) NOT NULL,
  apellido varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  tipoUsuario int DEFAULT NULL,
  PRIMARY KEY (id_usuario),
  INDEX idx_usuario (usuario) -- Agrega un índice a la columna usuario
);

CREATE TABLE Comunicacion (
  id_comunicacion INT AUTO_INCREMENT PRIMARY KEY,
  asunto VARCHAR(255),
  usuario VARCHAR(50),
  tipoUsuario INT,
  descripcion VARCHAR(255),
  FOREIGN KEY (usuario) REFERENCES Usuario(usuario)
);

-- Luego puedes realizar tus inserciones
INSERT INTO Usuario (id_usuario, usuario, contrasenia, nombre, apellido, email, tipoUsuario) VALUES
(1, 'Juan', 'Contraseña1', 'Juan', 'Perez', 'juan@example.com', 1),
(2, 'Maria', 'Contraseña2', 'Maria', 'Lopez', 'maria@example.com', 2);

INSERT INTO Comunicacion (asunto, usuario, tipoUsuario, descripcion) VALUES
('Reunión de condominio', 'Juan', 1, 'Se llevará a cabo el próximo viernes a las 7:00 p.m.'),
('Suspensión de servicio de agua', 'Maria', 2, 'El servicio de agua estará suspendido el próximo sábado debido a trabajos de mantenimiento.');

INSERT INTO Usuario (id_usuario, usuario, contrasenia, nombre, apellido, email, tipoUsuario) VALUES
(3, 'usuario3', 'contraseña3', 'Nombre3', 'Apellido3', 'usuario3@example.com', 3),
(4, 'usuario4', 'contraseña4', 'Nombre4', 'Apellido4', 'usuario4@example.com', 4),
(5, 'usuario5', 'contraseña5', 'Nombre5', 'Apellido5', 'usuario5@example.com', 1),
(6, 'usuario6', 'contraseña6', 'Nombre6', 'Apellido6', 'usuario6@example.com', 2),
(7, 'usuario7', 'contraseña7', 'Nombre7', 'Apellido7', 'usuario7@example.com', 3),
(8, 'usuario8', 'contraseña8', 'Nombre8', 'Apellido8', 'usuario8@example.com', 4);

Select * from Usuario;
Select * from Comunicacion;

INSERT INTO Comunicacion (asunto, usuario, tipoUsuario, descripcion) VALUES
('Cambio de horario', 'usuario3', 2, 'Se informa que a partir de la próxima semana el horario de atención se modificará.'),
('Recordatorio de pago', 'usuario3', 3, 'Recuerden que el plazo para el pago de las cuotas de mantenimiento vence el próximo viernes.'),
('Revisión de normas', 'usuario4', 4, 'Se solicita a todos los residentes revisar las nuevas normas de convivencia establecidas por la administración.'),
('Reparación de ascensor', 'usuario5', 1, 'Informamos que el ascensor estará fuera de servicio por reparaciones durante el fin de semana.'),
('Fiesta de fin de año', 'usuario6', 2, 'Se invita a todos los residentes a la fiesta de fin de año que se llevará a cabo el 31 de diciembre en el salón comunal.');

CREATE TABLE Mensaje (
  id_mensaje INT AUTO_INCREMENT PRIMARY KEY,
  asunto VARCHAR(255),
  usuario_envia VARCHAR(50),
  usuario_destinatario VARCHAR(50),
  mensaje TEXT,
  FOREIGN KEY (usuario_envia) REFERENCES Usuario(usuario),
  FOREIGN KEY (usuario_destinatario) REFERENCES Usuario(usuario)
);

INSERT INTO Mensaje (asunto, usuario_envia, usuario_destinatario, mensaje) VALUES
('Recordatorio de pago', 'usuario3', 'usuario4', 'Hola usuario4, recuerda que el plazo para el pago de las cuotas de mantenimiento vence el próximo viernes.'),
('Invitación a evento', 'usuario4', 'usuario5', 'Hola usuario5, te invito cordialmente al evento que se realizará el próximo sábado en nuestro condominio.'),
('Actualización de normativas', 'usuario4', 'usuario3', 'Hola usuario1, te informo que se han actualizado las normativas del condominio. Por favor, revisa el documento adjunto.'),
('Felicitaciones', 'usuario5', 'usuario3', '¡Hola usuario3! Quiero felicitarte por tu cumpleaños. ¡Que tengas un día maravilloso!');


/*===============================================================================================*/
/*=========================TABLAS USADAS POR MODULO INMUEBLES GRUPO 3=============================*/
/*===============================================================================================*/
/*=====================CATALOGO_FORMULARIO=====================*/
Drop table if EXISTS CATALOGO_FORMULARIO 
CREATE TABLE CATALOGO_FORMULARIO(
    id INT IDENTITY(1,1) PRIMARY KEY,
    num_bloque VARCHAR(100),
    nombre_administrador VARCHAR(100),
    departamentos_grandes INT,
    departamentos_medianos INT,
    departamentos_pequenos INT,
    suits INT,
    servicios VARCHAR(100),
    normas VARCHAR(100)
);


/*=====================TRIGGER trg_CrearTablaDepartamentos=====================*/
Drop trigger if exists trg_CrearTablaDepartamentos;
CREATE TRIGGER trg_CrearTablaDepartamentos
ON CATALOGO_FORMULARIO
AFTER INSERT
AS
BEGIN
    DECLARE @numBloque VARCHAR(100)
    DECLARE @departamentos_grandes INT
    DECLARE @departamentos_medianos INT
    DECLARE @departamentos_pequenos INT
    DECLARE @suits INT

    SELECT @numBloque = num_bloque,
           @departamentos_grandes = departamentos_grandes,
           @departamentos_medianos = departamentos_medianos,
           @departamentos_pequenos = departamentos_pequenos,
           @suits = suits
    FROM inserted

    DECLARE @sql NVARCHAR(MAX)

    SET @sql = '
    CREATE TABLE ' + QUOTENAME(@numBloque) + ' (
        ID INT IDENTITY(1,1) PRIMARY KEY,
        numBloque VARCHAR(100),
        Nombre_Administrador VARCHAR(100),
        Tipo VARCHAR(20),
        Servicios VARCHAR(100),
        Normas VARCHAR(100),
        Estado VARCHAR(20) DEFAULT ''No arrendado''
    );

    INSERT INTO ' + QUOTENAME(@numBloque) + '
                (numBloque, Nombre_Administrador, Tipo, Servicios, Normas)
    VALUES '

    DECLARE @i INT = 1
    WHILE @i <= @departamentos_grandes
    BEGIN
        SET @sql = @sql + '(''' + @numBloque + ''', ''' + (SELECT nombre_administrador FROM inserted) + ''', ''Grande'', ''' + (SELECT servicios FROM inserted) + ''', ''' + (SELECT normas FROM inserted) + '''),'
        SET @i = @i + 1
    END

    SET @i = 1
    WHILE @i <= @departamentos_medianos
    BEGIN
        SET @sql = @sql + '(''' + @numBloque + ''', ''' + (SELECT nombre_administrador FROM inserted) + ''', ''Mediano'', ''' + (SELECT servicios FROM inserted) + ''', ''' + (SELECT normas FROM inserted) + '''),'
        SET @i = @i + 1
    END

    SET @i = 1
    WHILE @i <= @departamentos_pequenos
    BEGIN
        SET @sql = @sql + '(''' + @numBloque + ''', ''' + (SELECT nombre_administrador FROM inserted) + ''', ''Pequeño'', ''' + (SELECT servicios FROM inserted) + ''', ''' + (SELECT normas FROM inserted) + '''),'
        SET @i = @i + 1
    END

    SET @i = 1
    WHILE @i <= @suits
    BEGIN
        SET @sql = @sql + '(''' + @numBloque + ''', ''' + (SELECT nombre_administrador FROM inserted) + ''', ''Suit'', ''' + (SELECT servicios FROM inserted) + ''', ''' + (SELECT normas FROM inserted) + '''),'
        SET @i = @i + 1
    END

    SET @sql = LEFT(@sql, LEN(@sql) - 1) -- Eliminar la última coma

    EXEC sp_executesql @sql
END;


/*=====================GESTION_PROPIEDADES=====================*/
drop table if exists GESTION_PROPIEDADES
CREATE TABLE GESTION_PROPIEDADES (
	id INT IDENTITY(1,1) PRIMARY KEY,
    CEDULA VARCHAR(100),
    NOMBRE VARCHAR(100),
    NUM_BLOQUE VARCHAR(100),
    TIPO_PISO VARCHAR(20),
    NUM_DEPARTAMENTO INT
);

/*=====================TablaObservaciones=====================*/
drop table if exists TablaObservaciones
CREATE TABLE TablaObservaciones (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    Cedula VARCHAR(100),
	Nombre VARCHAR(100),
    BloqueAnterior VARCHAR(100),
    BloqueActual VARCHAR(100),
    NumDepAnterior INT,
    NumDepActual INT,
    TipoDepartamentoAnterior VARCHAR(100),
    TipoDepartamentoActual VARCHAR(100),
    Observaciones VARCHAR(MAX)
);
/*===============================================================================================*/
/*=========================TABLAS USADAS POR MODULO CHECK IN GRUPO 5=============================*/
/*===============================================================================================*/

/*========se hace uso de la tablas temporales del grupo 1==========*/
drop table visitante ;
/*nuevaa*/
CREATE TABLE Visitante(
    idVisitante int auto_increment NOT NULL,
    id_usuario VARCHAR(20),
    nombreVisitante VARCHAR(50) NOT NULL,
    motivoVisita VARCHAR(50) NOT NULL,
    fecha VARCHAR(50) NOT NULL,
    hora VARCHAR(20) NOT NULL,
    vehiculo VARCHAR(20) NOT NULL,
    tipoUsuario VARCHAR(20) DEFAULT 'Visitante',
    PRIMARY KEY (idVisitante), 
    FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario) ON DELETE SET NULL -- Permitir que id_usuario sea nulo
);
/*insertar visitantes*/
INSERT INTO Visitante (id_usuario, nombreVisitante, motivoVisita, fecha, hora, vehiculo, tipoUsuario) VALUES 
('USR005', 'Ana Lopez', 'Instalacion de Internet', '2024-03-07', '19:00', 'No', 'Visitante'),
('USR001', 'Gonzalo Vera', 'Instalacion de Internet', '2024-05-07', '09:00', 'No', 'Visitante'),
('USR004', 'Valentina Lopez', 'Jardineria', '2024-03-10', '20:00', 'No', 'Visitante'),
('USR007', 'Carlos Martinez', 'Visita familiar', '2024-02-27', '03:00', 'No', 'Visitante'),
('USR008', 'Ana González', 'Reunión de negocios', '2024-02-27', '11:00', 'Si', 'Visitante'),
('USR009', 'Pedro Ramirez', 'Visita médica', '2024-02-28', '12:00', 'Si', 'Visitante'),
('USR010', 'Yolanda Ramirez', 'Visita familiar', '2024-02-28', '02:00', 'No', 'Visitante');

/*insertar proveedores*/
INSERT INTO Visitante (nombreVisitante, motivoVisita, fecha, hora, vehiculo, tipoUsuario) VALUES 
('María López', 'Entrega de documentos', '2024-02-26', '10:30', 'No', 'Proveedor');

select * from Visitante;

drop table IngresoResidente;
Create Table IngresoResidente(
	id_usuario VARCHAR(20) NOT NULL,
	fecha varchar(50) not null,
	hora varchar(20) not null,
	PRIMARY KEY (id_usuario,fecha), 
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario)
); 

INSERT INTO IngresoResidente (id_usuario, fecha, hora) VALUES 
('USR005', '2002-02-22', '08:00'),
('USR006', '2002-02-23', '17:30'),
('USR007', '2002-02-21', '10:15'),
('USR008', '2002-02-21', '23:45'),
('USR009', '2002-02-21', '01:00');

select * from IngresoResidente;

drop view historialIngresosCondominio;
CREATE VIEW historialIngresosCondominio_v AS
SELECT 'Visitante' AS TipoUsuario, nombreVisitante AS Nombre, fecha AS FechaIngreso, hora AS HoraIngreso
FROM visitante
WHERE tipoUsuario = 'Visitante' AND STR_TO_DATE(fecha, '%Y-%m-%d') <= CURDATE()
UNION 
SELECT 'Proveedor' AS TipoUsuario, nombreVisitante AS Nombre, fecha AS FechaIngreso, hora AS HoraIngreso
FROM visitante
WHERE tipoUsuario = 'Proveedor' AND STR_TO_DATE(fecha, '%Y-%m-%d') <= CURDATE()
UNION
SELECT 'Residente' AS TipoUsuario, CONCAT(usuario.nombre_usuario, ' ', usuario.apellido_usuario) AS Nombre, fecha AS FechaIngreso, hora AS HoraIngreso
FROM usuario
JOIN ingresoresidente ON usuario.id_usuario = ingresoresidente.id_usuario 
WHERE STR_TO_DATE(fecha, '%Y-%m-%d') <= CURDATE();

SELECT * FROM historialIngresosCondominio;

CREATE VIEW VisitasProximas_v AS
SELECT 
    v.nombreVisitante AS NombreVisita,
    v.fecha AS Fecha,
    v.hora AS Hora,
	df.NUMERO_DEPARTAMENTO_F AS ResidenteAVisitar,
    v.motivoVisita AS Motivo
FROM 
    Visitante v
JOIN 
    USUARIO u ON v.id_usuario = u.ID_USUARIO
JOIN
    DEPARTAMENTO_F df ON u.ID_USUARIO = df.ID_USUARIO
WHERE 
    v.fecha > CURRENT_DATE() OR v.fecha = '2024-03-06';

select * from VisitasProximas_v;

DROP TABLE ParqueaderoVisita;
create table ParqueaderoVisita(
	idParqueadero int not null,
	estado varchar(20) not null,
    ID_CONDOMINIO_F        INT NOT NULL,
	FOREIGN KEY (ID_CONDOMINIO_F) REFERENCES CONDOMINIO_F(ID_CONDOMINIO_F)
);

INSERT INTO ParqueaderoVisita (idParqueadero, estado, ID_CONDOMINIO_F) VALUES (1, 'Disponible',1);
INSERT INTO ParqueaderoVisita (idParqueadero, estado,ID_CONDOMINIO_F)  VALUES (2, 'Disponible',1);
INSERT INTO ParqueaderoVisita (idParqueadero, estado,ID_CONDOMINIO_F)  VALUES (3, 'Disponible',1);
INSERT INTO ParqueaderoVisita (idParqueadero, estado,ID_CONDOMINIO_F)  VALUES (4, 'Disponible',2);
INSERT INTO ParqueaderoVisita (idParqueadero, estado,ID_CONDOMINIO_F)  VALUES (5, 'Disponible',2);
INSERT INTO ParqueaderoVisita (idParqueadero, estado,ID_CONDOMINIO_F)  VALUES (6, 'Disponible',2);
INSERT INTO ParqueaderoVisita (idParqueadero, estado,ID_CONDOMINIO_F)  VALUES (7, 'Disponible',3);
INSERT INTO ParqueaderoVisita (idParqueadero, estado,ID_CONDOMINIO_F)  VALUES (5, 'Disponible',3);
INSERT INTO ParqueaderoVisita (idParqueadero, estado,ID_CONDOMINIO_F)  VALUES (6, 'Disponible',3);

select * from ParqueaderoVisita;
drop view ParquederosLibres;

CREATE VIEW ParquederosLibres_v AS
SELECT *
FROM ParqueaderoVisita;

select * from departamento_f;

select * from ingresoresidente;
select * from Visitante;
select * from ParqueaderoVisita;
/*vistas*/
select * from historialIngresoscondominio_v;
select * from parquederoslibres_v;
select * from visitasproximas_v;

