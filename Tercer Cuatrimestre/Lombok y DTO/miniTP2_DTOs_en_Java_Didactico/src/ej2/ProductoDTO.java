package ej2;

public class ProductoDTO {
    private Long id;
    private String nombre;
    private double precio;
    private String categoria;

    // Constructor que reciba un Producto y asigne los 4 campos[cite: 25, 33]
    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
        this.categoria = producto.getCategoria();
    }

    // Método estático fromEntity para centralizar la conversión[cite: 23, 25, 33]
    public static ProductoDTO fromEntity(Producto producto) {
        return new ProductoDTO(producto);
    }

    @Override
    public String toString() {
        return "ProductoDTO{id=" + id + ", nombre='" + nombre + "', precio=" + precio +
                ", categoria='" + categoria + "'}";
    }
}