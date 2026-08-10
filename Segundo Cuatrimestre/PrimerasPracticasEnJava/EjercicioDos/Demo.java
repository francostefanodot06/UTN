/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioDos;

/**
 *
 * @author franker
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("--- Demostración Kata 2 ---");
        
        // Uso de polimorfismo mediante un array de la superclase abstracta
        Figura[] figuras = {
            new Circulo("Círculo A", 3.5),
            new Rectangulo("Rectángulo B", 5.0, 4.0)
        };

        for (Figura f : figuras) {
            System.out.println("Figura: " + f.getNombre() + " | Área: " + String.format("%.2f", f.calcularArea()));
        }
        System.out.println();
    }
}
