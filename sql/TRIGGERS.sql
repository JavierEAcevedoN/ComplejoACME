USE ComplejoACME;

DELIMITER //

DROP TRIGGER IF EXISTS InsertsLogRegistros;

CREATE TRIGGER InsertsLogRegistros
AFTER INSERT ON Personal
FOR EACH ROW
BEGIN
    INSERT INTO LogRegistros (
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
