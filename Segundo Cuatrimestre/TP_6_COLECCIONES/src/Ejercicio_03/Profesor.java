/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_03;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franker
 */
public class Profesor {
    private String id;
    private String nombre;
    private String specialty; 
    private List<Curso> cursos;

    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.specialty = especialidad;
        this.cursos = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<Curso> getCursos() { return cursos; }

    public void agregarCurso(Curso c) {
        if (!cursos.contains(c)) {
            cursos.add(c);
            c.setProfesor(this); 
        }
    }

    public void eliminarCurso(Curso c) {
        if (cursos.contains(c)) {
            cursos.remove(c);
            c.desvincularProfesor(); 
        }
    }
    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("   (No dicta ningún curso actualmente)");
            return;
        }
        for (Curso c : cursos) {
            System.out.println("   - Código: " + c.getCodigo() + " | Nombre: " + c.getNombre());
        }
    }

    public void mostrarInfo() {
        System.out.println("Profesor: ID=" + id + " | Nombre=" + nombre + " | Especialidad=" + specialty + " | Cursos dictados: " + cursos.size());
    }
}
