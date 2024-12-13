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

DELIMITER ;