/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] suffrage) {
        Titular t = new Titular("Franco Ghiossi", "45678912");
        Pasaporte p = new Pasaporte("ARG12345", "21/05/2026", "rostro.jpg", "PNG", t);
        
        p.mostrarInfo();
    }
}
