package ej3.parteB;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Ana López", "12345678");
        Factura factura = new Factura(1, 15000.0);

        cliente.setFactura(factura);
        factura.setCliente(cliente);

        // Impresiones por separado con el ciclo roto
        System.out.println(cliente);
        System.out.println(factura);
    }
}