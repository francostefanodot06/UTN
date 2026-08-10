/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        Propietario p = new Propietario("Franco G.", "41222333");
        // Una build potente como te gusta
        Computadora pc = new Computadora("Custom XT", "SN-998877", "ASUS B550M", "B550", p);

        pc.mostrarInfo();
    }
}
