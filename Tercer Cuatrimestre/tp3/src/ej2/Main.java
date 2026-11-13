package ej2;

import jakarta.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebaJPAPU2");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Curso java = new Curso("Java Básico");
            Curso bd = new Curso("Base de Datos");
            Curso prog3 = new Curso("Programación III");
            em.persist(java);
            em.persist(bd);
            em.persist(prog3);

            Persona lucia = new Persona("Lucía");
            lucia.agregarCurso(java);
            lucia.agregarCurso(bd);

            Persona marcos = new Persona("Marcos");
            marcos.agregarCurso(java);
            marcos.agregarCurso(prog3);

            Persona carolina = new Persona("Carolina");
            carolina.agregarCurso(java);
            carolina.agregarCurso(bd);
            carolina.agregarCurso(prog3);

            em.persist(lucia);
            em.persist(marcos);
            em.persist(carolina);

            em.getTransaction().commit();

            // Se usa un EntityManager nuevo para leer todo desde la base de datos
            EntityManager em2 = emf.createEntityManager();
            try {
                System.out.println("Personas y sus cursos:");
                for (Long id : Arrays.asList(lucia.getId(), marcos.getId(), carolina.getId())) {
                    Persona p = em2.find(Persona.class, id);
                    String cursos = p.getCursos().stream()
                            .map(Curso::getNombre)
                            .sorted(ORDEN_CURSOS)
                            .collect(Collectors.joining(", "));
                    System.out.println("  " + p.getNombre() + " → " + cursos);
                }

                System.out.println("Cursos y sus inscriptos:");
                for (Long id : Arrays.asList(java.getId(), bd.getId(), prog3.getId())) {
                    Curso c = em2.find(Curso.class, id);
                    String inscriptos = c.getInscriptos().stream()
                            .map(Persona::getNombre)
                            .sorted(ORDEN_PERSONAS)
                            .collect(Collectors.joining(", "));
                    System.out.println("  " + c.getNombre() + " → " + inscriptos);
                }
            } finally {
                em2.close();
            }

            /*
             * COMENTARIO OBLIGATORIO - Ejercicio 2
             *
             * Verificación en H2: existe una única tabla intermedia PERSONA_CURSO con las
             * columnas PERSONA_ID y CURSO_ID. No existe CURSO_PERSONAS ni otra tabla
             * intermedia duplicada. Al hacer SELECT * FROM PERSONA_CURSO se ven 7 filas
             * (pares de IDs): Lucía-2 cursos, Marcos-2 cursos y Carolina-3 cursos.
             *
             * Por qué una tabla intermedia: en una relación N:M una persona tiene muchos
             * cursos y un curso tiene muchas personas. Si pusiera una FK en PERSONAS, cada
             * persona podría guardar un solo curso; si la pusiera en CURSOS, cada curso
             * tendría un solo inscripto. Ninguna de las dos tablas puede guardar todas las
             * relaciones en una sola columna sin romper la forma normal (habría que repetir
             * filas o guardar listas en una celda). Por eso se usa una tabla aparte cuya
             * única función es guardar pares (persona_id, curso_id), una fila por cada
             * vínculo. No es una entidad Java, es solo infraestructura del mapeo.
             *
             * Lado propietario: es Persona, se identifica porque tiene @JoinTable. Sus
             * cambios (persona.cursos) son los que JPA escribe en PERSONA_CURSO. Curso es
             * el lado inverso porque tiene mappedBy = "cursos".
             *
             * Si me olvidara el mappedBy en Curso: Hibernate vería dos @ManyToMany
             * independientes y crearía dos tablas intermedias (PERSONA_CURSO y otra como
             * CURSOS_PERSONAS), cada una administrada por un lado, con datos duplicados e
             * inconsistentes entre sí.
             *
             * Si en agregarCurso() solo hiciera cursos.add(curso): la BD se guardaría bien
             * (porque es el lado propietario), pero curso.getInscriptos() quedaría vacío
             * en memoria dentro de la misma sesión, o sea el modelo de objetos quedaría
             * inconsistente hasta volver a leer desde la base con un EntityManager nuevo.
             */
        } finally {
            em.close();
            emf.close();
        }
    }

    private static final List<String> ORDEN_C = Arrays.asList("Java Básico", "Base de Datos", "Programación III");
    private static final List<String> ORDEN_P = Arrays.asList("Lucía", "Marcos", "Carolina");
    private static final Comparator<String> ORDEN_CURSOS = Comparator.comparingInt(ORDEN_C::indexOf);
    private static final Comparator<String> ORDEN_PERSONAS = Comparator.comparingInt(ORDEN_P::indexOf);
}
