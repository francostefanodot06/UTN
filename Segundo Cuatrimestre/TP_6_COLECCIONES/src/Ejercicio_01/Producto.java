/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_01;

/**
 *
 * @author franker
 */
public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;

    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

   
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public CategoriaProducto getCategoria() { return categoria; }

    public void mostrarInfo() {
        System.out.println("ID: " + id + " | Producto: " + nombre + " | Precio: $" + precio + 
                           " | Stock: " + cantidad + " | Categoría: " + categoria + " (" + categoria.getDescripcion() + ")");
    }

    @Override
    public String toString() {
        return "Producto{" + "id='" + id + '\'' + ", nombre='" + nombre + '\'' + ", precio=" + precio + 
               ", cantidad=" + cantidad + ", categoria=" + categoria + '}';
    }
}
