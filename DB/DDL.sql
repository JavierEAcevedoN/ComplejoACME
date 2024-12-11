DROP DATABASE IF EXISTS ComplejoACME;

CREATE DATABASE IF NOT EXISTS ComplejoACME;

USE ComplejoACME;

CREATE TABLE IF NOT EXISTS Rol (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Rol VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Personal (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(256) NOT NULL,
    Direccion VARCHAR(256) NOT NULL,
    Contacto VARCHAR(128) NOT NULL,
    Estado BOOLEAN NOT NULL,
    ID_Rol INT NOT NULL,
    Foreign Key (ID_Rol) REFERENCES Rol (ID)
);

CREATE TABLE IF NOT EXISTS PermisosVisitantes (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha_Inicio DATE NOT NULL,
    Fecha_Fin DATE NOT NULL,
    Usuario_Responsable VARCHAR(64) NOT NULL,
    ID_Personal INT NOT NULL,
    Foreign Key (ID_Personal) REFERENCES Personal (ID)
);

CREATE TABLE IF NOT EXISTS LogRegistros (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha DATETIME NOT NULL,
    Usuario_Creador VARCHAR(64) NOT NULL,
    ID_Personal_Creado INT NOT NULL,
    Foreign Key (ID_Personal_Creado) REFERENCES Personal (ID)
);

CREATE TABLE IF NOT EXISTS LogCambioEstado (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha DATETIME NOT NULL,
    Nuevo_Estado BOOLEAN NOT NULL,
    Descripcion TEXT NOT NULL,
    Usuario_Responsable VARCHAR(64) NOT NULL,
    ID_Personal INT NOT NULL,
    Foreign Key (ID_Personal) REFERENCES Personal (ID)
);

CREATE TABLE IF NOT EXISTS ControlAccesosPersonal (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha_Entrada DATETIME NOT NULL,
    Fecha_Salida DATETIME,
    ID_Personal INT NOT NULL,
    Foreign Key (ID_Personal) REFERENCES Personal (ID)
);

CREATE TABLE IF NOT EXISTS Vehiculo (
    Placa VARCHAR(16) PRIMARY KEY,
    ID_Personal INT NOT NULL,
    Foreign Key (ID_Personal) REFERENCES Personal (ID)
);

CREATE TABLE IF NOT EXISTS ControlAccesosVehicular (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha_Entrada DATETIME NOT NULL,
    Fecha_Salida DATETIME,
    Placa VARCHAR(16) NOT NULL,
    Foreign Key (Placa) REFERENCES Vehiculo (Placa)
);

CREATE TABLE IF NOT EXISTS Empresas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(256) NOT NULL UNIQUE,
    Contacto VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS EmpresasPersonal (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ID_Empresa INT NOT NULL,
    ID_Personal INT NOT NULL,
    Foreign Key (ID_Empresa) REFERENCES Empresas (ID),
    Foreign Key (ID_Personal) REFERENCES Personal (ID)
);

CREATE TABLE IF NOT EXISTS Restricciones (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Descripcion VARCHAR(256) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS RestriccionesPersonal (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha DATE NOT NULL,
    Usuario_Responsable VARCHAR(64) NOT NULL,
    ID_Restriccion INT NOT NULL,
    ID_Personal INT NOT NULL,
    Foreign Key (ID_Restriccion) REFERENCES Restricciones (ID),
    Foreign Key (ID_Personal) REFERENCES Personal (ID)
);

CREATE TABLE IF NOT EXISTS Incidentes (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Descripcion VARCHAR(256) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS IncidentesPersonal (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha DATETIME NOT NULL,
    Descripcion TEXT,
    Usuario_Responsable VARCHAR(64) NOT NULL,
    ID_Incidente INT NOT NULL,
    ID_Personal INT NOT NULL,
    Foreign Key (ID_Incidente) REFERENCES Incidentes (ID),
    Foreign Key (ID_Personal) REFERENCES Personal (ID)
);