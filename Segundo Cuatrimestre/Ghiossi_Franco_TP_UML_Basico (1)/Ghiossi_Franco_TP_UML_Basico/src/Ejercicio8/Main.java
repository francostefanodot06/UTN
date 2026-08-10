/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        Usuario usr = new Usuario("Franco Ghiossi", "francoghiossi@mail.com");
        Documento doc = new Documento("Contrato de Alquiler", "Texto legal...", "SHA256-XYZ888", "21/05/2026", usr);

        doc.mostrarInfo();
    }
}
