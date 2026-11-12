package ej3;

import jakarta.persistence.*;

@Entity
@Table(name = "ITEMS_FACTURA")
public class ItemFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "PRECIO")
    private double precio;

    // Sin ninguna referencia a Factura (relación unidireccional)

    public ItemFactura() { }

    public ItemFactura(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
