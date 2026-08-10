/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioCuatro;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franker
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("--- Demostración Kata 4 ---");
        List<Animal> animales = new ArrayList<>();
        
        animales.add(new Perro("Firulais"));
        animales.add(new Gato("Michi"));
        animales.add(new Vaca("Lola"));

        animales.forEach(animal -> {
            animal.describirAnimal();
        });
        System.out.println();
    }
}
