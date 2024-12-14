-- Inserciones para la base de datos ComplejoACME
USE complejoacme;
-- Tabla rol
INSERT INTO rol (Rol) VALUES
('Visitante'),
('Guarda'),
('Supervisor'),
('Funcionario'),
('Empleado');

-- Tabla restricciones
INSERT INTO restricciones (Descripcion) VALUES
('Prohibición acceso: 1 Semana'),
('Prohibición acceso: 1 mes'),
('Prohibición acceso: 3 meses'),
('Prohibición acceso: 6 meses'),
('Prohibición acceso: 1 año'),
('Prohibición acceso: Indefinidamente');

-- Tabla personal
INSERT INTO personal (ID, Nombre, Direccion, Contacto, Estado, ID_Rol) VALUES
(1234567890 ,'Juan Perez', 'Av. Siempre Viva 123', '123456789', TRUE, 1),
(9876543210 ,'Maria Gomez', 'Calle Falsa 456', '987654321', FALSE, 5),
(4561237890 ,'Luis Martinez', 'Plaza Central 789', '654321987', TRUE, 1),
(3216549870 ,'Ana Lopez', 'Pasaje Luna 111', '321654987', TRUE, 5),
(6549873210 ,'Carlos Sanchez', 'Av. Sol 222', '456789123', FALSE, 1),
(7894561230 ,'Lucia Perez', 'Calle Estrella 333', '789123456', TRUE, 5),
(1237896540 ,'Jose Ramirez', 'Plaza Norte 444', '987123654', TRUE, 1),
(9873216540 ,'Elena Diaz', 'Pasaje Sur 555', '123789456', TRUE, 5),
(6541239870 ,'Pedro Torres', 'Calle Mar 666', '654987321', FALSE, 1),
(3219876540 ,'Carmen Rojas', 'Av. Río 777', '321987654', TRUE, 5),
(7891234560 ,'Ricardo Ortiz', 'Calle Viento 888', '456123789', TRUE, 1),
(4567891230 ,'Sofia Herrera', 'Plaza Este 999', '789456123', TRUE, 5),
(9876541230 ,'Fernando Ruiz', 'Av. Otoño 101', '987654123', FALSE, 1),
(1234569870 ,'Gabriela Castro', 'Calle Invierno 202', '123456987', TRUE, 5),
(6543211230 ,'Miguel Vega', 'Plaza Verano 303', '654321123', TRUE, 1),
(3216541230 ,'Paola Morales', 'Pasaje Primavera 404', '321654123', TRUE, 5),
(4567896540 ,'Ramon Aguilar', 'Av. Lluvia 505', '456789654', FALSE, 1),
(7891239870 ,'Marta Ortiz', 'Calle Sol 606', '789123987', TRUE, 5),
(9871233210 ,'Hector Mendoza', 'Plaza Luna 707', '987123321', TRUE, 1),
(1239874560 ,'Alejandra Cruz', 'Pasaje Mar 808', '123987456', TRUE, 5),
(4561237891 ,'Diego Fernandez', 'Av. Central 121', '456123789', TRUE, 1),
(7893214561 ,'Laura Jimenez', 'Calle Luna 332', '789321456', FALSE, 5),
(1236549871 ,'Julio Torres', 'Pasaje Sur 231', '123654987', TRUE, 1),
(3214567891 ,'Andrea Vargas', 'Plaza Norte 555', '321456789', TRUE, 5),
(6549873211 ,'Esteban Suarez', 'Av. Oriente 102', '654987321', FALSE, 1),
(4567896541 ,'Claudia Gomez', 'Calle Sol 707', '456789654', TRUE, 5),
(7891239871 ,'Daniela Ramirez', 'Pasaje Oeste 333', '789123987', TRUE, 1),
(9874561231 ,'Victor Hernandez', 'Plaza Este 606', '987456123', TRUE, 5),
(3219876541 ,'Cristina Paredes', 'Av. Mar 404', '321987654', FALSE, 1);

INSERT INTO personal (ID, Nombre, Direccion, Contacto, Estado, Usuario_Sistema, ID_Rol) VALUES
(6549871231, 'Francisco Garcia', 'Plaza Invierno 787', '654987123', TRUE, "guarda1", 2),
(9873216541, 'Isabel Perez', 'Av. Primavera 898', '987321654', FALSE, "supervisor1", 3),
(1234569871, 'Juanita Serrano', 'Calle Luna 909', '123456987', TRUE, "funcionario1", 4),
(6541239871, 'Roberto Lopez', 'Calle Invierno 818', '654123987', TRUE, "guarda2", 2),
(1237894561, 'Patricia Ortega', 'Pasaje Primavera 909', '123789456', TRUE, "supervisor2", 3),
(9876547891, 'Luis Vega', 'Plaza Sur 323', '987654789', TRUE, "funcionario2", 4),
(4563219871, 'Carla Ruiz', 'Av. Norte 444', '456321987', FALSE, "guarda3", 2),
(7894563211, 'Emilio Castro', 'Calle Sol 565', '789456321', TRUE, "supervisor3", 3),
(3216547891, 'Cecilia Reyes', 'Pasaje Oeste 676', '321654789', TRUE, "funcionario3", 4);

