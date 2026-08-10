/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_03;

/**
 *
 * @author franker
 */
public class Main {
     public static void main(String[] args) {

        Alumno a1 = new Alumno("Lucas", 7);
        Alumno a2 = new Alumno("Maria");

        a2.actualizarPromedio(new double[]{8, 6, 7});
        a1.actualizarPromedio(11);

        System.out.println(a1);
        System.out.println(a2);

        Alumno.cambiarNotaAprobacion(7);

        System.out.println("Después del cambio:");
        System.out.println(a1);
        System.out.println(a2);
    }
}
