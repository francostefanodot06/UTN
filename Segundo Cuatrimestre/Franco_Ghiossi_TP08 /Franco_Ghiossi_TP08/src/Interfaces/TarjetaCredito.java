/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

/**
 *
 * @author franker
 */
public class TarjetaCredito implements PagoConDescuento {
    private double descuento = 0;

    @Override
    public void aplicarDescuento(double porcentaje) {
        this.descuento = porcentaje;
    }

    @Override
    public void procesarPago(double monto) {
        double total = monto - (monto * (descuento / 100));
        System.out.println("Pago de $" + total + " procesado con Tarjeta de Crédito (Descuento aplicado: " + descuento + "%).");
    }
    
}
