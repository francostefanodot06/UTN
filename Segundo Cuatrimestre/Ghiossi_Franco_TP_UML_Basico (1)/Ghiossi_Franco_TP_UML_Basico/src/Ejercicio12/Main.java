/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio12;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        Contribuyente con = new Contribuyente("Franco H.", "20-42999000-9");
        Impuesto imp = new Impuesto(4500.00, con);
        Calculadora calc = new Calculadora();

        calc.calcular(imp);
    }
}
