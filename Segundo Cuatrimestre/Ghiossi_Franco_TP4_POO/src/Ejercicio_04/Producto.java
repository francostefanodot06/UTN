/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_04;

/**
 *
 * @author franker
 */
public class Producto {
    private String nombre;
    private double precioBase;
    private static double IVA = 0.21;

    public Producto(String nombre, double precioBase) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.nombre = nombre;
        setPrecioBase(precioBase);
    }

    public Producto(String nombre) {
        this(nombre, 100);
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje < 0) return;
        precioBase -= precioBase * porcentaje;
    }

    public void aplicarDescuento(double porcentaje, double minimo) {
        if (porcentaje < 0) return;

        double nuevo = precioBase - (precioBase * porcentaje);
        precioBase = Math.max(nuevo, minimo);
    }

    public double calcularPrecioFinal() {
        return precioBase + (precioBase * IVA);
    }

    public static void cambiarIVA(double nuevo) {
        if (nuevo >= 0) IVA = nuevo;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase >= 0) {
            this.precioBase = precioBase;
        }
    }

    @Override
    public String toString() {
        return nombre + " - Base: $" + precioBase + " - Final: $" + calcularPrecioFinal();
    }
}
