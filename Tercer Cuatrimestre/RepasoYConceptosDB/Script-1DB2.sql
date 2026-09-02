-- a) Insertar 1 cliente y 2 productos en sus respectivas tablas.
INSERT INTO CLIENTES (id_cliente, nombre, email, fecha_registro) 
VALUES (1, 'Franco', 'franco@email.com', '2026-08-20');

INSERT INTO PRODUCTOS (id_producto, nombre, precio, stock) 
VALUES 
(1, 'Monitor 144hz', 250.00, 15), 
(2, 'Teclado Mecanico', 85.00, 30);

-- b) Actualizar el stock de uno de los productos insertados, estableciendo su valor en 5 unidades.
UPDATE PRODUCTOS 
SET stock = 5 
WHERE id_producto = 1;

-- c) Eliminar los pedidos cuya fecha sea anterior al año 2026.
DELETE FROM PEDIDOS 
WHERE fecha < '2026-01-01';

-- d) Listar todos los productos cuyo precio sea mayor a 100.
SELECT * FROM PRODUCTOS 
WHERE precio > 100;

-- e) Mostrar el nombre del cliente y la fecha de cada pedido
SELECT c.nombre, p.fecha 
FROM CLIENTES c 
JOIN PEDIDOS p ON c.id_cliente = p.cliente_id;

-- f) Obtener la cantidad de pedidos por cliente
SELECT c.nombre, COUNT(p.id_pedido) AS cantidad_pedidos 
FROM CLIENTES c 
LEFT JOIN PEDIDOS p ON c.id_cliente = p.cliente_id 
GROUP BY c.id_cliente, c.nombre;