/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_01;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {

        Estudiante e = new Estudiante();

        e.setNombre("");
        e.setCalificacion(15);

        e.setNombre("Juan");
        e.setApellido("Perez");
        e.setCurso("Programación II");
        e.setCalificacion(8);

        e.mostrarInfo();

        e.subirCalificacion(3);
        e.bajarCalificacion(10);

        e.mostrarInfo();
    }
    
}
