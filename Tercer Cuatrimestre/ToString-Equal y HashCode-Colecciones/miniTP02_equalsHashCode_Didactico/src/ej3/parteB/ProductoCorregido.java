package ej3.parteB;

import java.util.Objects;

public class ProductoCorregido {
    private String codigo;
    private String nombre;
    private double precio;

    public ProductoCorregido(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoCorregido that = (ProductoCorregido) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        // Contrato corregido: usa el mismo atributo que equals()
        return Objects.hash(codigo);
    }
}