package ej3.parteA;

import java.util.Objects;

public class ProductoRoto {
    private String codigo;
    private String nombre;
    private double precio;

    public ProductoRoto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoRoto that = (ProductoRoto) o;
        return Objects.equals(codigo, that.codigo);
    }

    // hashCode() NO se sobrescribe: hereda el de Object (basado en la dirección de memoria)[cite: 22]
}