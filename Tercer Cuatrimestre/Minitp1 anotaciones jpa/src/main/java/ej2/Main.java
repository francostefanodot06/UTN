package ej2;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebaJPAPU");
        EntityManager em = emf.createEntityManager();

        try {
            Producto p1 = new Producto("Teclado mecánico", "KB-001", EstadoProducto.ACTIVO, 25);
            Producto p2 = new Producto("Mouse inalámbrico", "MS-002", EstadoProducto.PENDIENTE, 10);
            Producto p3 = new Producto("Auriculares USB", "AU-003", EstadoProducto.INACTIVO, 0);

            em.getTransaction().begin();
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.getTransaction().commit();

            em.clear();

            Producto recuperado1 = em.find(Producto.class, p1.getId());
            Producto recuperado2 = em.find(Producto.class, p2.getId());
            Producto recuperado3 = em.find(Producto.class, p3.getId());

            System.out.println("Producto 1: " + recuperado1.getNombre() + " | Estado: " + recuperado1.getEstado());
            System.out.println("Producto 2: " + recuperado2.getNombre() + " | Estado: " + recuperado2.getEstado());
            System.out.println("Producto 3: " + recuperado3.getNombre() + " | Estado: " + recuperado3.getEstado());

            /*
             * COMENTARIO OBLIGATORIO:
             * - Con EnumType.ORDINAL, los estados se habrían almacenado como números enteros basados en su posición en la declaración del Enum (0, 1, 2...).
             * - El riesgo radica en que si se inserta un nuevo valor en el medio del Enum o se cambia el orden, los números almacenados previamente en la base de datos pasarían a representar estados incorrectos.
             * - EnumType.STRING evita esto almacenando el nombre literal del estado ("ACTIVO", "PENDIENTE"). El orden deja de importar.
             * - Guardar texto ocupa más espacio de almacenamiento en disco y memoria que un simple dígito numérico.
             * - Sin embargo, se prefiere porque facilita enormemente la lectura de la base de datos al realizar consultas SQL directas y evita errores catastróficos por refactorización del código.
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
