/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_03;
import java.time.Year;
/**
 *
 * @author franker
 */
public class Libro {
    private String titulo;
    private String autor;
    private int anio;

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            this.titulo = titulo;
        }
    }

    public void setAutor(String autor) {
        if (autor != null && !autor.isEmpty()) {
            this.autor = autor;
        }
    }

    public void setAnio(int anio) {
        int actual = Year.now().getValue();

        if (anio > 0 && anio <= actual) {
            this.anio = anio;
        } else {
            System.out.println("Año inválido");
        }
    }

    public void mostrarInfo() {
        System.out.println(titulo + " | " + autor + " | " + anio);
    }
}
