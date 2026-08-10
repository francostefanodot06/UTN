/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

/**
 *
 * @author franker
 */
public class Reserva {
    private String fecha;
    private String hora;
    private Cliente cliente; // Unidireccional
    private Mesa mesa;       // Agregación

    public Reserva(String fecha, String hora, Cliente cliente, Mesa mesa) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public void mostrarReserva() {
        System.out.println("Reserva para el día " + fecha + " a las " + hora);
        System.out.println(" -> " + cliente);
        System.out.println(" -> " + mesa);
    }
}
