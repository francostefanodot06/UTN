/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJercicio_02;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {

        Libro l1 = new Libro("1984", "Orwell");
        Libro l2 = new Libro("It", "Stephen King", "Planeta");

        l1.actualizarTitulo("Nuevo titulo");
        l2.actualizarTitulo("Edición", "Especial");

        l1.actualizarTitulo("");

        System.out.println(l1);
        System.out.println(l2);

        Libro.cambiarEditorial("Sudamericana");

        System.out.println("Después del cambio:");
        System.out.println(l1);
        System.out.println(l2);
    }
}
