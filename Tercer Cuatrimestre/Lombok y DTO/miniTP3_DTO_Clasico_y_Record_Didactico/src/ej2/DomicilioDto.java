package ej2;

public class DomicilioDto {
    private String calle;
    private int numero;

    public DomicilioDto(String calle, int numero) {
        this.calle = calle;
        this.numero = numero;
    }

    public String getCalle() { return calle; }
    public int getNumero() { return numero; }

    @Override
    public String toString() {
        return "DomicilioDto{calle='" + calle + "', numero=" + numero + "}";
    }
}