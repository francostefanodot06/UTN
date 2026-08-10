USE hardware_db;

DROP PROCEDURE IF EXISTS CargaMasivaData;
DELIMITER //
CREATE PROCEDURE CargaMasivaData()
BEGIN
    DECLARE i INT DEFAULT 1;
    DECLARE cliente_id INT;
    DECLARE producto_id INT;
    
    WHILE i <= 1000 DO
        INSERT INTO clientes (dni, nombre, apellido, email) 
        VALUES (CONCAT('DNI', i), CONCAT('Nombre', i), CONCAT('Apellido', i), CONCAT('user', i, '@mail.com'));
        SET i = i + 1;
    END WHILE;
    
    SET i = 1;
    WHILE i <= 10000 DO
        SET cliente_id = FLOOR(1 + (RAND() * 999));
        INSERT INTO ventas (id_cliente, fecha) 
        VALUES (cliente_id, DATE_SUB(NOW(), INTERVAL FLOOR(RAND() * 365) DAY));
        SET i = i + 1;
    END WHILE;

    SET i = 1;
    WHILE i <= 10000 DO
        SET producto_id = FLOOR(1 + (RAND() * 5));
        INSERT INTO detalles_ventas (id_venta, id_producto, cantidad, precio_unitario)
        VALUES (i, producto_id, FLOOR(1 + (RAND() * 3)), 50000.00);
        SET i = i + 1;
    END WHILE;
END //
DELIMITER ;

CALL CargaMasivaData();

SELECT COUNT(*) AS total_clientes FROM clientes;
SELECT COUNT(*) AS total_ventas FROM ventas;
SELECT COUNT(*) AS total_detalles FROM detalles_ventas;
