package ej2;

public class Producto {
    private Long id;
    private String nombre;
    private double precio;
    private String categoria;
    private double costoProduccion;
    private double margenGanancia;

    // Constructor con todos los parámetros[cite: 25, 33]
    public Producto(Long id, String nombre, double precio, String categoria, double costoProduccion, double margenGanancia) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.costoProduccion = costoProduccion;
        this.margenGanancia = margenGanancia;
    }

    // Getters necesarios para fromEntity
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getCategoria() { return categoria; }
    public double getCostoProduccion() { return costoProduccion; }
    public double getMargenGanancia() { return margenGanancia; }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio +
                ", categoria='" + categoria + "', costoProduccion=" + costoProduccion +
                ", margenGanancia=" + margenGanancia + "}";
    }
}