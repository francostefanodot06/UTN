/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJercicio2;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        Bateria bat = new Bateria("Li-Polymer X", 5000);
        Usuario usr = new Usuario("Franco Stefano", "42345678");
        Celular cel = new Celular("861234567", "Motorola", "Edge 40", bat, usr);

        cel.mostrarInfo();
    }
}
