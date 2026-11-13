package ej2;

import jakarta.persistence.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("pruebaJPAPU_ej2");

        Long luciaId;

        // ── PARTE 1: crear los datos ──────────────────────────
        System.out.println("===== PARTE 1: crear datos =====");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Curso javaBasico = new Curso("Java Básico");
            Curso baseDatos = new Curso("Base de Datos");
            Curso prog3 = new Curso("Programación III");

            Persona lucia = new Persona("Lucía");
            lucia.agregarCurso(javaBasico);
            lucia.agregarCurso(baseDatos);

            Persona marcos = new Persona("Marcos");
            marcos.agregarCurso(javaBasico);
            marcos.agregarCurso(prog3);

            Persona carolina = new Persona("Carolina");
            carolina.agregarCurso(javaBasico);
            carolina.agregarCurso(baseDatos);
            carolina.agregarCurso(prog3);

            // Solo persisto las personas: los cursos se guardan por cascade=PERSIST
            em.persist(lucia);
            em.persist(marcos);
            em.persist(carolina);

            em.getTransaction().commit();
            luciaId = lucia.getId();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close(); // contexto vacío para las próximas partes
        }

        // ── PARTE 2: FetchType.LAZY ───────────────────────────
        System.out.println("\n===== PARTE 2: LAZY =====");
        EntityManager em2 = emf.createEntityManager();
        try {
            System.out.println("-- Al hacer em.find(Persona.class, id):");
            Persona persona = em2.find(Persona.class, luciaId);
            System.out.println(">> Persona cargada: " + persona.getNombre());

            System.out.println("-- Al acceder a persona.getCursos():");
            System.out.println(">> Cursos de " + persona.getNombre() + ":");
            for (Curso c : persona.getCursos()) {
                System.out.println("   - " + c.getNombre());
            }
        } finally {
            em2.close();
        }

        // ── PARTE 3: N+1 con EAGER ────────────────────────────
        System.out.println("\n===== PARTE 3: EAGER y problema N+1 =====");
        EntityManager em3 = emf.createEntityManager();
        try {
            System.out.println("-- Ejecutando SELECT p FROM PersonaEager p (contá las consultas):");
            List<PersonaEager> personas =
                    em3.createQuery("SELECT p FROM PersonaEager p", PersonaEager.class)
                            .getResultList();
            System.out.println(">> Personas recuperadas: " + personas.size());
            for (PersonaEager p : personas) {
                System.out.println("   " + p.getNombre() + " → " + p.getCursos().size() + " cursos");
            }
            System.out.println("Total de consultas esperado: 1 + " + personas.size()
                    + " = " + (1 + personas.size()) + " (problema N+1)");
        } finally {
            em3.close();
            emf.close();
        }

        /*
         * COMENTARIO OBLIGATORIO
         *
         * Problema N+1:
         * Al listar N entidades con una colección EAGER, Hibernate hace 1 consulta
         * para traer las entidades y N consultas más, una por cada colección. Con 100
         * personas serían 101 consultas en vez de 1. El código funciona, pero es lento.
         *
         * Default de @ManyToMany:
         * LAZY. Tiene sentido porque las colecciones pueden ser grandes y no siempre
         * se usan: cargarlas solo cuando se acceden evita consultas y memoria
         * innecesarias.
         *
         * LAZY con el EntityManager cerrado:
         * La colección es un proxy sin inicializar y Hibernate no tiene sesión para
         * consultarla. Lanza LazyInitializationException ("failed to lazily initialize
         * a collection, no session"). Se evita accediendo a la colección antes del
         * cierre o usando JOIN FETCH en la consulta.
         *
         * Cuándo conviene EAGER:
         * En relaciones chicas que siempre se usan junto con la entidad (por ejemplo
         * una persona y su único domicilio), o cuando se necesita el dato fuera del
         * contexto y se sabe que son pocos registros.
         *
         * Por qué PersonaEager:
         * Para poder ver LAZY (Persona) y EAGER (PersonaEager) en una sola ejecución,
         * sin cambiar la anotación de Persona entre partes ni correr el programa dos
         * veces.
         */
    }
}
