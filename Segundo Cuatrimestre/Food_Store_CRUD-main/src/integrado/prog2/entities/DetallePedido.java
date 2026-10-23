/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.entities;

/**
 *
 * @author franker
 */
public class DetallePedido extends Base {
    private int cantidad;
    private double subtotal;
    private Producto producto;

    public DetallePedido(int cantidad, Producto producto) {
        super();
        this.cantidad = cantidad;
        this.producto = producto;
        this.subtotal = cantidad * (producto != null ? producto.getPrecio() : 0.0);
    }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { 
        this.cantidad = cantidad;
        recalcularSubtotal();
    }

    public double getSubtotal() { return subtotal; }
    // Eliminamos setSubtotal(double) manual para evitar inconsistencias externas
    
    public void recalcularSubtotal() {
        this.subtotal = this.cantidad * (this.producto != null ? this.producto.getPrecio() : 0.0);
    }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { 
        this.producto = producto;
        recalcularSubtotal();
    }

    @Override
    public String toString() {
        return "  - Detalle [ID=" + getId() + ", Prod=" + (producto != null ? producto.getNombre() : "N/A") + ", Cantidad=" + cantidad + ", Subtotal=$" + subtotal + "]";
    }
}
