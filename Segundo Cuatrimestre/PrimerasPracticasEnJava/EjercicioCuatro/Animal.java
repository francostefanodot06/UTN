/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioCuatro;

/**
 *
 * @author franker
 */
public class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void hacerSonido() {
        System.out.println("Sonido genérico de animal.");
    }

    public void describirAnimal() {
        System.out.print("Este es un animal llamado " + nombre + " y hace: ");
        hacerSonido(); // Llamada dinámica resuelta en tiempo de ejecución
    }
}
