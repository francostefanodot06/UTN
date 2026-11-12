package ej2;

import jakarta.persistence.*;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ej2PU");
        EntityManager em = emf.createEntityManager();
        Long empleadoId;

        try {
            em.getTransaction().begin();

            Departamento depto = new Departamento("Tecnología");
            em.persist(depto);

            Empleado carlos = new Empleado("Carlos");
            carlos.setDepartamento(depto);
            em.persist(carlos);

            em.getTransaction().commit();
            empleadoId = carlos.getId();
        } finally {
            em.close();
        }

        EntityManager em2 = emf.createEntityManager();
        try {
            Empleado e = em2.find(Empleado.class, empleadoId);
            System.out.println("Empleado: " + e.getNombre()
                    + " | Departamento: " + e.getDepartamento().getNombre());
            // Salida esperada: Empleado: Carlos | Departamento: Tecnología
        } finally {
            em2.close();
            emf.close();
        }

        /*
         * COMENTARIO OBLIGATORIO
         * Que la relación sea unidireccional significa que solo UNA de las dos entidades tiene
         * una referencia a la otra en el código Java: Empleado "conoce" a su Departamento
         * (tiene el atributo "departamento"), pero Departamento no sabe nada de sus empleados
         * (no tiene ninguna lista). Desde un Empleado puedo llegar al Departamento, pero no al revés.
         *
         * La clave foránea DEPARTAMENTO_ID quedó en la tabla EMPLEADOS (se verifica en la consola
         * H2 con SELECT * FROM EMPLEADOS: ahí aparece la columna con el ID del departamento).
         * JPA la ubica ahí porque la FK siempre va en la tabla de la entidad que declara
         * @ManyToOne + @JoinColumn: ese es el lado "muchos", y cada fila de EMPLEADOS guarda a
         * qué (único) departamento pertenece. Poner la FK en DEPARTAMENTOS no tendría sentido,
         * porque un departamento tiene muchos empleados y una sola columna no podría guardarlos.
         */
    }
}
