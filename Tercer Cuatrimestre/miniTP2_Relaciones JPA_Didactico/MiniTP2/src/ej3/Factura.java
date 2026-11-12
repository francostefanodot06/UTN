package ej3;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FACTURAS")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO", unique = true, nullable = false)
    private String numero;

    @OneToMany
    @JoinColumn(name = "factura_id")
    private List<ItemFactura> items = new ArrayList<>();

    public Factura() { }

    public Factura(String numero) {
        this.numero = numero;
    }

    public Long getId() { return id; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public List<ItemFactura> getItems() { return items; }
    public void setItems(List<ItemFactura> items) { this.items = items; }
}
