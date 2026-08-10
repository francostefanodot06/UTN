/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Probando Sistema de E-commerce ===");
        
        Cliente cliente = new Cliente("Franco Ghiossi");
        Pedido pedido = new Pedido(cliente);

        pedido.agregarProducto(new Producto("Teclado Mecánico", 45000));
        pedido.agregarProducto(new Producto("Mouse Gamer", 25000));

        double totalPedido = pedido.calcularTotal();
        System.out.println("Total del pedido calculado: $" + totalPedido);

        // Notificar cambios de estado
        pedido.cambiarEstado("Procesando");

        // Probar medios de pago
        System.out.println("\n--- Procesando Pagos ---");
        TarjetaCredito tarjeta = new TarjetaCredito();
        tarjeta.aplicarDescuento(10); // 10% OFF
        tarjeta.procesarPago(totalPedido);

        PayPal paypal = new PayPal();
        paypal.procesarPago(totalPedido);
        
        pedido.cambiarEstado("Enviado");
    }
}
