/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio13;

/**
 *
 * @author franker
 */
public class GeneradorQR {
    // Dependencia de creación: El método "new" ocurre acá adentro y no se guarda como atributo 
    public void generar(String valor, Usuario usuario) {
        System.out.println("Iniciando proceso de generación de QR...");
        CodigoQR nuevoQR = new CodigoQR(valor, usuario); // Instanciación local (Dependencia de creación) 
        nuevoQR.imprimir();
    }
}
