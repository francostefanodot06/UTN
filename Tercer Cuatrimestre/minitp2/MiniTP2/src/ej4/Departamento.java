package ej4;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// PARTE B: versión CORRECTA (lado inverso con mappedBy + método helper)
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @OneToMany(mappedBy = "departamento") // lado inverso
    private List<Empleado> empleados = new ArrayList<>();

    public Departamento() { }

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public void addEmpleado(Empleado empleado) {
        if (!empleados.contains(empleado)) { // variante defensiva
            empleados.add(empleado);
        }
        empleado.setDepartamento(this);
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Empleado> getEmpleados() { return empleados; }
}
