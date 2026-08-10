/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio11;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        Artista artista = new Artista("Linkin Park", "Rock/Alternative");
        Cancion cancion = new Cancion("In the End", artista);
        Reproductor mp3 = new Reproductor();

        mp3.reproducir(cancion); // Pasa por parámetro [cite: 172]
    }
}
