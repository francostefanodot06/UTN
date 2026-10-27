package ej2;

public class Vehiculo {
    private String marca;
    private int anio;

    public Vehiculo(String marca, int anio) {
        this.marca = marca;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Vehiculo[marca=" + marca + ", anio=" + anio + "]";
    }
}