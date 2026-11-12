package ej2;
import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE_PRODUCTO", nullable = false, length = 100)
    private String nombre;

    @Column(name = "CODIGO_BARRA", nullable = false, unique = true, length = 30)
    private String codigoBarra;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable = false, length = 20)
    private EstadoProducto estado;

    @Transient
    private int stockDisponibleCalculado;

    public Producto() {}
    public Producto(String nombre, String codigoBarra, EstadoProducto estado, int stockDisponibleCalculado) {
        this.nombre = nombre;
        this.codigoBarra = codigoBarra;
        this.estado = estado;
        this.stockDisponibleCalculado = stockDisponibleCalculado;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCodigoBarra() { return codigoBarra; }
    public EstadoProducto getEstado() { return estado; }
    public int getStockDisponibleCalculado() { return stockDisponibleCalculado; }
}
