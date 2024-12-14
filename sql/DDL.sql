DROP DATABASE IF EXISTS complejoacme;

CREATE DATABASE IF NOT EXISTS complejoacme;

USE complejoacme;

CREATE TABLE IF NOT EXISTS rol (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Rol VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS personal (
    ID BIGINT PRIMARY KEY,
    Nombre VARCHAR(256) NOT NULL,
    Direccion VARCHAR(256) NOT NULL,
    Contacto VARCHAR(128) NOT NULL,
    Estado BOOLEAN NOT NULL,
    Usuario_Sistema VARCHAR(64) UNIQUE,
    ID_Rol INT NOT NULL,
    Foreign Key (ID_Rol) REFERENCES rol (ID)
);

CREATE TABLE IF NOT EXISTS permisosvisitantes (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha_Inicio DATE NOT NULL,
    Fecha_Fin DATE NOT NULL,
    Usuario_Responsable VARCHAR(64) NOT NULL,
    ID_Personal BIGINT NOT NULL,
    Foreign Key (Usuario_Responsable) REFERENCES personal (Usuario_Sistema),
    Foreign Key (ID_Personal) REFERENCES personal (ID)
);

CREATE TABLE IF NOT EXISTS logregistros (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha DATETIME NOT NULL,
    Usuario_Creador VARCHAR(64) NOT NULL,
    ID_Personal_Creado BIGINT NOT NULL,
    Foreign Key (Usuario_Creador) REFERENCES personal (Usuario_Sistema),
    Foreign Key (ID_Personal_Creado) REFERENCES personal (ID)
);

CREATE TABLE IF NOT EXISTS logcambioestado (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha DATETIME NOT NULL,
    Nuevo_Estado BOOLEAN NOT NULL,
    Descripcion TEXT NOT NULL,
    Usuario_Responsable VARCHAR(64) NOT NULL,
    ID_Personal BIGINT NOT NULL,
    Foreign Key (Usuario_Responsable) REFERENCES personal (Usuario_Sistema),
    Foreign Key (ID_Personal) REFERENCES personal (ID)
);

CREATE TABLE IF NOT EXISTS controlaccesospersonal (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha_Entrada DATETIME NOT NULL,
    Fecha_Salida DATETIME,
    ID_Personal BIGINT NOT NULL,
    Foreign Key (ID_Personal) REFERENCES personal (ID)
);

CREATE TABLE IF NOT EXISTS vehiculo (
    Placa VARCHAR(16) PRIMARY KEY,
    ID_Personal BIGINT NOT NULL,
    Foreign Key (ID_Personal) REFERENCES personal (ID)
);

CREATE TABLE IF NOT EXISTS controlaccesosvehicular (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha_Entrada DATETIME NOT NULL,
    Fecha_Salida DATETIME,
    Placa VARCHAR(16) NOT NULL,
    Foreign Key (Placa) REFERENCES vehiculo (Placa)
);

CREATE TABLE IF NOT EXISTS empresas (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(256) NOT NULL UNIQUE,
    Contacto VARCHAR(128) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS empresaspersonal (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    ID_Empresa INT NOT NULL,
    ID_Personal BIGINT NOT NULL,
    Foreign Key (ID_Empresa) REFERENCES empresas (ID),
    Foreign Key (ID_Personal) REFERENCES personal (ID)
);

CREATE TABLE IF NOT EXISTS restricciones (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Descripcion VARCHAR(256) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS restriccionespersonal (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha DATE NOT NULL,
    Usuario_Responsable VARCHAR(64) NOT NULL,
    ID_Restriccion INT NOT NULL,
    ID_Personal BIGINT NOT NULL,
    Foreign Key (Usuario_Responsable) REFERENCES personal (Usuario_Sistema),
    Foreign Key (ID_Restriccion) REFERENCES restricciones (ID),
    Foreign Key (ID_Personal) REFERENCES personal (ID)
);

CREATE TABLE IF NOT EXISTS incidentes (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Descripcion VARCHAR(256) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS incidentespersonal (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Fecha DATETIME NOT NULL,
    Descripcion TEXT,
    Usuario_Responsable VARCHAR(64) NOT NULL,
    ID_Incidente INT NOT NULL,
    ID_Personal BIGINT NOT NULL,
    Foreign Key (Usuario_Responsable) REFERENCES personal (Usuario_Sistema),
    Foreign Key (ID_Incidente) REFERENCES incidentes (ID),
    Foreign Key (ID_Personal) REFERENCES personal (ID)
);