-- Tabla permisosvisitantes
INSERT INTO permisosvisitantes (Fecha_Inicio, Fecha_Fin, Usuario_Responsable, ID_Personal) VALUES
('2024-11-01', '2024-11-07', 'funcionario1', 1234567890),
('2024-11-02', '2024-11-05', 'funcionario2', 4561237890),
('2024-11-03', '2024-11-08', 'funcionario1', 6549873210),
('2024-11-04', '2024-11-10', 'funcionario3', 1237896540),
('2024-11-05', '2024-11-12', 'funcionario2', 6541239870),
('2024-11-06', '2024-11-15', 'funcionario1', 7891234560),
('2024-11-07', '2024-11-16', 'funcionario3', 9876541230),
('2024-11-08', '2024-11-18', 'funcionario3', 6543211230),
('2024-11-09', '2024-11-19', 'funcionario2', 4567896540),
('2024-11-10', '2024-11-20', 'funcionario1', 9871233210);

-- Tabla logregistros
INSERT INTO logregistros (Fecha, Usuario_Creador, ID_Personal_Creado) VALUES
('2024-11-01 08:00:00', 'funcionario1', 4567896541),
('2024-11-02 09:00:00', 'funcionario2', 4563219871),
('2024-11-03 10:30:00', 'supervisor1', 6541239871),
('2024-11-04 11:15:00', 'funcionario3', 7891239871),
('2024-11-05 12:45:00', 'supervisor2', 7893214561),
('2024-11-06 13:00:00', 'funcionario3', 1239874560),
('2024-11-07 14:30:00', 'supervisor3', 3219876540),
('2024-11-08 15:00:00', 'funcionario2', 3216549870),
('2024-11-09 16:20:00', 'supervisor1', 1234567890),
('2024-11-10 17:50:00', 'funcionario1', 3219876541);

-- Tabla logcambioestado
INSERT INTO logcambioestado (Fecha, Nuevo_Estado, Descripcion, Usuario_Responsable, ID_Personal) VALUES
('2024-11-01 08:30:00', TRUE, 'Activación inicial', 'supervisor1', 9873216541),
('2024-11-02 09:15:00', FALSE, 'Inactivación por falta', 'supervisor2', 1237894561),
('2024-11-03 10:45:00', TRUE, 'Reactivación manual', 'supervisor1', 7894563211),
('2024-11-04 11:20:00', TRUE, 'Activación después de revisión', 'supervisor3', 9873216541),
('2024-11-05 13:00:00', FALSE, 'Inactivación temporal', 'supervisor2', 1237894561),
('2024-11-06 14:00:00', TRUE, 'Reactivación automática', 'supervisor3', 7894563211),
('2024-11-07 15:10:00', TRUE, 'Activación tras cambio de estado', 'supervisor2', 9873216541),
('2024-11-08 16:20:00', FALSE, 'Inactivación preventiva', 'supervisor1', 1237894561),
('2024-11-09 17:30:00', TRUE, 'Reactivación programada', 'supervisor3', 7894563211),
('2024-11-10 18:00:00', TRUE, 'Activación final', 'supervisor2', 9873216541);

-- Tabla controlaccesospersonal
INSERT INTO controlaccesospersonal (Fecha_Entrada, Fecha_Salida, ID_Personal) VALUES
('2024-11-01 07:00:00', '2024-11-01 17:00:00', 6549871231),
('2024-11-02 08:00:00', '2024-11-02 18:00:00', 6541239871),
('2024-11-03 09:00:00', '2024-11-03 19:00:00', 4563219871),
('2024-11-04 07:30:00', '2024-11-04 17:30:00', 6549871231),
('2024-11-05 08:30:00', '2024-11-05 18:30:00', 6541239871),
('2024-11-06 09:15:00', '2024-11-06 19:15:00', 4563219871),
('2024-11-07 07:45:00', '2024-11-07 17:45:00', 6549871231),
('2024-11-08 08:20:00', '2024-11-08 18:20:00', 6541239871),
('2024-11-09 09:10:00', '2024-11-09 19:10:00', 4563219871),
('2024-11-10 07:50:00', '2024-11-10 17:50:00', 6549871231);

-- Tabla vehiculo
INSERT INTO vehiculo (Placa, ID_Personal) VALUES
('ABC123', 6549871231),
('DEF456', 4561237891),
('GHI789', 4567896541),
('JKL012', 9876541230),
('MNO345', 6549873210),
('PQR678', 9873216540),
('STU901', 9876547891),
('VWX234', 1236549871),
('YZA567', 6543211230),
('BCD890', 4563219871);

