package ej4a;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

// PARTE A: reproduce la FK duplicada (DEPARTAMENTO_ID y DEPARTAMENTOS_ID en EMPLEADOS)
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ej4aPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Departamento sistemas = new Departamento("Sistemas");
            Empleado ana = new Empleado("Ana");
            Empleado marcos = new Empleado("Marcos");

            ana.setDepartamento(sistemas);
            marcos.setDepartamento(sistemas);
            sistemas.getEmpleados().add(ana);
            sistemas.getEmpleados().add(marcos);

            em.persist(sistemas);
            em.persist(ana);
            em.persist(marcos);

            em.getTransaction().commit();

            // Consulta nativa para ver las dos columnas FK (equivale a SELECT * FROM EMPLEADOS en H2)
            @SuppressWarnings("unchecked")
            List<Object[]> filas = em.createNativeQuery(
                    "SELECT ID, NOMBRE, DEPARTAMENTO_ID, DEPARTAMENTOS_ID FROM EMPLEADOS").getResultList();
            System.out.println("ID | NOMBRE | DEPARTAMENTO_ID | DEPARTAMENTOS_ID");
            for (Object[] f : filas) {
                System.out.println(f[0] + " | " + f[1] + " | " + f[2] + " | " + f[3]);
            }
        } finally {
            em.close();
            emf.close();
        }

        /*
         * COMENTARIO OBLIGATORIO - PARTE A
         * Aparecen dos columnas FK porque ninguna de las dos entidades declara mappedBy, así que
         * JPA entiende que hay DOS relaciones independientes y no una sola bidireccional:
         *  1) Empleado.departamento (@ManyToOne + @JoinColumn) → columna DEPARTAMENTO_ID
         *  2) Departamento.empleados (@OneToMany + @JoinColumn) → columna DEPARTAMENTOS_ID,
         *     que también se crea en la tabla EMPLEADOS (el lado "muchos").
         * Las dos "dueñas" mantienen su propia FK, y no se lanza ninguna excepción: el error solo
         * se ve mirando el esquema en H2. Además Hibernate hace INSERT y luego UPDATEs extra
         * para completar la segunda columna.
         *
         * El lado propietario correcto es Empleado (@ManyToOne + @JoinColumn), porque es el que
         * tiene la FK en su tabla. Departamento debería ser el lado INVERSO: usar
         * @OneToMany(mappedBy = "departamento") y sin @JoinColumn, solo para navegar en Java.
         */
    }
}
