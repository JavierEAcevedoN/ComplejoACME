USE ComplejoACME;

DELIMITER //

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
        CURDATE(),
        USER(),
        NEW.ID
    );
END //

DELIMITER ;
