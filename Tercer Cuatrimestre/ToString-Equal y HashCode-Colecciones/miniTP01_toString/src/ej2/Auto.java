package ej2;

public class Auto extends Vehiculo {
    private int cantPuertas;

    public Auto(String marca, int anio, int cantPuertas) {
        super(marca, anio);
        this.cantPuertas = cantPuertas;
    }

    @Override
    public String toString() {
        // COMENTARIO OBLIGATORIO:
        // super.toString() devuelve la representación textual de la superclase Vehiculo ("Vehiculo[marca=..., anio=...]"),
        // y luego la subclase Auto agrega a esa cadena su atributo propio (", Auto[cantPuertas=...]").
        return super.toString() + ", Auto[cantPuertas=" + cantPuertas + "]";
    }
}