/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio7;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        Motor motorV8 = new Motor("V8 4.0L", "ENG-9923");
        Conductor conductor = new Conductor("Carlos Saínz", "A1-22344");
        Vehiculo auto = new Vehiculo("AF-123-JK", "Ford Mustang", motorV8, conductor);

        auto.mostrarFicha();
    }
}
