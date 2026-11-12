package ej4a;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// PARTE A: versión INCORRECTA (sin mappedBy), a propósito, para reproducir el error
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany // sin mappedBy — INCORRECTO
    @JoinColumn(name = "departamentos_id")
    private List<Empleado> empleados = new ArrayList<>();

    public Departamento() { }

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Empleado> getEmpleados() { return empleados; }
}
