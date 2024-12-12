-- Inserciones para la base de datos ComplejoACME

-- Tabla Rol
INSERT INTO Rol (Rol) VALUES
('Visitante'),
('Guarda'),
('Supervisor'),
('Funcionario'),
('Empleado');

-- Tabla Restricciones
INSERT INTO Restricciones (Descripcion) VALUES
('Prohibición acceso: 1 Semana'),
('Prohibición acceso: 1 mes'),
('Prohibición acceso: 3 meses'),
('Prohibición acceso: 6 meses'),
('Prohibición acceso: 1 año'),
('Prohibición acceso: Indefinidamente');

-- Tabla Personal
INSERT INTO Personal (Nombre, Direccion, Contacto, Estado, ID_Rol) VALUES
('Juan Perez', 'Av. Siempre Viva 123', '123456789', TRUE, 1),
('Maria Gomez', 'Calle Falsa 456', '987654321', FALSE, 3),
('Luis Martinez', 'Plaza Central 789', '654321987', TRUE, 4),
('Ana Lopez', 'Pasaje Luna 111', '321654987', TRUE, 5),
('Carlos Sanchez', 'Av. Sol 222', '456789123', FALSE, 2),
('Lucia Perez', 'Calle Estrella 333', '789123456', TRUE, 3),
('Jose Ramirez', 'Plaza Norte 444', '987123654', TRUE, 4),
('Elena Diaz', 'Pasaje Sur 555', '123789456', TRUE, 5),
('Pedro Torres', 'Calle Mar 666', '654987321', FALSE, 1),
('Carmen Rojas', 'Av. Río 777', '321987654', TRUE, 3),
('Ricardo Ortiz', 'Calle Viento 888', '456123789', TRUE, 1),
('Sofia Herrera', 'Plaza Este 999', '789456123', TRUE, 5),
('Fernando Ruiz', 'Av. Otoño 101', '987654123', FALSE, 2),
('Gabriela Castro', 'Calle Invierno 202', '123456987', TRUE, 3),
('Miguel Vega', 'Plaza Verano 303', '654321123', TRUE, 4),
('Paola Morales', 'Pasaje Primavera 404', '321654123', TRUE, 5),
('Ramon Aguilar', 'Av. Lluvia 505', '456789654', FALSE, 2),
('Marta Ortiz', 'Calle Sol 606', '789123987', TRUE, 3),
('Hector Mendoza', 'Plaza Luna 707', '987123321', TRUE, 4),
('Alejandra Cruz', 'Pasaje Mar 808', '123987456', TRUE, 5),
('Diego Fernandez', 'Av. Central 121', '456123789', TRUE, 2),
('Laura Jimenez', 'Calle Luna 332', '789321456', FALSE, 3),
('Julio Torres', 'Pasaje Sur 231', '123654987', TRUE, 4),
('Andrea Vargas', 'Plaza Norte 555', '321456789', TRUE, 1),
('Esteban Suarez', 'Av. Oriente 102', '654987321', FALSE, 2),
('Claudia Gomez', 'Calle Sol 707', '456789654', TRUE, 3),
('Daniela Ramirez', 'Pasaje Oeste 333', '789123987', TRUE, 4),
('Victor Hernandez', 'Plaza Este 606', '987456123', TRUE, 5),
('Cristina Paredes', 'Av. Mar 404', '321987654', FALSE, 2),
('Roberto Lopez', 'Calle Invierno 818', '654123987', TRUE, 1),
('Patricia Ortega', 'Pasaje Primavera 909', '123789456', TRUE, 4),
('Luis Vega', 'Plaza Sur 323', '987654789', TRUE, 5),
('Carla Ruiz', 'Av. Norte 444', '456321987', FALSE, 2),
('Emilio Castro', 'Calle Sol 565', '789456321', TRUE, 3),
('Cecilia Reyes', 'Pasaje Oeste 676', '321654789', TRUE, 4),
('Francisco Garcia', 'Plaza Invierno 787', '654987123', TRUE, 5),
('Isabel Perez', 'Av. Primavera 898', '987321654', FALSE, 2),
('Juanita Serrano', 'Calle Luna 909', '123456987', TRUE, 1);

-- Tabla PermisosVisitantes
INSERT INTO PermisosVisitantes (Fecha_Inicio, Fecha_Fin, Usuario_Responsable, ID_Personal) VALUES
('2024-11-01', '2024-11-07', 'funcionario1', 1),
('2024-11-02', '2024-11-05', 'funcionario2', 9),
('2024-11-03', '2024-11-08', 'funcionario1', 11),
('2024-11-04', '2024-11-10', 'funcionario3', 24),
('2024-11-05', '2024-11-12', 'funcionario2', 30),
('2024-11-06', '2024-11-15', 'funcionario4', 38),
('2024-11-07', '2024-11-16', 'funcionario3', 38),
('2024-11-08', '2024-11-18', 'funcionario5', 1),
('2024-11-09', '2024-11-19', 'funcionario4', 9),
('2024-11-10', '2024-11-20', 'funcionario6', 11);

