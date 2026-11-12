package ej3b;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebaJPAPU");
        EntityManager em = emf.createEntityManager();

        try {
            Articulo articulo = new Articulo("ART-001", "Monitor curvo 32 pulgadas", 89999.99);
            em.getTransaction().begin();
            em.persist(articulo);
            em.getTransaction().commit();

            System.out.println("Artículo 3B guardado con éxito.");

            /*
             * COMENTARIO OBLIGATORIO - Parte B:
             * - La principal ventaja de definir los nombres con @Table y @Column es que independiza el diseño de la base de datos de la estructura del código Java, asegurando un esquema predecible y estandarizado.
             * - El atributo Java representa el dato en memoria bajo las convenciones del lenguaje (camelCase), mientras que la columna es la representación física en la tabla; no necesitan llamarse igual.
             * - Esto es muy útil al integrar consultas SQL u otras aplicaciones, ya que los administradores de bases de datos pueden trabajar con nombres de tablas y columnas claros e independientes de la aplicación.
             * - La configuración explícita mejora la previsibilidad porque garantiza que el esquema no va a cambiar accidentalmente si se modifica el nombre de una variable en Java o si se migra el proyecto a un proveedor JPA distinto.
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
