/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_03;

/**
 *
 * @author franker
 */
public class Alumno {private String nombre;
    private double promedio;
    private static double notaAprobacion = 6;

    public Alumno(String nombre, double promedio) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.nombre = nombre;
        setPromedio(promedio);
    }

    public Alumno(String nombre) {
        this(nombre, 0);
    }

    public void actualizarPromedio(double nuevo) {
        setPromedio(nuevo);
    }

    public void actualizarPromedio(double[] notas) {
        if (notas == null || notas.length == 0) return;

        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        setPromedio(suma / notas.length);
    }

    public boolean aprobo() {
        return promedio >= notaAprobacion;
    }

    public static void cambiarNotaAprobacion(double nueva) {
        if (nueva >= 0 && nueva <= 10) {
            notaAprobacion = nueva;
        }
    }

    public void setPromedio(double promedio) {
        if (promedio < 0) this.promedio = 0;
        else if (promedio > 10) this.promedio = 10;
        else this.promedio = promedio;
    }

    @Override
    public String toString() {
        return nombre + " - Promedio: " + promedio + " - " + (aprobo() ? "Aprueba" : "No aprueba");
    }
    
}
