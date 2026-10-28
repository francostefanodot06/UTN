package com.utn.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true, exclude = "productos")
@EqualsAndHashCode(callSuper = true)
public class Categoria extends Base {
    private String nombre;
    private String descripcion;

    @Builder.Default
    private Set<Producto> productos = new HashSet<>();
}