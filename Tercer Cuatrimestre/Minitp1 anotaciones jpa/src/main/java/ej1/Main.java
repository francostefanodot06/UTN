package ej1;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebaJPAPU");
        EntityManager em = emf.createEntityManager();

        try {
            Persona persona = new Persona("Ana López");
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
            
            System.out.println("Persona guardada con ID: " + persona.getId());
            em.clear();
            
            Persona personaRecuperada = em.find(Persona.class, persona.getId());
            System.out.println("Persona encontrada: " + personaRecuperada.getNombre());
            
            /*
             * COMENTARIO OBLIGATORIO:
             * - Un objeto gestionado significa que Hibernate está monitoreando sus cambios en el contexto de persistencia para sincronizarlos con la base de datos al hacer commit.
             * - El atributo id comienza con null porque la responsabilidad de generarlo recae en la base de datos, no en la aplicación en memoria.
             * - El identificador usando IDENTITY se genera y asigna en el momento exacto en que se ejecuta la sentencia INSERT en la base de datos.
             * - Si se modifica el objeto mientras es gestionado, Hibernate detecta los cambios automáticamente (dirty checking) y ejecuta un UPDATE al confirmar la transacción.
             * - Se utiliza em.clear() antes de find() para limpiar la caché de primer nivel, forzando a Hibernate a ejecutar un SELECT real contra la base de datos en lugar de devolver la instancia que ya tenía en memoria.
             */
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
