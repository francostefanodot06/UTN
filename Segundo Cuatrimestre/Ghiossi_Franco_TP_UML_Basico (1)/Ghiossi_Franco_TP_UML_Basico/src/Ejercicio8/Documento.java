/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8;

/**
 *
 * @author franker
 */
public class Documento {
    private String titulo;
    private String contenido;
    private FirmaDigital firma; // Composición

    // Al ser composición, el documento genera la firma digital adentro usando al usuario
    public Documento(String titulo, String contenido, String hash, String fecha, Usuario usuario) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.firma = new FirmaDigital(hash, fecha, usuario);
    }

    public void mostrarInfo() {
        System.out.println("Documento: '" + titulo + "'");
        System.out.println("Contenido: " + contenido);
        System.out.println(" -> Verification: " + firma);
    }
}
