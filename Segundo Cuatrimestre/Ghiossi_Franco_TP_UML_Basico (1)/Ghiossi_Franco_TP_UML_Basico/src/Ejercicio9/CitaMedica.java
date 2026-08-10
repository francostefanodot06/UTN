/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio9;

/**
 *
 * @author franker
 */
public class CitaMedica {
    private String fecha;
    private String hora;
    private Paciente paciente;       // Unidireccional
    private Profesional profesional; // Unidireccional

    public CitaMedica(String fecha, String hora, Paciente paciente, Profesional profesional) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.profesional = profesional;
    }

    public void mostrarTurno() {
        System.out.println("Cita Médica del " + fecha + " a las " + hora + "hs:");
        System.out.println(" -> " + paciente);
        System.out.println(" -> " + profesional);
    }
}
