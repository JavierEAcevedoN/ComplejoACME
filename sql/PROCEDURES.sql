USE complejoacme;

DELIMITER //

DROP PROCEDURE IF EXISTS getpersonal;

CREATE PROCEDURE IF NOT EXISTS getpersonal ()
BEGIN
    SELECT
        p.ID,
        p.Nombre,
        p.Direccion,
        p.Contacto,
        p.Estado,
        r.Rol
    FROM personal p
    INNER JOIN rol r ON p.ID_Rol = r.ID
    ORDER BY p.ID;
END //

DROP PROCEDURE IF EXISTS getvehiculos;

CREATE PROCEDURE IF NOT EXISTS getvehiculos ()
BEGIN
    SELECT
        v.Placa,
        p.ID,
        p.Nombre,
        p.Direccion,
        p.Contacto,
        p.Estado,
        r.Rol
    FROM vehiculo v
    INNER JOIN personal p ON p.ID = v.ID_Personal
    INNER JOIN rol r ON p.ID_Rol = r.ID
    ORDER BY p.ID;
END //

DROP PROCEDURE IF EXISTS getcavehiculo;

CREATE PROCEDURE IF NOT EXISTS getcavehiculo ()
BEGIN
    SELECT
        cav.ID,
        cav.Fecha_Entrada,
        cav.Fecha_Salida,
        v.Placa,
        p.ID AS 'ID_Personal',
        p.Nombre,
        p.Direccion,
        p.Contacto,
        p.Estado,
        r.Rol
    FROM controlaccesosvehicular cav
    INNER JOIN vehiculo v ON cav.Placa = v.Placa
    INNER JOIN personal p ON p.ID = v.ID_Personal
    INNER JOIN rol r ON p.ID_Rol = r.ID
    ORDER BY p.ID;
END //

DELIMITER ;