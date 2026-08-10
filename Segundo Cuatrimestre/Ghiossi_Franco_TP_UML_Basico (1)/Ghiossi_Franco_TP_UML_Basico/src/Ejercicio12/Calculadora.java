/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio12;

/**
 *
 * @author franker
 */
public class Calculadora {
    // Dependencia de uso 
    public void calcular(Impuesto impuesto) {
        double totalConInteres = impuesto.getMonto() * 1.21; // Agregando IVA simulado
        System.out.println("Calculando impuesto para: " + impuesto.getContribuyente());
        System.out.println("Base: $" + impuesto.getMonto() + " | Total final (+IVA): $" + totalConInteres);
    }
}
