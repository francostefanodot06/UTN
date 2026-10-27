package ej3.parteB;

public class Factura {
    private int numero;
    private double total;
    private Cliente cliente;

    public Factura(int numero, double total) {
        this.numero = numero;
        this.total = total;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        // COMENTARIO OBLIGATORIO:
        // Se omitió la referencia al objeto cliente dentro de Factura.toString() para romper el ciclo
        // de llamadas recursivas implícitas. Al no invocar a cliente.toString() desde Factura,
        // se evita la referencia circular y se resuelve el desbordamiento de pila (StackOverflowError),
        // manteniendo la relación bidireccional entre los objetos en memoria.
        return "Factura[numero=" + numero + ", total=" + total + "]";
    }
}