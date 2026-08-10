/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJercicio2;

/**
 *
 * @author franker
 */
public class Celular {
    private String imei;
    private String marca;
    private String modelo;
    private Bateria bateria; // Agregación
    private Usuario usuario; // Bidireccional

    public Celular(String imei, String marca, String modelo, Bateria bateria, Usuario usuario) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = bateria; // Viene de afuera, puede existir sin el celular
        this.usuario = usuario;
        this.usuario.setCelular(this);
    }

    public void mostrarInfo() {
        System.out.println("Celular: " + marca + " " + modelo + " (IMEI: " + imei + ")");
        System.out.println(" -> " + bateria);
        System.out.println(" -> " + usuario);
    }
}
