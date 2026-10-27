package ej1;

public class LibroDTO {
    private Long id;
    private String titulo;
    private String autor;

    // Constructor que reciba un Libro y asigne solo los 3 campos[cite: 24, 32]
    public LibroDTO(Libro libro) {
        this.id = libro.getId();
        this.titulo = libro.getTitulo();
        this.autor = libro.getAutor();
    }

    @Override
    public String toString() {
        return "LibroDTO{id=" + id + ", titulo='" + titulo + "', autor='" + autor + "'}";
    }
}