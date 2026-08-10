/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio13;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        Usuario usr = new Usuario("Franco S. Ghiossi", "franco.utn@example.com");
        GeneradorQR engine = new GeneradorQR();

        engine.generar("https://github.com/franco", usr);
    }
}
