/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioTres;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franker
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("--- Demostración Kata 3 ---");
        List<Empleado> listaEmpleados = new ArrayList<>();
        
        listaEmpleados.add(new EmpleadoPlanta("Juan", 120000));
        listaEmpleados.add(new EmpleadoTemporal("Pedro", 40, 2500));

        for (Empleado e : listaEmpleados) {
            System.out.print("Empleado: " + e.getNombre() + " | Sueldo: $" + e.calcularSueldo());
            
            // Comprobación segura de tipo usando instanceof
            if (e instanceof EmpleadoPlanta) {
                System.out.println(" -> Clasificación: Empleado de Planta");
            } else if (e instanceof EmpleadoTemporal) {
                System.out.println(" -> Clasificación: Empleado Temporal");
            }
        }
        System.out.println();
    }
}
