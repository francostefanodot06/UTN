/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_03;

/**
 *
 * @author franker
 */
public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = null; 
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }

    public void setProfesor(Profesor nuevoProfesor) {
    
        if (this.profesor == nuevoProfesor) {
            return;
        }

        Profesor profesorViejo = this.profesor;
        this.profesor = nuevoProfesor;

    
        if (profesorViejo != null) {
            profesorViejo.eliminarCurso(this);
        }

    
        if (nuevoProfesor != null) {
            nuevoProfesor.agregarCurso(this);
        }
    }

    public void desvincularProfesor() {
        this.profesor = null;
    }

    public void mostrarInfo() {
        String profeNombre = (profesor != null) ? profesor.getNombre() : "Sin profesor asignado";
        System.out.println("Curso: [" + codigo + "] " + nombre + " | Profesor Responsable: " + profeNombre);
    }
}