-- Tabla LogRegistros
INSERT INTO LogRegistros (Fecha, Usuario_Creador, ID_Personal_Creado) VALUES
('2024-11-01 08:00:00', 'funcionario1', 1),
('2024-11-02 09:00:00', 'funcionario2', 2),
('2024-11-03 10:30:00', 'supervisor1', 3),
('2024-11-04 11:15:00', 'funcionario3', 4),
('2024-11-05 12:45:00', 'supervisor2', 5),
('2024-11-06 13:00:00', 'funcionario4', 6),
('2024-11-07 14:30:00', 'supervisor3', 7),
('2024-11-08 15:00:00', 'funcionario5', 8),
('2024-11-09 16:20:00', 'supervisor4', 9),
('2024-11-10 17:50:00', 'funcionario6', 10);

-- Tabla LogCambioEstado
INSERT INTO LogCambioEstado (Fecha, Nuevo_Estado, Descripcion, Usuario_Responsable, ID_Personal) VALUES
('2024-11-01 08:30:00', TRUE, 'Activación inicial', 'supervisor1', 1),
('2024-11-02 09:15:00', FALSE, 'Inactivación por falta', 'supervisor2', 2),
('2024-11-03 10:45:00', TRUE, 'Reactivación manual', 'supervisor1', 3),
('2024-11-04 11:20:00', TRUE, 'Activación después de revisión', 'supervisor3', 4),
('2024-11-05 13:00:00', FALSE, 'Inactivación temporal', 'supervisor2', 5),
('2024-11-06 14:00:00', TRUE, 'Reactivación automática', 'supervisor3', 6),
('2024-11-07 15:10:00', TRUE, 'Activación tras cambio de estado', 'supervisor4', 7),
('2024-11-08 16:20:00', FALSE, 'Inactivación preventiva', 'supervisor1', 8),
('2024-11-09 17:30:00', TRUE, 'Reactivación programada', 'supervisor4', 9),
('2024-11-10 18:00:00', TRUE, 'Activación final', 'supervisor2', 10);

-- Tabla ControlAccesosPersonal
INSERT INTO ControlAccesosPersonal (Fecha_Entrada, Fecha_Salida, ID_Personal) VALUES
('2024-11-01 07:00:00', '2024-11-01 17:00:00', 1),
('2024-11-02 08:00:00', '2024-11-02 18:00:00', 2),
('2024-11-03 09:00:00', '2024-11-03 19:00:00', 3),
('2024-11-04 07:30:00', '2024-11-04 17:30:00', 4),
('2024-11-05 08:30:00', '2024-11-05 18:30:00', 5),
('2024-11-06 09:15:00', '2024-11-06 19:15:00', 6),
('2024-11-07 07:45:00', '2024-11-07 17:45:00', 7),
('2024-11-08 08:20:00', '2024-11-08 18:20:00', 8),
('2024-11-09 09:10:00', '2024-11-09 19:10:00', 9),
('2024-11-10 07:50:00', '2024-11-10 17:50:00', 10);

-- Tabla Vehiculo
INSERT INTO Vehiculo (Placa, ID_Personal) VALUES
('ABC123', 1),
('DEF456', 2),
('GHI789', 3),
('JKL012', 4),
('MNO345', 5),
('PQR678', 6),
('STU901', 7),
('VWX234', 8),
('YZA567', 9),
('BCD890', 10);

-- Tabla ControlAccesosVehicular
INSERT INTO ControlAccesosVehicular (Fecha_Entrada, Fecha_Salida, Placa) VALUES
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

-- Tabla Empresas
INSERT INTO Empresas (Nombre, Contacto) VALUES
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

-- Tabla EmpresasPersonal
INSERT INTO EmpresasPersonal (ID_Empresa, ID_Personal) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- Tabla RestriccionesPersonal
INSERT INTO RestriccionesPersonal (Fecha, Usuario_Responsable, ID_Restriccion, ID_Personal) VALUES
('2024-11-01', 'supervisor1', 1, 1),
('2024-11-02', 'supervisor2', 2, 2),
('2024-11-03', 'supervisor3', 3, 3),
('2024-11-04', 'supervisor4', 4, 4),
('2024-11-05', 'supervisor1', 5, 5),
('2024-11-06', 'supervisor2', 6, 6),
('2024-11-07', 'supervisor3', 1, 7),
('2024-11-08', 'supervisor4', 2, 8),
('2024-11-09', 'supervisor1', 3, 9),
('2024-11-10', 'supervisor2', 4, 10);

-- Tabla Incidentes
INSERT INTO Incidentes (Descripcion) VALUES
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

-- Tabla IncidentesPersonal
INSERT INTO IncidentesPersonal (Fecha, Descripcion, Usuario_Responsable, ID_Incidente, ID_Personal) VALUES
('2024-11-01 10:00:00', 'Revisión de conducta', 'supervisor1', 1, 1),
('2024-11-02 11:15:00', 'Accidente sin lesiones', 'supervisor2', 6, 2),
('2024-11-03 12:30:00', 'Reporte de falla', 'supervisor3', 3, 3),
('2024-11-04 14:00:00', 'Evacuación por alarma', 'supervisor4', 8, 4),
('2024-11-05 15:15:00', 'Informe de robo', 'supervisor1', 9, 5),
('2024-11-06 16:20:00', 'Problema resuelto', 'supervisor2', 4, 6),
('2024-11-07 17:30:00', 'Atención médica', 'supervisor3', 7, 7),
('2024-11-08 18:45:00', 'Problema técnico menor', 'supervisor4', 5, 8),
('2024-11-09 19:50:00', 'Conducta inapropiada', 'supervisor1', 10, 9),
('2024-11-10 20:55:00', 'Acción preventiva', 'supervisor2', 2, 10);
