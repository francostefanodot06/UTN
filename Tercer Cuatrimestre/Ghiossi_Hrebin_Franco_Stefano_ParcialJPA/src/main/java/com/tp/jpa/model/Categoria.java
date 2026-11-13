package com.tp.jpa.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @SuperBuilder
public class Categoria extends Base {
    private String nombre;
    private String descripcion;

    // Agregación unidireccional: Producto no conoce su categoría.
    // La columna categoria_id vive en la tabla producto pero la administra Categoria.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    @Builder.Default
    private Set<Producto> productos = new HashSet<>();

    public void addProducto(Producto producto) {
        productos.add(producto);
    }
}
