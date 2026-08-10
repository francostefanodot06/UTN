/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_03;

/**
 *UTN Tecnicatura Universitaria en Programación
 * Trabajo Practico 6: Colecciones
 * Franco Stefano Ghiossi Hrebin
 * @author franker
 */
public class MainEjercicio3 {
    public static void main(String[] args) {
        Universidad utn = new Universidad("UTN FRGP");

        Profesor p1 = new Profesor("Prof01", "Dr. Alan Turing", "Sistemas");
        Profesor p2 = new Profesor("Prof02", "Lic. Ada Lovelace", "Programación");
        Profesor p3 = new Profesor("Prof03", "Ing. Grace Hopper", "Compiladores");

        Curso c1 = new Curso("C-PROG1", "Programación I");
        Curso c2 = new Curso("C-PROG2", "Programación II");
        Curso c3 = new Curso("C-BD", "Bases de Datos");
        Curso c4 = new Curso("C-SO", "Sistemas Operativos");
        Curso c5 = new Curso("C-MAT", "Matemática Discreta");


        utn.agregarProfesor(p1);
        utn.agregarProfesor(p2);
        utn.agregarProfesor(p3);

        utn.agregarCurso(c1);
        utn.agregarCurso(c2);
        utn.agregarCurso(c3);
        utn.agregarCurso(c4);
        utn.agregarCurso(c5);

    
        utn.asignarProfesorACurso("C-PROG1", "Prof02"); 
        utn.asignarProfesorACurso("C-PROG2", "Prof02"); 
        utn.asignarProfesorACurso("C-BD", "Prof01");    
        utn.asignarProfesorACurso("C-SO", "Prof01");   

        System.out.println("\n=== 4. LISTADO INICIAL DE CURSOS ===");
        utn.listarCursos();
        System.out.println("\n=== 4. LISTADO INICIAL DE PROFESORES ===");
        utn.listarProfesores();

        System.out.println("\n=== 5. CAMBIO REASIGNACIÓN SEGURO (Mover Programación II a Grace Hopper) ===");
        utn.asignarProfesorACurso("C-PROG2", "Prof03");

        System.out.println("\nVerificación de profesores modificados:");
        utn.buscarProfesorPorId("Prof02").mostrarInfo(); 
        utn.buscarProfesorPorId("Prof02").listarCursos();
        utn.buscarProfesorPorId("Prof03").mostrarInfo(); 
        utn.buscarProfesorPorId("Prof03").listarCursos();

        
        System.out.println("\n=== 6. ELIMINAR CURSO DE BASE DE DATOS (C-BD) ===");
        utn.eliminarCurso("C-BD");
        System.out.println("\nLista actualizada de cursos de Alan Turing (Prof01):");
        utn.buscarProfesorPorId("Prof01").listarCursos(); 

      
        System.out.println("\n=== 7. REMOVER PROFESOR ALAN TURING (Prof01) ===");
        utn.eliminarProfesor("Prof01");
        System.out.println("\nEstado del curso de Sistemas Operativos (C-SO):");
        utn.buscarCursoPorCodigo("C-SO").mostrarInfo(); 

        System.out.println("\n=== 8. REPORTE FINAL DE CARGA HORARIA ===");
        utn.mostrarReporte();
    }
}
