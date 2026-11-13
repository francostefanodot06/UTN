package ej3;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSONAS")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CIUDAD")
    private String ciudad;

    @Column(name = "EDAD")
    private int edad;

    // Constructor vacío (requerido por JPA)
    public Persona() { }

    public Persona(String nombre, String ciudad, int edad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
}
