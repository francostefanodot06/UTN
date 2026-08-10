/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        Titular t = new Titular("Franco Stefano Ghiossi", "42999000");
        CuentaBancaria cuenta = new CuentaBancaria("0140000012345678901234", 150000.50, "1234", "21/05/2026", t);

        cuenta.verificarEstado();
    }
}
