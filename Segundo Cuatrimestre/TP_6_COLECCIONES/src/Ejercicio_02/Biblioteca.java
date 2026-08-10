/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_02;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franker
 */
public class Biblioteca {
    private String nombre;
    private List<Libro> libros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        Libro nuevoLibro = new Libro(isbn, titulo, anioPublicacion, autor);
        libros.add(nuevoLibro);
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("La biblioteca no tiene libros.");
            return;
        }
        for (Libro l : libros) {
            l.mostrarInfo();
        }
    }

    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().replace("-", "").equalsIgnoreCase(isbn.replace("-", ""))) {
                return l;
            }
        }
        return null;
    }

    public boolean eliminarLibro(String isbn) {
        Libro l = buscarLibroPorIsbn(isbn);
        if (l != null) {
            libros.remove(l);
            return true;
        }
        return false;
    }

    public int obtenerCantidadLibros() {
        return libros.size();
    }

    public void filtrarLibrosPorAnio(int anio) {
        System.out.println("--- Libros publicados en el año " + anio + " ---");
        boolean f = false;
        for (Libro l : libros) {
            if (l.getAnioPublicacion() == anio) {
                l.mostrarInfo();
                f = true;
            }
        }
        if (!f) System.out.println("No se encontraron libros de ese año.");
    }

    public void mostrarAutoresDisponibles() {
        System.out.println("--- Autores con libros en esta biblioteca ---");
        List<String> idsCargados = new ArrayList<>();
        for (Libro l : libros) {
            Autor a = l.getAutor();
            if (!idsCargados.contains(a.getId())) {
                System.out.println("- " + a.getNombre() + " (" + a.getNacionalidad() + ")");
                idsCargados.add(a.getId());
            }
        }
    }
}
