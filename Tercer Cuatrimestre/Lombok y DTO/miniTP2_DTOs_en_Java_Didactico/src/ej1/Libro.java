package ej1;

public class Libro {
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private double costoAdquisicion;
    private int stockInterno;

    // Constructor con todos los parámetros[cite: 24, 32]
    public Libro(Long id, String titulo, String autor, String isbn, double costoAdquisicion, int stockInterno) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.costoAdquisicion = costoAdquisicion;
        this.stockInterno = stockInterno;
    }

    // Getters necesarios para que LibroDTO pueda acceder a los atributos
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public double getCostoAdquisicion() { return costoAdquisicion; }
    public int getStockInterno() { return stockInterno; }

    @Override
    public String toString() {
        return "Libro{id=" + id + ", titulo='" + titulo + "', autor='" + autor +
                "', isbn='" + isbn + "', costoAdquisicion=" + costoAdquisicion +
                ", stockInterno=" + stockInterno + "}";
    }
}