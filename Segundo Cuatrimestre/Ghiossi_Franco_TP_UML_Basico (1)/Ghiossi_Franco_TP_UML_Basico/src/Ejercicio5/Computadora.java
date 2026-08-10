/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

/**
 *
 * @author franker
 */
public class Computadora {
    private String marca;
    private String numeroSerie;
    private PlacaMadre placaMadre; // Composición
    private Propietario propietario; // Bidireccional

    public Computadora(String marca, String numeroSerie, String modeloPlaca, String chipsetPlaca, Propietario propietario) {
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.placaMadre = new PlacaMadre(modeloPlaca, chipsetPlaca); // Composición
        this.propietario = propietario;
        this.propietario.setComputadora(this);
    }

    public void mostrarInfo() {
        System.out.println("PC Marca: " + marca + " | S/N: " + numeroSerie);
        System.out.println(" -> " + placaMadre);
        System.out.println(" -> " + propietario);
    }
}
