/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_05;

/**
 *
 * @author franker
 */
public class NaveEspacial {
   
    private String nombre;
    private int combustible;
    private final int MAX = 100;

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }
    public void setCombustible(int combustible) {
        if (combustible >= 0 && combustible <= MAX) {
            this.combustible = combustible;
        }
    }
    public void despegar() {
        if (combustible >= 5) {
            combustible -= 5;
            System.out.println("Despegó");
        } else {
            System.out.println("Sin combustible");
        }
    }
    public void avanzar(int distancia) {
        int consumo = distancia * 2;

        if (combustible >= consumo) {
            combustible -= consumo;
            System.out.println("Avanzó " + distancia);
        } else {
            System.out.println("No alcanza el combustible");
        }
    }
    public void recargar(int cantidad) {
        if (combustible + cantidad <= MAX) {
            combustible += cantidad;
        } else {
            System.out.println("Excede capacidad");
        }
    }
    public void mostrarEstado() {
        System.out.println(nombre + " | Combustible: " + combustible);
    }
}
