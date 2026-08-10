/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio9;

/**
 *
 * @author franker
 */
public class Main {
    public static void main(String[] args) {
        Paciente pac = new Paciente("Esteban Quito", "OSDE 310");
        Profesional prof = new Profesional("Marta Sánchez", "Cardiología");
        CitaMedica cita = new CitaMedica("22/05/2026", "09:15", pac, prof);

        cita.mostrarTurno();
    }
}
