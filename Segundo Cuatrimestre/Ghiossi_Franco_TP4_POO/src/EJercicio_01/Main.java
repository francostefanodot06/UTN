/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJercicio_01;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {

        Empleado e1 = new Empleado("Juan", "Dev");
        Empleado e2 = new Empleado("Ana", "QA");

        e1.actualizarSalario(0.10);
        e2.actualizarSalario(5000);

        e1.actualizarSalario(-1);
        e2.actualizarSalario(-200);

        System.out.println(e1);
        System.out.println(e2);

        System.out.println("Total empleados: " + Empleado.mostrarTotalEmpleados());
    }
}
