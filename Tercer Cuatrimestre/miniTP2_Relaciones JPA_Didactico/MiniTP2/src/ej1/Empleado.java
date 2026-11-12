package ej1;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLEADOS")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "SALARIO")
    private double salario;

    public Empleado() { }

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public double getSalario() { return salario; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSalario(double salario) { this.salario = salario; }
}
