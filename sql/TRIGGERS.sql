USE complejoacme;

DELIMITER //

DROP TRIGGER IF EXISTS insertslogregistros;

CREATE TRIGGER IF NOT EXISTS insertslogregistros
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
        SUBSTRING_INDEX(USER(), '@', 1),
        NEW.ID
    );
END //

DELIMITER ;