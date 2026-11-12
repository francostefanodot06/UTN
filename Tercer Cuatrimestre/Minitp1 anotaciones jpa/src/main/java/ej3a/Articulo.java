package ej3a;
import jakarta.persistence.*;

@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoInterno;
    private String descripcionLarga;
    private double precioVenta;

    public Articulo() {}
    public Articulo(String codigoInterno, String descripcionLarga, double precioVenta) {
        this.codigoInterno = codigoInterno;
        this.descripcionLarga = descripcionLarga;
        this.precioVenta = precioVenta;
    }
}
