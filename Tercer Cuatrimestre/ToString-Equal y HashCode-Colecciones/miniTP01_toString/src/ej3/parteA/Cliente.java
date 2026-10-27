package ej3.parteA;

public class Cliente {
    private String nombre;
    private String dni;
    private Factura factura;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "Cliente[nombre=" + nombre + ", dni=" + dni + ", factura=" + factura + "]";
    }
}