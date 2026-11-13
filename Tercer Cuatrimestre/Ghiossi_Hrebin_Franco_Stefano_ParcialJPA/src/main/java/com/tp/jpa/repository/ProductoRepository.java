package com.tp.jpa.repository;

import com.tp.jpa.model.Producto;

/**
 * Hereda todo el CRUD de BaseRepository. Como Producto no conoce su categoría,
 * la consulta por categoría vive en CategoriaRepository.
 */
public class ProductoRepository extends BaseRepository<Producto> {

    public ProductoRepository() {
        super(Producto.class);
    }
}
