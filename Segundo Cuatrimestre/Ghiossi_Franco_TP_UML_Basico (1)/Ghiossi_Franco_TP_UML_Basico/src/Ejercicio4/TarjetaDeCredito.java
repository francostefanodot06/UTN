/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author franker
 */
public class TarjetaDeCredito {
    private String numero;
    private String fechaVencimiento;
    private Cliente cliente; // Bidireccional
    private Banco banco;     // Agregación

    public TarjetaDeCredito(String numero, String fechaVencimiento, Cliente cliente, Banco banco) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.cliente = cliente;
        this.cliente.setTarjeta(this);
        this.banco = banco;
    }

    public void mostrarInfo() {
        System.out.println("Tarjeta Nro: " + numero + " | Vence: " + fechaVencimiento);
        System.out.println(" -> " + cliente);
        System.out.println(" -> " + banco);
    }
}
