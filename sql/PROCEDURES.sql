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
        rpc.Rol AS 'PC_R'
    FROM logregistros lr
    INNER JOIN personal uc ON lr.Usuario_Creador = uc.Usuario_Sistema
    INNER JOIN rol ruc ON uc.ID_Rol = ruc.ID
    INNER JOIN personal pc ON lr.ID_Personal_Creado = pc.ID
    INNER JOIN rol rpc ON pc.ID_Rol = rpc.ID;
END //

DROP PROCEDURE IF EXISTS getpermisosvisitantes;

CREATE PROCEDURE IF NOT EXISTS getpermisosvisitantes ()
BEGIN
    SELECT
        pv.ID,
        pv.Fecha_Inicio,
        pv.Fecha_Fin,
        ur.ID AS 'ID_UR',
        ur.Nombre AS 'UR_N',
        ur.Direccion AS 'UR_D',
        ur.Contacto AS 'UR_C',
        ur.Estado AS 'UR_E',
        ur.Usuario_Sistema AS 'UR_U',
        rur.Rol AS 'UR_R',
        p.ID AS 'ID_P',
        p.Nombre AS 'P_N',
        p.Direccion AS 'P_D',
        p.Contacto AS 'P_C',
        p.Estado AS 'P_E',
        p.Usuario_Sistema AS 'P_U',
        rp.Rol AS 'P_R'
    FROM permisosvisitantes pv
    INNER JOIN personal ur ON pv.Usuario_Responsable = ur.Usuario_Sistema
    INNER JOIN rol rur ON ur.ID_Rol = rur.ID
    INNER JOIN personal p ON pv.ID_Personal = p.ID
    INNER JOIN rol rp ON p.ID_Rol = rp.ID;
END //

DROP PROCEDURE IF EXISTS getrestriccionespersonal;

CREATE PROCEDURE IF NOT EXISTS getrestriccionespersonal ()
BEGIN
    SELECT
        rpe.ID,
        rpe.Fecha,
        ur.ID AS 'ID_UR',
        ur.Nombre AS 'UR_N',
        ur.Direccion AS 'UR_D',
        ur.Contacto AS 'UR_C',
        ur.Estado AS 'UR_E',
        ur.Usuario_Sistema AS 'UR_U',
        rur.Rol AS 'UR_R',
        r.Descripcion,
        p.ID AS 'ID_P',
        p.Nombre AS 'P_N',
        p.Direccion AS 'P_D',
        p.Contacto AS 'P_C',
        p.Estado AS 'P_E',
        p.Usuario_Sistema AS 'P_U',
        rp.Rol AS 'P_R'
    FROM restriccionespersonal rpe
    INNER JOIN personal ur ON rpe.Usuario_Responsable = ur.Usuario_Sistema
    INNER JOIN rol rur ON ur.ID_Rol = rur.ID
    INNER JOIN restricciones r ON rpe.ID_Restriccion = r.ID
    INNER JOIN personal p ON rpe.ID_Personal = p.ID
    INNER JOIN rol rp ON p.ID_Rol = rp.ID;
END //

DROP PROCEDURE IF EXISTS getlogcambioestado;

CREATE PROCEDURE IF NOT EXISTS getlogcambioestado ()
BEGIN
    SELECT
        lce.ID,
        lce.Fecha,
        lce.Nuevo_Estado,
        lce.Descripcion,
        ur.ID AS 'ID_UR',
        ur.Nombre AS 'UR_N',
        ur.Direccion AS 'UR_D',
        ur.Contacto AS 'UR_C',
        ur.Estado AS 'UR_E',
        ur.Usuario_Sistema AS 'UR_U',
        rur.Rol AS 'UR_R',
        p.ID AS 'ID_P',
        p.Nombre AS 'P_N',
        p.Direccion AS 'P_D',
        p.Contacto AS 'P_C',
        p.Estado AS 'P_E',
        p.Usuario_Sistema AS 'P_U',
        rp.Rol AS 'P_R'
    FROM logcambioestado lce
    INNER JOIN personal ur ON lce.Usuario_Responsable = ur.Usuario_Sistema
    INNER JOIN rol rur ON ur.ID_Rol = rur.ID
    INNER JOIN personal p ON lce.ID_Personal = p.ID
    INNER JOIN rol rp ON p.ID_Rol = rp.ID;
END //

DROP PROCEDURE IF EXISTS getincidentespersonal;

CREATE PROCEDURE IF NOT EXISTS getincidentespersonal ()
BEGIN
    SELECT
        ipe.ID,
        ipe.Fecha,
        ipe.Descripcion,
        ur.ID AS 'ID_UR',
        ur.Nombre AS 'UR_N',
        ur.Direccion AS 'UR_D',
        ur.Contacto AS 'UR_C',
        ur.Estado AS 'UR_E',
        ur.Usuario_Sistema AS 'UR_U',
        rur.Rol AS 'UR_R',
        i.Descripcion AS 'I_D',
        p.ID AS 'ID_P',
        p.Nombre AS 'P_N',
        p.Direccion AS 'P_D',
        p.Contacto AS 'P_C',
        p.Estado AS 'P_E',
        p.Usuario_Sistema AS 'P_U',
        rp.Rol AS 'P_R'
    FROM incidentespersonal ipe
    INNER JOIN personal ur ON ipe.Usuario_Responsable = ur.Usuario_Sistema
    INNER JOIN rol rur ON ur.ID_Rol = rur.ID
    INNER JOIN incidentes i ON ipe.ID_Incidente = i.ID
    INNER JOIN personal p ON ipe.ID_Personal = p.ID
    INNER JOIN rol rp ON p.ID_Rol = rp.ID;
END //

DROP PROCEDURE IF EXISTS creausuario;

CREATE PROCEDURE IF NOT EXISTS creausuario (
    IN usuario VARCHAR(50),
    IN host VARCHAR(50),
    IN contrasena VARCHAR(50),
    IN rol VARCHAR(20)
)
BEGIN
    -- crear usuario
    SET @query_crear_usuario = CONCAT('CREATE USER "', usuario, '"@"', host, '" IDENTIFIED BY "', contrasena, '";');
    PREPARE stmt_crear FROM @query_crear_usuario;
    EXECUTE stmt_crear;
    DEALLOCATE PREPARE stmt_crear;

    -- Asignar permisos
    SET @query_permisos = CONCAT('GRANT ', rol, ' TO "', usuario, '"@"', host, '";');
    PREPARE stmt_permisos FROM @query_permisos;
    EXECUTE stmt_permisos;
    DEALLOCATE PREPARE stmt_permisos;

    SET @default_role = CONCAT('SET DEFAULT ROLE ALL TO "', usuario, '"@"', host, '";');
    PREPARE stmt_defaultrole FROM @default_role;
    EXECUTE stmt_defaultrole;
    DEALLOCATE PREPARE stmt_defaultrole;
END //

DELIMITER ;