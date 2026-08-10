/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_02;

/**
 *UTN Tecnicatura Universitaria en Programación
 * Trabajo Practico 6: Colecciones
 * Franco Stefano Ghiossi Hrebin
 * @author franker
 */
public class MainEjercicio2 {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central UTN");

        Autor a1 = new Autor("A01", "Gabriel García Márquez", "Colombiana");
        Autor a2 = new Autor("A02", "Jorge Luis Borges", "Argentina");
        Autor a3 = new Autor("A03", "Julio Cortázar", "Argentina");

        biblioteca.agregarLibro("978-1", "Cien años de soledad", 1967, a1);
        biblioteca.agregarLibro("978-2", "El Aleph", 1949, a2);
        biblioteca.agregarLibro("978-3", "Rayuela", 1963, a3);
        biblioteca.agregarLibro("978-4", "Ficciones", 1944, a2);
        biblioteca.agregarLibro("978-5", "El amor en los tiempos del cólera", 1985, a1);

        System.out.println("\n--- 4. LISTADO COMPLETO DE LIBROS ---");
        biblioteca.listarLibros();

        System.out.println("\n--- 5. BUSCAR LIBRO POR ISBN (978-3) ---");
        Libro b = biblioteca.buscarLibroPorIsbn("978-3");
        if (b != null) b.mostrarInfo();

        System.out.println("\n--- 6. FILTRAR LIBROS PUBLICADOS EN 1949 ---");
        biblioteca.filtrarLibrosPorAnio(1949);

        System.out.println("\n--- 7. ELIMINAR LIBRO (978-1) ---");
        if (biblioteca.eliminarLibro("978-1")) System.out.println("Libro con ISBN 978-1 eliminado.");
        biblioteca.listarLibros();

        System.out.println("\n--- 8. CANTIDAD TOTAL DE LIBROS ---");
        System.out.println("Total: " + biblioteca.obtenerCantidadLibros() + " libros.");

        System.out.println("\n--- 9. AUTORES DISPONIBLES EN LA BIBLIOTECA ---");
        biblioteca.mostrarAutoresDisponibles();
    }
}
