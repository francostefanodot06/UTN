package ej2;

public class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String marca, int anio, int cilindrada) {
        super(marca, anio);
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        // COMENTARIO OBLIGATORIO:
        // super.toString() devuelve la representación textual de la superclase Vehiculo ("Vehiculo[marca=..., anio=...]"),
        // y la subclase Moto le concatena la información de su atributo propio (", Moto[cilindrada=...]").
        return super.toString() + ", Moto[cilindrada=" + cilindrada + "]";
    }
}