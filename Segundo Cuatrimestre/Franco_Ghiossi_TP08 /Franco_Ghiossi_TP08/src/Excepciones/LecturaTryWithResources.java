/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author franker
 */
public class LecturaTryWithResources {
    public static void main(String[] args) {
  
        String rutaArchivo = "prueba.txt"; 

        // try-with-resources cierra automáticamente el BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            System.out.println("--- Contenido del archivo ---");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("❌ Error de E/S al intentar leer el archivo: " + e.getMessage());
        }
    }
}
