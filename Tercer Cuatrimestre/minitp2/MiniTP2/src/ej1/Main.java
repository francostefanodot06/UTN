package ej1;

import jakarta.persistence.*;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ej1PU");

        // ───────────────────────── PARTE A ─────────────────────────
        Long empleadoId;
        Empleado empleado = new Empleado("Laura", 50000.0);

        EntityManager em1 = emf.createEntityManager();
        try {
            em1.getTransaction().begin();
            em1.persist(empleado);
            em1.getTransaction().commit();
            empleadoId = empleado.getId();
        } finally {
            em1.close(); // ← a partir de acá "empleado" está DETACHED
        }

        // Modificación SIN EntityManager que gestione el objeto
        empleado.setSalario(80000.0);

        EntityManager em2 = emf.createEntityManager();
        try {
            Empleado desdeBD = em2.find(Empleado.class, empleadoId);
            System.out.println("PARTE A - Salario en base de datos: " + desdeBD.getSalario());
            // Salida esperada: 50000.0

            /*
             * COMENTARIO OBLIGATORIO - PARTE A
             * El salario sigue siendo 50000.0 porque al cerrar em1 el contexto de persistencia
             * desapareció y el objeto "empleado" pasó al estado DETACHED: sigue existiendo en
             * memoria Java y conserva su ID, pero ningún EntityManager lo está administrando.
             * El "dirty checking" (comparar el estado del objeto con el original al hacer commit)
             * solo funciona sobre entidades MANAGED. Como cuando llamé a setSalario(80000.0) el
             * objeto ya estaba detached, JPA nunca se enteró del cambio y no generó ningún UPDATE.
             * El cambio quedó solo en la memoria de Java.
             */
        } finally {
            em2.close();
        }

        // ───────────────────────── PARTE B ─────────────────────────
        // Repetimos el flujo, pero esta vez usamos merge() antes del find()
        Empleado empleadoB = new Empleado("Laura", 50000.0);
        Long idB;

        EntityManager em3 = emf.createEntityManager();
        try {
            em3.getTransaction().begin();
            em3.persist(empleadoB);
            em3.getTransaction().commit();
            idB = empleadoB.getId();
        } finally {
            em3.close(); // DETACHED
        }

        empleadoB.setSalario(80000.0); // cambio sobre objeto detached

        EntityManager em4 = emf.createEntityManager();
        try {
            em4.getTransaction().begin();
            Empleado managed = em4.merge(empleadoB); // reasocia: devuelve OTRA instancia administrada
            em4.getTransaction().commit();           // acá se ejecuta el UPDATE

            // Opcional: comprobar que son objetos distintos
            System.out.println("empleado == managed ? " + (empleadoB == managed)); // false
        } finally {
            em4.close();
        }

        EntityManager em5 = emf.createEntityManager();
        try {
            Empleado desdeBD = em5.find(Empleado.class, idB);
            System.out.println("PARTE B - Salario en base de datos: " + desdeBD.getSalario());
            // Salida esperada: 80000.0

            /*
             * COMENTARIO OBLIGATORIO - PARTE B
             * merge(objeto) toma un objeto DETACHED (con ID ya asignado), busca en el contexto
             * actual la entidad con ese ID (si no está la carga de la BD) y le copia el estado
             * del objeto recibido. Devuelve esa instancia MANAGED, que es una copia distinta del
             * objeto original (por eso empleadoB == managed da false). Al hacer commit, el
             * dirty checking detecta que el salario difiere de lo cargado y genera el UPDATE.
             *
             * Diferencia con persist(): persist() solo sirve para entidades NEW (sin ID, que
             * JPA no conoce) y convierte ESE MISMO objeto en managed para hacer un INSERT.
             * Con un objeto detached que ya tiene ID, persist() no es adecuado: lanza
             * PersistenceException ("detached entity passed to persist") y de todas formas
             * no está pensado para actualizar filas existentes. Por eso acá hay que usar merge().
             */
        } finally {
            em5.close();
            emf.close();
        }
    }
}
