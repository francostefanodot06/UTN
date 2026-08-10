USE hardware_db;

DROP USER IF EXISTS 'empleado_ventas'@'localhost';
CREATE USER 'empleado_ventas'@'localhost' IDENTIFIED BY 'PasswordSeguro123!';

GRANT SELECT, INSERT, UPDATE ON hardware_db.ventas TO 'empleado_ventas'@'localhost';
GRANT SELECT, INSERT, UPDATE ON hardware_db.detalles_ventas TO 'empleado_ventas'@'localhost';
GRANT SELECT ON hardware_db.productos TO 'empleado_ventas'@'localhost';

CREATE OR REPLACE VIEW vista_clientes_publica AS
SELECT id_cliente, CONCAT(LEFT(nombre, 2), '***') AS nombre_oculto, apellido FROM clientes;

GRANT SELECT ON hardware_db.vista_clientes_publica TO 'empleado_ventas'@'localhost';
FLUSH PRIVILEGES;
