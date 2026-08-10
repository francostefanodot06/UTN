USE hardware_db;

SELECT c.apellido, c.nombre, v.fecha, p.nombre AS producto, d.cantidad 
FROM clientes c
JOIN ventas v ON c.id_cliente = v.id_cliente
JOIN detalles_ventas d ON v.id_venta = d.id_venta
JOIN productos p ON d.id_producto = p.id_producto
LIMIT 10;

SELECT p.nombre, SUM(d.cantidad) AS unidades_vendidas, SUM(d.cantidad * d.precio_unitario) AS total_recaudado
FROM productos p
JOIN detalles_ventas d ON p.id_producto = d.id_producto
GROUP BY p.id_producto, p.nombre
HAVING total_recaudado > 500000
ORDER BY unidades_vendidas DESC;

SELECT id_cliente, nombre, email 
FROM clientes 
WHERE id_cliente IN (
    SELECT v.id_cliente 
    FROM ventas v 
    JOIN detalles_ventas d ON v.id_venta = d.id_venta 
    WHERE d.precio_unitario > (SELECT AVG(precio_unitario) FROM detalles_ventas)
);
