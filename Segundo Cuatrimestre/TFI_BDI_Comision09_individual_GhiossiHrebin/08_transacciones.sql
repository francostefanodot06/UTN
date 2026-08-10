USE hardware_db;

DROP PROCEDURE IF EXISTS RegistrarVentaSegura;
DELIMITER //
CREATE PROCEDURE RegistrarVentaSegura(IN p_id_cliente INT, IN p_id_producto INT, IN p_cantidad INT, IN p_precio DECIMAL(10,2))
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;

    START TRANSACTION;
        INSERT INTO ventas (id_cliente, fecha) VALUES (p_id_cliente, NOW());
        INSERT INTO detalles_ventas (id_venta, id_producto, cantidad, precio_unitario) 
        VALUES (LAST_INSERT_ID(), p_id_producto, p_cantidad, p_precio);
    COMMIT;
END //
DELIMITER ;
