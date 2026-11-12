package ej4;

import jakarta.persistence.*;

// PARTE B: relación bidireccional correcta
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ej4PU");
        EntityManager em = emf.createEntityManager();
        Long deptoId;

        try {
            em.getTransaction().begin();

            Departamento tecnologia = new Departamento("Tecnología");
            Empleado ana = new Empleado("Ana");
            Empleado marcos = new Empleado("Marcos");

            tecnologia.addEmpleado(ana);
            tecnologia.addEmpleado(marcos);

            em.persist(tecnologia);
            em.persist(ana);
            em.persist(marcos);

            em.getTransaction().commit();
            deptoId = tecnologia.getId();
        } finally {
            em.close();
        }

        EntityManager em2 = emf.createEntityManager();
        try {
            Departamento d = em2.find(Departamento.class, deptoId);
            System.out.println("Departamento: " + d.getNombre());
            System.out.println("Empleados:");
            for (Empleado e : d.getEmpleados()) {
                System.out.println(" - " + e.getNombre());
            }
            // En H2: EMPLEADOS ahora tiene una sola columna FK: DEPARTAMENTO_ID
        } finally {
            em2.close();
            emf.close();
        }

        /*
         * COMENTARIO OBLIGATORIO - PARTE B
         * addEmpleado() agrega el empleado a la lista del departamento Y le asigna el
         * departamento al empleado (empleado.setDepartamento(this)). Es necesario actualizar los
         * dos lados porque en Java son dos referencias independientes: JPA no las sincroniza
         * por nosotros. mappedBy configura el mapeo; el helper mantiene consistente el modelo
         * de objetos en memoria.
         *
         * Si solo hiciera empleados.add(empleado) sin empleado.setDepartamento(this):
         *  - el lado propietario (Empleado.departamento) quedaría en null,
         *  - JPA solo mira ese lado para escribir la FK, así que DEPARTAMENTO_ID se guardaría
         *    en NULL en la BD (la relación "no se guarda"),
         *  - y en memoria, empleado.getDepartamento() devolvería null aunque esté en la lista.
         *
         * Lado propietario: Empleado (@ManyToOne + @JoinColumn), es quien controla la FK.
         * Lado inverso: Departamento (@OneToMany(mappedBy="departamento")), solo da
         * navegabilidad en Java. Solo uno modifica la FK porque en la base de datos existe una
         * única columna FK; si ambos lados la controlaran, habría dos relaciones (como en la
         * Parte A) y datos duplicados o inconsistentes.
         */
    }
}
