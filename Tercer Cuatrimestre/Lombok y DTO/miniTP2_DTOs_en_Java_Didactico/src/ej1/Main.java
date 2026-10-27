package ej1;

public class Main {
    public static void main(String[] args) {
        // Instancia de Libro con los datos solicitados[cite: 24]
        Libro libro = new Libro(1L, "El Alquimista", "Paulo Coelho", "978-0062315007", 1500.0, 42);

        // Creación del objeto LibroDTO a partir del Libro[cite: 24]
        LibroDTO libroDTO = new LibroDTO(libro);

        System.out.println("=== Entidad completa ===");
        System.out.println(libro);
        System.out.println("=== DTO expuesto ===");
        System.out.println(libroDTO);
    }
}

/*
COMENTARIOS OBLIGATORIOS - EJERCICIO 1:
1. ¿Qué es un DTO y cuál es su propósito?
   - Un DTO (Data Transfer Object) es un objeto plano (POJO) cuyo único propósito es transportar datos entre las distintas capas de la aplicación sin incluir lógica de negocio ni anotaciones de persistencia[cite: 21, 22].
2. ¿Por qué LibroDTO no incluye costoAdquisicion ni stockInterno?
   - No se incluyen porque son datos de gestión interna y costos que no deben exponerse al cliente o capas externas por motivos de seguridad y privacidad del negocio[cite: 21, 24].
3. ¿Qué problema generaría exponer la entidad Libro directamente a través de una API?
   - Acoplación innecesaria entre las capas y el riesgo grave de mostrar información interna o sensible que no debería ser pública (como costos de adquisición o márgenes)[cite: 21].
*/