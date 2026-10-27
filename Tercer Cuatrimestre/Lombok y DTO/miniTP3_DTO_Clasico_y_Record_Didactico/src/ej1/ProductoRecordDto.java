package ej1;

public record ProductoRecordDto(
        Long id,
        String nombre,
        double precio
) {
    // Cuerpo vacío: el compilador genera constructor, accessors, toString, equals y hashCode[cite: 19, 21, 29]
}