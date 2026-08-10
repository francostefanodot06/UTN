USE hardware_db;
CREATE OR REPLACE VIEW vista_resumen_financiero AS
SELECT DATE_FORMAT(v.fecha, '%Y-%m') AS mes, COUNT(DISTINCT v.id_venta) AS transacciones, SUM(d.cantidad * d.precio_unitario) AS ingresos_totales
FROM ventas v
JOIN detalles_ventas d ON v.id_venta = d.id_venta
GROUP BY DATE_FORMAT(v.fecha, '%Y-%m');

SELECT * FROM vista_resumen_financiero;
