/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio11;

/**
 *
 * @author franker
 */
public class Reproductor {
    // Dependencia de uso: No guarda la canción como atributo, solo la procesa en este método 
    public void reproducir(Cancion cancion) {
        System.out.println("Reproduciendo ahora: '" + cancion.getTitulo() + "' de " + cancion.getArtista());
    }
}
