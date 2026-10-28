package com.utn.dtos;

public record UsuarioDTO(
        Long id,
        String nombre,
        String apellido,
        String mail,
        String celular
) {
}