package ej3b;

public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private String email;
    private String fechaCreacion;

    // Constructor con los 4 parámetros[cite: 27, 28, 34]
    public UsuarioResponseDTO(Long id, String nombre, String email, String fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "UsuarioResponseDTO{id=" + id + ", nombre='" + nombre + "', email='" + email + "', fechaCreacion='" + fechaCreacion + "'}";
    }
}