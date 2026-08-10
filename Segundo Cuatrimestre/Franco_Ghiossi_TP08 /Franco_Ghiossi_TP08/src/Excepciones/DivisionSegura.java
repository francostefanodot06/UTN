/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

import java.util.Scanner;

/**
 *
 * @author franker
 */
public class DivisionSegura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese el dividendo: ");
            int num1 = scanner.nextInt();
            System.out.print("Ingrese el divisor: ");
            int num2 = scanner.nextInt();

            int resultado = num1 / num2;
            System.out.println("Resultado de la división: " + resultado);
        } catch (ArithmeticException e) {
            System.err.println("❌ Error: No se puede dividir por cero.");
        } finally {
            scanner.close();
        }
    }
}
