/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_02;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {

        Mascota m = new Mascota();

        m.setEdad(-5);

        m.setNombre("Firulais");
        m.setEspecie("Perro");
        m.setEdad(3);

        m.mostrarInfo();

        m.cumplirAnios();
        m.cumplirAnios();

        m.mostrarInfo();
    }
}
