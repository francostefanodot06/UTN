package com.utn.entities;

import com.utn.enums.Rol;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true, exclude = {"contraseña", "pedidos"})
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contraseña;
    private Rol rol;

    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();
}