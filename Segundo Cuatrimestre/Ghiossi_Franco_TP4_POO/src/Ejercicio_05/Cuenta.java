/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_05;

/**
 *
 * @author franker
 */
public class Cuenta {
     private final int numero;
    private String titular;
    private double saldo;

    private static int ultimoNumero = 100;
    private static int totalCuentas = 0;

    public Cuenta(String titular, double saldoInicial) {
        if (titular == null || titular.isEmpty()) {
            throw new IllegalArgumentException("Titular inválido");
        }

        this.numero = ++ultimoNumero;
        this.titular = titular;
        this.saldo = Math.max(0, saldoInicial);

        totalCuentas++;
    }

    public Cuenta(String titular) {
        this(titular, 0);
    }

    public double consultarSaldo() {
        return saldo;
    }

    public double consultarSaldo(double cotizacionDolar) {
        if (cotizacionDolar <= 0) return 0;
        return saldo / cotizacionDolar;
    }

    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
    }

    public void extraer(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
        }
    }

    public static int mostrarTotalCuentas() {
        return totalCuentas;
    }

    @Override
    public String toString() {
        return "Cuenta " + numero + " - " + titular + " - Saldo: $" + String.format("%.2f", saldo);
    }
}
