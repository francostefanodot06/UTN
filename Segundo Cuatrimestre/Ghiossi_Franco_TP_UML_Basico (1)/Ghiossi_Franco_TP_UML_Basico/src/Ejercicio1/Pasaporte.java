/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author franker
 */
public class Pasaporte {
    private String numero;
    private String fechaEmision;
    private Foto foto; // Composición
    private Titular titular; // Bidireccional

    // Pasaporte se encarga de instanciar la Foto (Composición)
    public Pasaporte(String numero, String fechaEmision, String imagenFoto, String formatoFoto, Titular titular) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.foto = new Foto(imagenFoto, formatoFoto); 
        this.titular = titular;
        this.titular.setPasaporte(this); // Setea la relación bidireccional
    }

    public void mostrarInfo() {
        System.out.println("Pasaporte Nro: " + numero + " | Emitido: " + fechaEmision);
        System.out.println(" -> " + titular);
        System.out.println(" -> " + foto);
    }
}
