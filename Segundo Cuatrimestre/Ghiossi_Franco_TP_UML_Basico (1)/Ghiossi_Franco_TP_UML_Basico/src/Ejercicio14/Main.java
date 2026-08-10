/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio14;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        Proyecto miVideo = new Proyecto("TP5-Programacion2", 5);
        EditorVideo premiere = new EditorVideo();

        premiere.exportar("mp4", miVideo);
    }
}
