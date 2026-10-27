package ej2;

public class PersonaDto {
    private String nombre;
    private DomicilioDto domicilio;

    public PersonaDto(String nombre, DomicilioDto domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public String getNombre() { return nombre; }
    public DomicilioDto getDomicilio() { return domicilio; }

    @Override
    public String toString() {
        return "PersonaDto{nombre='" + nombre + "', domicilio=" + domicilio + "}";
    }
}