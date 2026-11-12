package ej3a;
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

            System.out.println("Artículo 3A guardado con éxito.");

            /*
             * COMENTARIO OBLIGATORIO - Parte A:
             * - Al no especificar nombres explícitos, Hibernate utilizó el nombre de la clase (Articulo) para la tabla y los nombres de los atributos (codigoInterno, descripcionLarga, precioVenta) para las columnas.
             * - La relación es directa: asume por defecto la convención lógica del código Java y la traslada a la base de datos dependiendo de su PhysicalNamingStrategy.
             * - El resultado depende de la configuración porque distintos proveedores JPA o configuraciones de dialecto pueden aplicar formatos distintos (como forzar snake_case o mayúsculas).
             * - La principal dificultad es que estos nombres autogenerados (como camelCase) no suelen ser el estándar en bases de datos relacionales, lo que entorpece la legibilidad al escribir consultas SQL crudas o al integrar los datos con otros sistemas que esperan un esquema más tradicional.
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
