/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio7;

/**
 *
 * @author franker
 */
public class Vehiculo {
    private String patente;
    private String modelo;
    private Motor motor;             // Agregación
    private Conductor conductor;     // Bidireccional

    public Vehiculo(String patente, String modelo, Motor motor, Conductor conductor) {
        this.patente = patente;
        this.modelo = modelo;
        this.motor = motor;
        this.conductor = conductor;
        this.conductor.setVehiculo(this);
    }

    public void mostrarFicha() {
        System.out.println("Vehículo Patente: " + patente + " | Modelo: " + modelo);
        System.out.println(" -> " + motor);
        System.out.println(" -> " + conductor);
    }
}
