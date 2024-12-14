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
        p.Usuario_Sistema,
        r.Rol
    FROM personal p
    INNER JOIN rol r ON p.ID_Rol = r.ID;
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
        p.Usuario_Sistema,
        r.Rol
    FROM vehiculo v
    INNER JOIN personal p ON p.ID = v.ID_Personal
    INNER JOIN rol r ON p.ID_Rol = r.ID;
END //

DROP PROCEDURE IF EXISTS getcavehiculo;

CREATE PROCEDURE IF NOT EXISTS getcavehiculo ()
BEGIN
    SELECT
        cav.ID AS 'ID_CAV',
        cav.Fecha_Entrada,
        cav.Fecha_Salida,
        v.Placa,
        p.ID AS 'ID_P',
        p.Nombre,
        p.Direccion,
        p.Contacto,
        p.Estado,
        p.Usuario_Sistema,
        r.Rol
    FROM controlaccesosvehicular cav
    INNER JOIN vehiculo v ON cav.Placa = v.Placa
    INNER JOIN personal p ON p.ID = v.ID_Personal
    INNER JOIN rol r ON p.ID_Rol = r.ID;
END //

DROP PROCEDURE IF EXISTS getempresapersonal;

CREATE PROCEDURE IF NOT EXISTS getempresapersonal ()
BEGIN
    SELECT
        e.ID AS 'ID_E',
        e.Nombre AS 'N_E',
        e.Contacto AS 'E_C',
        ep.ID AS 'ID_EP',
        p.ID AS 'ID_P',
        p.Nombre AS "N_P",
        p.Direccion,
        p.Contacto AS 'P_C',
        p.Estado,
        p.Usuario_Sistema,
        r.Rol
    FROM empresaspersonal ep
    INNER JOIN empresas e ON ep.ID_Empresa = e.ID
    INNER JOIN personal p ON ep.ID_Personal = p.ID
    INNER JOIN rol r ON p.ID_Rol = r.ID;
END //

DROP PROCEDURE IF EXISTS getcapersonal;

CREATE PROCEDURE IF NOT EXISTS getcapersonal ()
BEGIN
    SELECT
        cap.ID AS 'ID_CAP',
        cap.Fecha_Entrada,
        cap.Fecha_Salida,
        p.ID AS 'ID_P',
        p.Nombre,
        p.Direccion,
        p.Contacto,
        p.Estado,
        p.Usuario_Sistema,
        r.Rol
    FROM controlaccesospersonal cap
    INNER JOIN personal p ON cap.ID_Personal = p.ID
    INNER JOIN rol r ON p.ID_Rol = r.ID;
END //

DROP PROCEDURE IF EXISTS getlogregistros;

CREATE PROCEDURE IF NOT EXISTS getlogregistros ()
BEGIN
    SELECT
        lr.ID,
        lr.Fecha,
        uc.ID AS 'ID_UC',
        uc.Nombre AS 'UC_N',
        uc.Direccion AS 'UC_D',
        uc.Contacto AS 'UC_C',
        uc.Estado AS 'UC_E',
        uc.Usuario_Sistema AS 'UC_U',
        ruc.Rol AS 'UC_R',
        pc.ID AS 'ID_PC',
        pc.Nombre AS 'PC_N',
        pc.Direccion AS 'PC_D',
        pc.Contacto AS 'PC_C',
        pc.Estado AS 'PC_E',
        pc.Usuario_Sistema AS 'PC_U',
        ruc.Rol AS 'PC_R'
    FROM logregistros lr
    INNER JOIN personal uc ON lr.Usuario_Creador = uc.Usuario_Sistema
    INNER JOIN rol ruc ON uc.ID_Rol = ruc.ID
    INNER JOIN personal pc ON lr.ID_Personal_Creado = pc.ID
    INNER JOIN rol rpc ON pc.ID_Rol = rpc.ID;
END //

DELIMITER ;