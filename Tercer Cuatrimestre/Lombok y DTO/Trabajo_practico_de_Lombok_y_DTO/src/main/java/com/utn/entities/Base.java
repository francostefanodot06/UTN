package com.utn.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString // <-- Agregar esta línea
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Base {
    @EqualsAndHashCode.Include
    protected Long id;
    protected boolean eliminado;
    protected LocalDateTime createdAt;
}