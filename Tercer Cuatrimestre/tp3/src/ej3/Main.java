package ej3;

import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebaJPAPU3");
        try {
            parteA(emf);
            System.out.println();
            parteB(emf);
        } finally {
            emf.close();
        }
    }

    // ── PARTE A: sin helper ───────────────────────────────────────────
    private static void parteA(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Curso javaBasico = new Curso("Java Básico");
            em.persist(javaBasico);

            Persona lucia = new Persona("Lucía");
            lucia.getCursos().add(javaBasico);   // solo el lado propietario
            // javaBasico.getInscriptos() NO se actualiza
            em.persist(lucia);

            em.getTransaction().commit();

            System.out.println("=== PARTE A (sin helper) ===");
            System.out.println("Cursos de Lucía: " + lucia.getCursos().size());
            System.out.println("Inscriptos en Java Básico: " + javaBasico.getInscriptos().size());

            /*
             * COMENTARIO OBLIGATORIO - Parte A
             *
             * inscriptos aparece vacío (0) porque solo modifiqué el lado propietario
             * (lucia.getCursos().add(...)). JPA guarda en la base lo que dice el propietario,
             * por eso la fila en la tabla intermedia sí se insertó al hacer commit. Pero JPA
             * no recorre el objeto Curso para llenarle la colección inscriptos: ese objeto
             * sigue siendo el mismo de memoria y nadie lo tocó, así que sigue vacío.
             *
             * Si abro un EntityManager nuevo y hago find(Curso.class, id), Hibernate carga el
             * curso desde la base de datos y ahí inscriptos se llena con Lucía, porque la
             * lectura se arma a partir de la tabla intermedia.
             *
             * El problema que puede causar: dentro de la misma transacción, cualquier lógica
             * que use curso.getInscriptos() (por ejemplo, "si el curso no tiene inscriptos
             * lo puedo dar de baja" o "contar cupos disponibles") tomaría decisiones
             * equivocadas aunque la base ya tenga la relación.
             *
             * La base contiene la relación aunque el objeto Curso no la refleje porque la
             * base y los objetos en memoria son dos cosas distintas: la BD se actualiza
             * desde el lado propietario, mientras que el objeto en memoria solo cambia si
             * mi código lo cambia.
             */
        } finally {
            em.close();
        }
    }

    // ── PARTE B: con helper ───────────────────────────────────────────
    private static void parteB(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Curso javaBasico = new Curso("Java Básico");
            em.persist(javaBasico);

            Persona lucia = new Persona("Lucía");
            lucia.agregarCurso(javaBasico);      // ambos lados actualizados
            em.persist(lucia);

            em.getTransaction().commit();

            System.out.println("=== PARTE B (con helper) ===");
            System.out.println("Cursos de Lucía: " + lucia.getCursos().size());
            System.out.println("Inscriptos en Java Básico: " + javaBasico.getInscriptos().size());

            /*
             * COMENTARIO OBLIGATORIO - Parte B
             *
             * agregarCurso() hace dos cosas: agrega el curso a la colección del propietario
             * (cursos.add(curso)) y además agrega la persona a la colección del inverso
             * (curso.getInscriptos().add(this)). La asignación directa solo hacía lo
             * primero. Por eso ahora inscriptos da 1.
             *
             * JPA no sincroniza solo el lado inverso porque no es un sistema que mantenga
             * los objetos Java conectados entre sí: solo mira el lado propietario para
             * decidir qué SQL ejecutar. El lado inverso (mappedBy) es solo de lectura/
             * navegación y le corresponde al programador mantenerlo coherente en memoria.
             *
             * La distinción importa cuando, en la misma transacción/sesión, uso la colección
             * inversa después de modificar la relación (validaciones, conteos, mostrar
             * resultados). No importa tanto si cada operación se hace en un EntityManager
             * y transacción distintos, porque al releer desde la BD ambos lados vienen bien.
             *
             * Podría generar errores, por ejemplo, en un sistema de inscripciones a cursos
             * con cupo máximo: si valido el cupo con curso.getInscriptos().size() y esa
             * colección está desactualizada, dejaría inscribir más personas de las
             * permitidas o mostraría listados incompletos.
             */
        } finally {
            em.close();
        }
    }
}
