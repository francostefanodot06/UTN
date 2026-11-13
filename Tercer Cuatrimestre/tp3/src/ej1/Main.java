package ej1;

import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebaJPAPU1");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Primero los domicilios (sin cascade, hay que persistirlos antes)
            Domicilio d1 = new Domicilio("Corrientes 1234", "Buenos Aires");
            Domicilio d2 = new Domicilio("San Martín 567", "Córdoba");
            em.persist(d1);
            em.persist(d2);

            // Después las personas con sus domicilios ya persistidos
            Persona ana = new Persona("Ana");
            ana.setDomicilio(d1);
            em.persist(ana);

            Persona luis = new Persona("Luis");
            luis.setDomicilio(d2);
            em.persist(luis);

            em.getTransaction().commit();

            // Recuperar con find() e imprimir
            Persona a = em.find(Persona.class, ana.getId());
            Persona l = em.find(Persona.class, luis.getId());
            imprimir(a);
            imprimir(l);

            /*
             * COMENTARIO OBLIGATORIO - Ejercicio 1
             *
             * Verificación en H2: la tabla PERSONAS tiene la columna DOMICILIO_ID, que es la
             * clave foránea. La tabla DOMICILIOS solo tiene ID, CALLE y CIUDAD: no tiene
             * ninguna columna que apunte hacia personas. Además, DOMICILIO_ID tiene una
             * restricción UNIQUE (se ve en INFORMATION_SCHEMA.CONSTRAINTS / en el DDL generado).
             *
             * La FK quedó en PERSONAS porque Persona es el lado propietario: es la entidad que
             * declara @OneToOne con @JoinColumn, y JPA pone la columna FK en la tabla de la
             * entidad que declara la relación. Persona conoce a Domicilio, pero Domicilio no
             * sabe nada de Persona (unidireccional), entonces no hay nada que guardar allá.
             *
             * unique = true agrega una restricción UNIQUE sobre la columna DOMICILIO_ID en la
             * base de datos. Garantiza que dos filas de PERSONAS no puedan apuntar al mismo
             * domicilio. Una FK normal solo asegura que el valor exista en la otra tabla, pero
             * permite que muchas filas repitan el mismo valor (eso sería en realidad un
             * ManyToOne). Con UNIQUE además no se pueden repetir, y recién ahí es un 1:1 real.
             *
             * Si intentara asignarle el mismo domicilio (d1) a dos personas distintas, al hacer
             * flush/commit la base rechazaría el INSERT con una excepción de violación de
             * restricción UNIQUE (ConstraintViolationException) y la transacción haría rollback.
             * Sin unique=true, en cambio, lo aceptaría sin quejarse.
             *
             * La relación la administra Persona (el lado propietario, el que tiene
             * @JoinColumn) y la clave foránea queda almacenada en la tabla PERSONAS.
             */
        } finally {
            em.close();
            emf.close();
        }
    }

    private static void imprimir(Persona p) {
        System.out.println("Persona: " + p.getNombre() + " | Domicilio: "
                + p.getDomicilio().getCalle() + ", " + p.getDomicilio().getCiudad());
    }
}
