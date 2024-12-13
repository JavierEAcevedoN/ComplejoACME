USE complejoacme;

DELIMITER //

DROP TRIGGER IF EXISTS insertslogregistros;

CREATE TRIGGER insertslogregistros
AFTER INSERT ON personal
FOR EACH ROW
BEGIN
    INSERT INTO logregistros (
        Fecha,
        Usuario_Creador,
        ID_Personal_Creado
    ) 
    VALUES (
        CURRENT_TIMESTAMP(),
        USER(),
        NEW.ID
    );
END //

DELIMITER ;