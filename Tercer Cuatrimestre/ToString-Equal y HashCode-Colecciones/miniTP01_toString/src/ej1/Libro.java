package ej1;

public class Libro {
    private String titulo;
    private String autor;
    private int anio;

    public Libro(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    @Override
    public String toString() {
        // COMENTARIO OBLIGATORIO:
        // System.out.println() invoca automáticamente al método toString() porque está diseñado
        // internamente para llamar a String.valueOf(objeto), el cual, si el objeto no es nulo,
        // ejecuta su método toString() implícitamente para obtener su representación en texto.
        return "Libro[titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + "]";
    }
}
