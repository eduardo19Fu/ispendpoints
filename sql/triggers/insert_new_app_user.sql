DELIMITER $$
CREATE TRIGGER insert_new_app_user
AFTER INSERT ON login
FOR EACH ROW
BEGIN
	insert into app_movil_user
END;