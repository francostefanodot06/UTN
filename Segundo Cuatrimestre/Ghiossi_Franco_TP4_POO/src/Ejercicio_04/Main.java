/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_04;

/**
 *
 * @author franker
 */
public class Main {
     public static void main(String[] args) {

        Producto p1 = new Producto("Mouse", 2000);
        Producto p2 = new Producto("Teclado");

        p1.aplicarDescuento(0.10);
        p2.aplicarDescuento(0.50, 80);

        try {
            Producto p3 = new Producto("", -100);
        } catch (Exception e) {
            System.out.println("Error controlado");
        }

        System.out.println(p1);
        System.out.println(p2);

        Producto.cambiarIVA(0.30);

        System.out.println("Con nuevo IVA:");
        System.out.println(p1);
        System.out.println(p2);
    }
}
