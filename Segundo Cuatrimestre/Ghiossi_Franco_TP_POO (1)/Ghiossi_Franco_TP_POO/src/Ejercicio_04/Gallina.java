/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_04;

/**
 *
 * @author franker
 */
public class Gallina {
    private int id;
    private int edad;
    private int huevos;

    public void setId(int id) {
        if (id >= 0) this.id = id;
    }

    public void setEdad(int edad) {
        if (edad >= 0) this.edad = edad;
        else System.out.println("Edad inválida");
    }

    public void setHuevos(int huevos) {
        if (huevos >= 0) this.huevos = huevos;
    }

    public void ponerHuevo() {
        huevos++;
    }

    public void envejecer() {
        edad++;
    }

    public void mostrarEstado() {
        System.out.println("ID: " + id + " | Edad: " + edad + " | Huevos: " + huevos);
    }
}
