USE hardware_db;
-- Sesión 1:
-- SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
-- START TRANSACTION;
-- SELECT stock FROM productos WHERE id_producto = 1;

-- Sesión 2:
-- START TRANSACTION;
-- UPDATE productos SET stock = stock - 1 WHERE id_producto = 1;
-- COMMIT;
