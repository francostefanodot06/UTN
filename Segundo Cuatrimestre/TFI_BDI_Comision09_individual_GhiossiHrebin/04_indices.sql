USE hardware_db;
CREATE INDEX idx_ventas_fecha ON ventas(fecha);
CREATE INDEX idx_detalles_producto ON detalles_ventas(id_producto);
