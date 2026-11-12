package ej3;

import jakarta.persistence.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ej3PU");
        EntityManager em = emf.createEntityManager();
        List<Long> ids = new ArrayList<>();

        try {
            em.getTransaction().begin();

            // ── Factura F-001 ──
            // Sin cascade: primero se persisten los ítems, después la factura
            ItemFactura i1 = new ItemFactura("Notebook", 85000.0);
            ItemFactura i2 = new ItemFactura("Mouse", 3500.0);
            em.persist(i1);
            em.persist(i2);
            Factura f1 = new Factura("F-001");
            f1.getItems().add(i1);
            f1.getItems().add(i2);
            em.persist(f1);

            // ── Factura F-002 ──
            ItemFactura i3 = new ItemFactura("Monitor", 45000.0);
            em.persist(i3);
            Factura f2 = new Factura("F-002");
            f2.getItems().add(i3);
            em.persist(f2);

            // ── Factura F-003 ──
            ItemFactura i4 = new ItemFactura("Teclado mecánico", 12000.0);
            ItemFactura i5 = new ItemFactura("Auriculares", 8000.0);
            em.persist(i4);
            em.persist(i5);
            Factura f3 = new Factura("F-003");
            f3.getItems().add(i4);
            f3.getItems().add(i5);
            em.persist(f3);

            em.getTransaction().commit();
            ids.add(f1.getId());
            ids.add(f2.getId());
            ids.add(f3.getId());
        } finally {
            em.close();
        }

        // Recuperamos con un EntityManager nuevo (así los ítems se leen de la BD)
        EntityManager em2 = emf.createEntityManager();
        try {
            for (Long id : ids) {
                Factura f = em2.find(Factura.class, id);
                System.out.println("Factura " + f.getNumero() + ":");
                for (ItemFactura item : f.getItems()) {
                    System.out.println(" - " + item.getDescripcion() + ": $" + item.getPrecio());
                }
            }
        } finally {
            em2.close();
            emf.close();
        }

        /*
         * VERIFICACIÓN EN H2: la tabla ITEMS_FACTURA tiene la columna FACTURA_ID y NO existe
         * ninguna tabla intermedia tipo FACTURAS_ITEMS_FACTURA.
         *
         * COMENTARIO OBLIGATORIO
         * Si hubiera escrito @OneToMany sin @JoinColumn, Hibernate habría interpretado la relación
         * unidireccional como si fuera un @ManyToMany y habría creado una TABLA INTERMEDIA
         * (join table), por ejemplo FACTURAS_ITEMS_FACTURA, con dos columnas (FACTURAS_ID e
         * ITEMS_ID). Cada vínculo factura-ítem sería una fila en esa tabla extra, con un JOIN
         * adicional en cada consulta y una tabla más para mantener.
         *
         * Con @JoinColumn(name="factura_id") le indico a JPA que la FK va directamente en la
         * tabla del lado "muchos" (ITEMS_FACTURA.FACTURA_ID). Es relevante en una relación
         * unidireccional uno-a-muchos porque ItemFactura no tiene referencia a Factura: sin
         * @JoinColumn, JPA no tendría dónde guardar la FK en la entidad hija y recurre a la
         * tabla de unión. Con @JoinColumn el esquema queda simple (dos tablas, una FK) como
         * en el modelo relacional tradicional.
         */
    }
}
