package ej2;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CURSOS")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @ManyToMany(mappedBy = "cursos")
    private Set<Persona> inscriptos = new HashSet<>();

    // Constructor vacío (requerido por JPA)
    public Curso() { }

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Set<Persona> getInscriptos() { return inscriptos; }
    public void setInscriptos(Set<Persona> inscriptos) { this.inscriptos = inscriptos; }
}
