DROP TRIGGER IF EXISTS update_estado_instalacion;
DELIMITER $$
CREATE TRIGGER update_estado_instalacion
AFTER UPDATE ON instalaciones_nuevas
FOR EACH ROW
BEGIN
	UPDATE instalaciones AS inst
    SET inst.estate = new.estado, inst.fecha_instalacion = new.fecha_instalacion
    WHERE inst.id_instalacion_nueva_app = old.id;
END$$
DELIMITER ;