/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_05;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {

        Cuenta c1 = new Cuenta("Pedro", 5000);
        Cuenta c2 = new Cuenta("Lucia");

        c1.depositar(2000);
        c1.extraer(1000);
        c1.extraer(10000);

        System.out.println(c1);
        System.out.println(c2);

        System.out.println("Saldo en USD: " + c1.consultarSaldo(1300));

        System.out.println("Total cuentas: " + Cuenta.mostrarTotalCuentas());
    }
}
