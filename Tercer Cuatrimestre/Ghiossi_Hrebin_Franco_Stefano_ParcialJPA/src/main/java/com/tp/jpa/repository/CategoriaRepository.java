package com.tp.jpa.repository;

import com.tp.jpa.model.Categoria;
import com.tp.jpa.model.Producto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaRepository extends BaseRepository<Categoria> {

    public CategoriaRepository() {
        super(Categoria.class);
    }

    /**
     * Retorna los productos activos (eliminado = false) de la categoría indicada.
     */
    public List<Producto> buscarProductosPorCategoria(Long categoriaId) {
        EntityManager em = crearEntityManager();
        try {
            // Consulta JPQL: retorna los productos activos de una categoría.
            // Como la relación es unidireccional y Categoria es la dueña, se
            // navega desde Categoria hacia su colección c.productos mediante JOIN.
            // Se filtra por el id de la categoría (parámetro nombrado :catId) y
            // por p.eliminado = false para excluir las bajas lógicas.
            String jpql = "SELECT p FROM Categoria c JOIN c.productos p "
                        + "WHERE c.id = :catId AND p.eliminado = false";
            List<Producto> productos = em.createQuery(jpql, Producto.class)
                    .setParameter("catId", categoriaId)
                    .getResultList();
            return productos;
        } finally {
            em.close();
        }
    }

    /**
     * Persiste el producto y lo asocia a la categoría en una única transacción.
     * Lanza IllegalArgumentException (con rollback) si la categoría no existe o está dada de baja.
     */
    public Producto agregarProducto(Long categoriaId, Producto producto) {
        EntityManager em = crearEntityManager();
        try {
            em.getTransaction().begin();

            Categoria categoria = em.find(Categoria.class, categoriaId);
            if (categoria == null || categoria.isEliminado()) {
                em.getTransaction().rollback();
                throw new IllegalArgumentException(
                        "La categoría con ID " + categoriaId + " no existe o está dada de baja.");
            }

            // Primero se inserta el producto (recibe su ID)...
            em.persist(producto);
            // ...y luego se lo agrega a la colección de la categoría (dueña de la relación),
            // lo que completa la columna categoria_id al hacer commit.
            categoria.addProducto(producto);

            em.getTransaction().commit();
            return producto;
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