-- Tabla controlaccesosvehicular
INSERT INTO controlaccesosvehicular (Fecha_Entrada, Fecha_Salida, Placa) VALUES
('2024-11-01 07:10:00', '2024-11-01 17:10:00', 'ABC123'),
('2024-11-02 08:10:00', '2024-11-02 18:10:00', 'DEF456'),
('2024-11-03 09:10:00', '2024-11-03 19:10:00', 'GHI789'),
('2024-11-04 07:40:00', '2024-11-04 17:40:00', 'JKL012'),
('2024-11-05 08:40:00', '2024-11-05 18:40:00', 'MNO345'),
('2024-11-06 09:20:00', '2024-11-06 19:20:00', 'PQR678'),
('2024-11-07 07:55:00', '2024-11-07 17:55:00', 'STU901'),
('2024-11-08 08:25:00', '2024-11-08 18:25:00', 'VWX234'),
('2024-11-09 09:15:00', '2024-11-09 19:15:00', 'YZA567'),
('2024-11-10 07:55:00', '2024-11-10 17:55:00', 'BCD890');

-- Tabla empresas
INSERT INTO empresas (Nombre, Contacto) VALUES
('ACME Security', 'security@acme.com'),
('Empresa Alpha', 'alpha@empresa.com'),
('Empresa Beta', 'beta@empresa.com'),
('Empresa Gamma', 'gamma@empresa.com'),
('Empresa Delta', 'delta@empresa.com'),
('Empresa Epsilon', 'epsilon@empresa.com'),
('Empresa Zeta', 'zeta@empresa.com'),
('Empresa Eta', 'eta@empresa.com'),
('Empresa Theta', 'theta@empresa.com'),
('Empresa Iota', 'iota@empresa.com'),
('Empresa Kappa', 'kappa@empresa.com');

-- Tabla empresaspersonal
INSERT INTO empresaspersonal (ID_Empresa, ID_Personal) VALUES
(1, 6549871231),
(1, 9873216541),
(1, 1234569871),
(1, 6541239871),
(1, 1237894561),
(1, 9876547891),
(1, 4563219871),
(1, 7894563211),
(1, 3216547891),
(1, 3216549870),
(2, 4567891230),
(3, 9873216540),
(4, 3216541230),
(5, 1234567890),
(6, 6549873210),
(7, 4561237890),
(8, 6549873211),
(9, 9876543210),
(10, 3219876541);

-- Tabla restriccionespersonal
INSERT INTO restriccionespersonal (Fecha, Usuario_Responsable, ID_Restriccion, ID_Personal) VALUES
('2024-11-01', 'supervisor1', 1, 6549873210),
('2024-11-02', 'supervisor2', 2, 6541239870),
('2024-11-03', 'supervisor3', 3, 3219876541),
('2024-11-04', 'supervisor2', 4, 9876543210),
('2024-11-05', 'supervisor1', 5, 6549873211),
('2024-11-06', 'supervisor2', 6, 9876541230),
('2024-11-07', 'supervisor3', 1, 7893214561),
('2024-11-08', 'supervisor2', 2, 4567896540),
('2024-11-09', 'supervisor1', 3, 4563219871),
('2024-11-10', 'supervisor2', 4, 9873216541);

-- Tabla incidentes
INSERT INTO incidentes (Descripcion) VALUES
('Incidente menor'),
('Incidente grave'),
('Falla técnica'),
('Error humano'),
('Problema de seguridad'),
('Accidente laboral'),
('Emergencia médica'),
('Evacuación preventiva'),
('Robo menor'),
('Falta de cumplimiento de normas'),
('Otro');

-- Tabla incidentespersonal
INSERT INTO incidentespersonal (Fecha, Descripcion, Usuario_Responsable, ID_Incidente, ID_Personal) VALUES
('2024-11-01 10:00:00', 'Revisión de conducta', 'supervisor1', 1, 6549873210),
('2024-11-02 11:15:00', 'Accidente sin lesiones', 'supervisor2', 6, 6541239870),
('2024-11-03 12:30:00', 'Reporte de falla', 'supervisor3', 3, 3219876541),
('2024-11-04 14:00:00', 'Evacuación por alarma', 'supervisor2', 8, 9876543210),
('2024-11-05 15:15:00', 'Informe de robo', 'supervisor1', 9, 6549873211),
('2024-11-06 16:20:00', 'Problema resuelto', 'supervisor2', 4, 9876541230),
('2024-11-07 17:30:00', 'Atención médica', 'supervisor3', 7, 7893214561),
('2024-11-08 18:45:00', 'Problema técnico menor', 'supervisor2', 5, 4567896540),
('2024-11-09 19:50:00', 'Conducta inapropiada', 'supervisor1', 10, 4563219871),
('2024-11-10 20:55:00', 'Acción preventiva', 'supervisor2', 2, 9873216541);