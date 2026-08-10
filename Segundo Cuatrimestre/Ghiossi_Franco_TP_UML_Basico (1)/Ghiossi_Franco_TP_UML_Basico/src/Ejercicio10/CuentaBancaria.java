/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

/**
 *
 * @author franker
 */
public class CuentaBancaria {
    private String cbu;
    private double saldo;
    private ClaveSeguridad clave; // Composición
    private Titular titular;      // Bidireccional

    public CuentaBancaria(String cbu, double saldo, String pinInicial, String fechaPin, Titular titular) {
        this.cbu = cbu;
        this.saldo = saldo;
        this.clave = new ClaveSeguridad(pinInicial, fechaPin); // Composición
        this.titular = titular;
        this.titular.setCuenta(this);
    }

    public void verificarEstado() {
        System.out.println("CBU: " + cbu + " | Saldo: $" + saldo);
        System.out.println(" -> " + titular);
        System.out.println(" -> " + clave);
    }
}
