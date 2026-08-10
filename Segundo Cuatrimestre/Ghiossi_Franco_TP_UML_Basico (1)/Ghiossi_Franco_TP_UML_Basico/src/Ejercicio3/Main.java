/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        Autor autor = new Autor("Jorge Luis Borges", "Argentina");
        Editorial editorial = new Editorial("Sudamericana", "Humberto Primo 555");
        Libro libro = new Libro("El Aleph", "9789500710121", autor, editorial);

        libro.mostrarInfo();
    }
}
