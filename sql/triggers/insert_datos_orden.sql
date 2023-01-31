DROP TRIGGER IF EXISTS insert_datos_orden;
DELIMITER $$
CREATE TRIGGER insert_datos_orden
AFTER INSERT ON instalaciones_nuevas
FOR EACH ROW
BEGIN
	
    
    INSERT INTO instalaciones (fecha_ingreso, fecha_salida, idtecnico, direccion, telefono, movil, idnodo, email, cedula, estate, cliente, notas, fecha_instalacion, zona, idvendedor, tipo_estrato, plan_solicitado, nit_cliente, info_adicional, id_instalacion_nueva_app)
    VALUES(new.fecha_registro, new.fecha_visita, new.idtecnico, new.direccion_servicio, new.movil, new.movil, '', new.correo_electronico, new.identificacion, new.estado, new.nombre_completo, new.notas, new.fecha_registro, new.idzona, null, 0, new.idplan, new.nit, new.notas, new.id);
    
    -- SET new.wisp_instalacion_id = (SELECT 'AUTO_INCREMENT' FROM information_schema.tables where table_name = 'instalaciones');
    
END;
