/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJercicio_01;

/**
 *
 * @author franker
 */
public class Empleado {
    private final int id;
    private String nombre;
    private String puesto;
    private double salario;

    private static int totalEmpleados = 0;
    private static int ultimoId = 0;

    public Empleado(int id, String nombre, String puesto, double salario) {
        if (id <= 0) throw new IllegalArgumentException("ID inválido");
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre inválido");
        if (puesto == null || puesto.isEmpty()) throw new IllegalArgumentException("Puesto inválido");
        if (salario < 0) throw new IllegalArgumentException("Salario inválido");

        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;

        totalEmpleados++;
    }

    public Empleado(String nombre, String puesto) {
        this(++ultimoId, nombre, puesto, 50000);
    }

    public void actualizarSalario(double porcentaje) {
        if (porcentaje < 0) return;
        salario += salario * porcentaje;
    }

    public void actualizarSalario(int aumento) {
        if (aumento < 0) return;
        salario += aumento;
    }

    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Puesto: " + puesto + ", Salario: $" + salario;
    }
}
