package ej2;

public class Main {
    public static void main(String[] args) {
        // Creación de las 4 instancias de Producto indicadas[cite: 25, 26]
        Producto p1 = new Producto(1L, "Notebook Lenovo", 850000.0, "Electrónica", 600000.0, 41.7);
        Producto p2 = new Producto(2L, "Auriculares Sony", 45000.0, "Electrónica", 20000.0, 125.0);
        Producto p3 = new Producto(3L, "Silla Ergonómica", 120000.0, "Muebles", 75000.0, 60.0);
        Producto p4 = new Producto(4L, "Lámpara de escritorio", 18500.0, "Iluminación", 8000.0, 131.25);

        // Conversión utilizando el método estático ProductoDTO.fromEntity() y despliegue[cite: 25, 26]
        System.out.println(ProductoDTO.fromEntity(p1));
        System.out.println(ProductoDTO.fromEntity(p2));
        System.out.println(ProductoDTO.fromEntity(p3));
        System.out.println(ProductoDTO.fromEntity(p4));
    }
}

/*
COMENTARIOS OBLIGATORIOS - EJERCICIO 2:
1. ¿Qué ventaja tiene centralizar la conversión en fromEntity() en lugar de construir el DTO a mano en el main cada vez?
   - Permite unificar la lógica de mapeo en un solo lugar, evitando duplicar código de asignación por todo el proyecto y facilitando cambios futuros en la estructura de conversión[cite: 21, 23].
2. ¿Por qué separar costoProduccion y margenGanancia de la respuesta pública es importante desde el punto de vista de la seguridad?
   - Evita filtrar datos estratégicos y financieros internos de la empresa hacia la API pública, protegiendo información comercial delicada frente a competidores o usuarios malintencionados[cite: 21, 25].
*/