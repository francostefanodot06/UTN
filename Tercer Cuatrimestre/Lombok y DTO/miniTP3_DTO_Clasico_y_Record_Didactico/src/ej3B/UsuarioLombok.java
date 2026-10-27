package ej3b;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class UsuarioLombok {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}