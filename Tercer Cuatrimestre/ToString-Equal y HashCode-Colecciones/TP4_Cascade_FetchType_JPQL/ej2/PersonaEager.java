package ej2;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PERSONAS")
public class PersonaEager {

    @Id
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "persona_curso",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private Set<Curso> cursos = new HashSet<>();

    // Entidad de solo lectura: mapea la misma tabla PERSONAS y la misma
    // tabla intermedia persona_curso que Persona, pero con fetch = EAGER,
    // únicamente para reproducir el problema N+1 en la Parte 3 sin tocar
    // la relación LAZY de Persona.
    public PersonaEager() { }

    public String getNombre() { return nombre; }
    public Set<Curso> getCursos() { return cursos; }
}
