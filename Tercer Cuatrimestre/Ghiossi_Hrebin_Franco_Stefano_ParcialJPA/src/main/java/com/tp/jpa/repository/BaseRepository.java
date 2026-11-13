package com.tp.jpa.repository;

import com.tp.jpa.model.Base;
import com.tp.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio genérico con las operaciones CRUD comunes a todas las entidades que extienden Base.
 * Cada método abre su propio EntityManager y lo cierra en un bloque finally.
 */
public abstract class BaseRepository<T extends Base> {

    private final Class<T> clase;
    private final EntityManagerFactory emf;

    protected BaseRepository(Class<T> clase) {
        this.clase = clase;
        this.emf = JPAUtil.getEntityManagerFactory();
    }

    protected Class<T> getEntityClass() {
        return clase;
    }

    protected EntityManager crearEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Alta (persist) si el id es null, actualización (merge) si ya tiene id.
     * Retorna la entidad gestionada: el ID generado debe leerse de ESTE objeto retornado
     * (con merge() el ID solo existe en la copia devuelta, no en el objeto original).
     */
    public T guardar(T entity) {
        EntityManager em = crearEntityManager();
        try {
            em.getTransaction().begin();
            T gestionada;
            if (entity.getId() == null) {
                em.persist(entity);
                gestionada = entity;
            } else {
                gestionada = em.merge(entity);
            }
            em.getTransaction().commit();
            return gestionada;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public Optional<T> buscarPorId(Long id) {
        EntityManager em = crearEntityManager();
        try {
            T entidad = em.find(clase, id);
            return Optional.ofNullable(entidad);
        } finally {
            em.close();
        }
    }

    public List<T> listarActivos() {
        EntityManager em = crearEntityManager();
        try {
            // Consulta JPQL: retorna todos los registros que no fueron dados de baja lógica.
            // Se arma con el nombre simple de la clase para que sirva a cualquier entidad que extienda Base.
            String jpql = "SELECT e FROM " + clase.getSimpleName() + " e WHERE e.eliminado = false";
            return em.createQuery(jpql, clase).getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Baja lógica: marca eliminado = true y sincroniza con merge(). Nunca usa remove().
     * Retorna false si la entidad no existe o ya estaba dada de baja.
     */
    public boolean eliminarLogico(Long id) {
        EntityManager em = crearEntityManager();
        try {
            em.getTransaction().begin();
            T entidad = em.find(clase, id);
            if (entidad == null || entidad.isEliminado()) {
                em.getTransaction().rollback();
                return false;
            }
            entidad.setEliminado(true);
            em.merge(entidad);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
}
