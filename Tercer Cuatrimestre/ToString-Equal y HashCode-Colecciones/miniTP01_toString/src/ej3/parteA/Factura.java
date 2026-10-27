package ej3.parteA;

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
        // Un StackOverflowError ocurre cuando se agota el espacio en la pila de llamadas (call stack) de la JVM.
        // En este caso, la referencia circular hace que Cliente.toString() intente imprimir a Factura (llamando a Factura.toString()),
        // y a su vez Factura.toString() intente imprimir a Cliente (llamando a Cliente.toString()).
        // Esto genera un ciclo de llamadas recursivas infinitas hasta desbordar la memoria de la pila.
        return "Factura[numero=" + numero + ", total=" + total + ", cliente=" + cliente + "]";
    }
}