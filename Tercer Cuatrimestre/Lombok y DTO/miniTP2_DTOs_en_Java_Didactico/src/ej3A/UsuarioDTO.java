package ej3a;

public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private String fechaCreacion;

    // Constructor con todos los parámetros[cite: 26, 34]
    public UsuarioDTO(Long id, String nombre, String email, String password, String fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{id=" + id + ", nombre='" + nombre + "', email='" + email +
                "', password='" + password + "', fechaCreacion=" + fechaCreacion + "}";
    }
}