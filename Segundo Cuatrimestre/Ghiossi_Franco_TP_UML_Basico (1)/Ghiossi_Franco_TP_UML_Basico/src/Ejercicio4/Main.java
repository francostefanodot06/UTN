/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Stefano Hrebin", "39876543");
        Banco banco = new Banco("Banco Nación", "30-50000319-5");
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("4517-8888-1111-2222", "12/30", cliente, banco);

        tarjeta.mostrarInfo();
    }
}
