/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_05;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        NaveEspacial n = new NaveEspacial();

        n.setNombre("Apollo");
        n.setCombustible(50);

        n.avanzar(30);
        n.recargar(60);
        n.recargar(30);
        n.despegar();
        n.avanzar(10);
        n.mostrarEstado();
    }
}
