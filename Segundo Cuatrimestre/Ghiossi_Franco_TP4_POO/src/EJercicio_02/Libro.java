/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJercicio_02;

/**
 *
 * @author franker
 */
public class Libro {
    private String titulo;
    private String autor;
    private static String editorial = "Independiente";

    public Libro(String titulo, String autor) {
        setTitulo(titulo);
        setAutor(autor);
    }

    public Libro(String titulo, String autor, String editorial) {
        this(titulo, autor);
        if (editorial != null && !editorial.isEmpty()) {
            Libro.editorial = editorial;
        }
    }

    public void actualizarTitulo(String nuevo) {
        if (nuevo != null && !nuevo.isEmpty()) {
            this.titulo = nuevo;
        }
    }

    public void actualizarTitulo(String prefijo, String nuevo) {
        if (nuevo != null && !nuevo.isEmpty()) {
            this.titulo = prefijo + " " + nuevo;
        }
    }

    public static void cambiarEditorial(String nueva) {
        if (nueva != null && !nueva.isEmpty()) {
            editorial = nueva;
        }
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) return;
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isEmpty()) return;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + editorial + ")";
    }
}
