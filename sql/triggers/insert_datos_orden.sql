DELIMITER $$
CREATE TRIGGER insert_datos_orden
AFTER INSERT ON instalaciones_nuevas
FOR EACH ROW
BEGIN
	INSERT INTO instalaciones (fecha_ingreso, fecha_salida, idtecnico, direccion, telefono, movil, idnodo, email, cedula, estate, cliente, notas, fecha_instalacion, zona, idvendedor, tipo_estrato, plan_solicitado, nit_cliente, info_adicional)
    VALUES(new.fecha_registro, new.fecha_visita, new.idtecnico, new.direccion_servicio, new.movil, new.movil, '', new.email, new.identificacion, new.estado, new.nombre_completo, new.notas, new.fecha_instalacion, );
END;
