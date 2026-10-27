package ej3.parteA;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Ana López", "12345678");
        Factura factura = new Factura(1, 15000.0);

        cliente.setFactura(factura);
        factura.setCliente(cliente);

        // Al ejecutar esto, se generará intencionalmente el StackOverflowError
        System.out.println(cliente);
    }
}