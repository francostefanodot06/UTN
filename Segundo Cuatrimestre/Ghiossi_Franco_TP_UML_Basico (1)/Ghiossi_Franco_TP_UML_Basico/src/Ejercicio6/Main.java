/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        Cliente c = new Cliente("Laura Gómez", "11-3456-7890");
        Mesa m = new Mesa(5, 4);
        Reserva r = new Reserva("25/05/2026", "21:30", c, m);

        r.mostrarReserva();
    }
}
