package ej1;

import jakarta.persistence.*;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("pruebaJPAPU_ej1");

        Long personaId;
        Long domicilioId;

        // ── TRANSACCIÓN 1: cascade en acción ─────────────────
        System.out.println("-- Transacción 1");
        EntityManager em1 = emf.createEntityManager();
        try {
            em1.getTransaction().begin();

            Domicilio d = new Domicilio("Av. Brasil 123", "Buenos Aires");
            Persona p = new Persona("Dori");
            p.setDomicilio(d);

            em1.persist(p); // ← solo persisto la Persona
            // el Domicilio se persiste automáticamente por cascade=PERSIST

            em1.getTransaction().commit();

            personaId = p.getId();
            domicilioId = d.getId(); // guardar para buscar en Tx2

            Persona encontrada = em1.find(Persona.class, personaId);
            System.out.println("Persona guardada: " + encontrada.getNombre()
                    + " (ID: " + encontrada.getId() + ")");
            Domicilio dom = encontrada.getDomicilio();
            System.out.println("Domicilio guardado por cascade: " + dom.getCalle()
                    + ", " + dom.getCiudad() + " (ID: " + dom.getId() + ")");
        } catch (RuntimeException e) {
            if (em1.getTransaction().isActive()) em1.getTransaction().rollback();
            throw e;
        } finally {
            em1.close();
        }

        // ── TRANSACCIÓN 2: orphanRemoval en acción ────────────
        System.out.println("-- Transacción 2");
        EntityManager em2 = emf.createEntityManager();
        try {
            em2.getTransaction().begin();

            Persona persona = em2.find(Persona.class, personaId);
            persona.setDomicilio(null); // rompo la referencia
            em2.merge(persona);

            // El DELETE no se ejecuta en el setter: ocurre al sincronizar (flush) en el commit
            em2.getTransaction().commit();

            Domicilio buscado = em2.find(Domicilio.class, domicilioId);
            System.out.println("Domicilio buscado: " + buscado
                    + (buscado == null ? "  ← eliminado automáticamente por orphanRemoval" : ""));
        } catch (RuntimeException e) {
            if (em2.getTransaction().isActive()) em2.getTransaction().rollback();
            throw e;
        } finally {
            em2.close();
            emf.close();
        }

        /*
         * COMENTARIO OBLIGATORIO
         *
         * REMOVE vs orphanRemoval:
         * CascadeType.REMOVE actúa solo cuando llamo a em.remove(persona): borra la
         * persona y también su domicilio. orphanRemoval = true actúa cuando la persona
         * deja de referenciar al domicilio (por ejemplo setDomicilio(null)): JPA lo
         * borra solo al hacer commit, sin llamar a remove(). Por eso en la Tx2 el
         * domicilio desaparece sin ningún DELETE manual.
         *
         * Peligro de CascadeType.ALL:
         * ALL incluye REMOVE. Si la entidad relacionada es compartida (por ejemplo un
         * Curso con varias Personas), borrar una persona borraría el curso aunque otras
         * personas lo necesiten. Solo se justifica cuando la relacionada es de
         * propiedad exclusiva de la principal, como un Domicilio de una sola Persona.
         *
         * Cascade en el lado propietario:
         * El lado propietario es el que tiene la referencia y el @JoinColumn, o sea la
         * entidad que "posee" a la otra y controla su ciclo de vida. El lado mappedBy
         * solo refleja la relación, por eso poner cascade u orphanRemoval ahí es
         * confuso y, según el enunciado, orphanRemoval no tiene efecto.
         *
         * REMOVE sin orphanRemoval, y viceversa:
         * REMOVE solo: al borrar un Pedido quiero que se borren sus líneas, pero que
         * sacar una línea de la lista no la elimine de la base.
         * orphanRemoval: quitar un ítem de una Factura lo borra de la base
         * automáticamente, porque un ítem sin factura no tiene sentido.
         */
    }
}
