package ej3;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PERSONAS")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @ManyToMany
    @JoinTable(
        name = "persona_curso",
        joinColumns = @JoinColumn(name = "persona_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private Set<Curso> cursos = new HashSet<>();

    public Persona() {
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);                 // actualiza el lado propietario
        curso.getInscriptos().add(this);   // actualiza el lado inverso en memoria
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Set<Curso> getCursos() { return cursos; }
}
