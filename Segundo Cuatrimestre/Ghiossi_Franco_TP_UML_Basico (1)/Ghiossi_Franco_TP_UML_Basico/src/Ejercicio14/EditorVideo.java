/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio14;

/**
 *
 * @author franker
 */
public class EditorVideo {
    // Dependencia de creación 
    public void exportar(String formato, Proyecto proyecto) {
        System.out.println("Abriendo codecs multimedia...");
        Render procesoRender = new Render(formato, proyecto); // Dependencia de creación 
        procesoRender.ejecutar();
    }
}
