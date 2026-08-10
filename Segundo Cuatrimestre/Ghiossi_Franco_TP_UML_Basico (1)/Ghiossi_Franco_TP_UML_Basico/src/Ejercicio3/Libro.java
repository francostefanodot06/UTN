/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author franker
 */
public class Libro {
    private String titulo;
    private String isbn;
    private Autor autor;         // Asociación unidireccional
    private Editorial editorial; // Agregación

    public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
    }

    public void mostrarInfo() {
        System.out.println("Libro: " + titulo + " (ISBN: " + isbn + ")");
        System.out.println(" -> Autor: " + autor);
        System.out.println(" -> " + editorial);
    }
}
