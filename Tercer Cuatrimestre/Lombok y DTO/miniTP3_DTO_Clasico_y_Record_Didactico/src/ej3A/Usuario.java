package ej3a;

public class Usuario {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    // Constructor privado que recibe el Builder interno[cite: 24, 31]
    private Usuario(Builder builder) {
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.email = builder.email;
        this.telefono = builder.telefono;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }

    @Override
    public String toString() {
        return "Usuario(nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ")";
    }

    // Clase interna estática Builder[cite: 20, 24, 26, 31]
    public static class Builder {
        private String nombre;
        private String apellido;
        private String email;
        private String telefono;

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }
}