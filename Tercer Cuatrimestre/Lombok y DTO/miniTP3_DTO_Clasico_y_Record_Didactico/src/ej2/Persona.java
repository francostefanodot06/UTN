package ej2;

public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private String calle;
    private int numero;

    public Persona(String nombre, String apellido, String email, String calle, int numero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.calle = calle;
        this.numero = numero;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public String getCalle() { return calle; }
    public int getNumero() { return numero; }
}