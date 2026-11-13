package ej3;

import jakarta.persistence.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("pruebaJPAPU_ej3");
        EntityManager em = emf.createEntityManager();
        try {
            // ── Persistir datos ───────────────────────────────
            em.getTransaction().begin();
            em.persist(new Persona("Homero", "Springfield", 39));
            em.persist(new Persona("Marge", "Springfield", 36));
            em.persist(new Persona("Ned", "Springfield", 40));
            em.persist(new Persona("Burns", "Shelbyville", 104));
            em.getTransaction().commit();

            // ── PARTE A: concatenación peligrosa (solo con fines didácticos) ──
            System.out.println("===== PARTE A: concatenación =====");
            String ciudadFiltro = "Springfield";
            List<Persona> resultado = em.createQuery(
                    "SELECT p FROM Persona p WHERE p.ciudad = '" + ciudadFiltro + "'",
                    Persona.class
            ).getResultList();
            System.out.println("Personas encontradas: " + resultado.size()); // 3

            ciudadFiltro = "' OR '1'='1";
            resultado = em.createQuery(
                    "SELECT p FROM Persona p WHERE p.ciudad = '" + ciudadFiltro + "'",
                    Persona.class
            ).getResultList();
            System.out.println("Personas encontradas: " + resultado.size()
                    + " ← devolvió TODOS los registros, incluyendo Burns"); // 4

            /*
             * COMENTARIO OBLIGATORIO — Parte A
             *
             * Al concatenar, el string queda: WHERE p.ciudad = '' OR '1'='1'
             * La comilla del atacante cierra el literal y agrega una condición OR que
             * siempre es verdadera, así que el filtro deja de filtrar y devuelve las 4
             * personas, incluyendo a Burns.
             * JPA/Hibernate traduce ese JPQL a un SQL equivalente
             * (... where ciudad='' or '1'='1'), porque el texto ya llegó modificado.
             * En una aplicación real, un atacante podría leer datos que no debería ver
             * o alterar la lógica de la consulta.
             */

            // ── PARTE B: parámetros nombrados ─────────────────
            System.out.println("\n===== PARTE B: parámetros nombrados =====");
            ciudadFiltro = "Springfield";
            List<Persona> seguras = em.createQuery(
                    "SELECT p FROM Persona p WHERE p.ciudad = :ciudad ORDER BY p.nombre ASC",
                    Persona.class
            ).setParameter("ciudad", ciudadFiltro)
             .getResultList();

            System.out.println("Personas en " + ciudadFiltro + " (ordenadas por nombre):");
            for (Persona p : seguras) {
                System.out.println(" - " + p.getNombre() + " (" + p.getEdad() + " años)");
            }
            System.out.println("Total: " + seguras.size());

            Long cantidad = em.createQuery(
                    "SELECT COUNT(p) FROM Persona p WHERE p.edad > :edadMin",
                    Long.class
            ).setParameter("edadMin", 39)
             .getSingleResult();
            System.out.println("Personas mayores de 39 años: " + cantidad);

            // Mismo ataque, ahora con parámetro: se trata como texto literal
            ciudadFiltro = "' OR '1'='1";
            List<Persona> ataque = em.createQuery(
                    "SELECT p FROM Persona p WHERE p.ciudad = :ciudad ORDER BY p.nombre ASC",
                    Persona.class
            ).setParameter("ciudad", ciudadFiltro)
             .getResultList();
            System.out.println("Con el valor de ataque y setParameter: " + ataque.size()
                    + " resultados"); // 0

            /*
             * COMENTARIO OBLIGATORIO — Parte B
             *
             * getResultList() vs getSingleResult():
             * getResultList() devuelve una lista con 0 o más resultados y nunca lanza
             * excepción por la cantidad. getSingleResult() exige exactamente un
             * resultado: lanza NoResultException si no hay ninguno y
             * NonUniqueResultException si hay más de uno. Uso el segundo para
             * agregaciones como COUNT y el primero para el resto de las consultas.
             *
             * JPQL vs SQL:
             * En JPQL escribo nombres de clases y atributos Java (Persona, ciudad). En
             * SQL escribo tablas y columnas (PERSONAS, CIUDAD). El proveedor traduce,
             * por eso la misma consulta sirve en H2, MySQL o PostgreSQL.
             *
             * Ventajas de los parámetros nombrados:
             * El valor se trata siempre como dato y no como código (por eso el ataque
             * devuelve 0 resultados); además la consulta queda más legible, se puede
             * reutilizar cambiando solo el valor y es más fácil de mantener.
             */
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
            emf.close();
        }
    }
}
