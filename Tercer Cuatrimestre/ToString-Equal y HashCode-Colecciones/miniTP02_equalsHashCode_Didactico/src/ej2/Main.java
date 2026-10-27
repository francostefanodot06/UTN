package ej2;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto("P001", "Teclado", 45.0);
        Producto p2 = new Producto("P001", "Teclado Mecánico", 85.0); // Equivalente lógico (mismo código)

        // --- PRUEBA CON HASHSET ---
        Set<Producto> productosSet = new HashSet<>();
        productosSet.add(p1);

        // contains() devuelve true antes de agregar p2 porque equals() y hashCode() determinan que son equivalentes[cite: 22]
        System.out.println("¿El Set contiene a p2 antes de agregarlo?: " + productosSet.contains(p2));

        productosSet.add(p2); // Al estar implementado equals/hashCode, el Set rechaza el duplicado
        System.out.println("Tamaño del Set después de intentar agregar p2: " + productosSet.size()); // Debe ser 1[cite: 22]

        // --- PRUEBA CON HASHMAP ---
        Map<Producto, Integer> stockMap = new HashMap<>();
        stockMap.put(p1, 10); // Asociamos p1 con el stock 10[cite: 22]

        // Buscamos el valor utilizando p2 como clave gracias a que el contrato hash está respetado[cite: 22]
        Integer stockEncontrado = stockMap.get(p2);
        System.out.println("Stock recuperado buscando con p2: " + stockEncontrado); // Debe retornar 10[cite: 22]

        /*
         * COMENTARIO OBLIGATORIO:
         * - contains() devuelve true antes de insertar p2 porque el HashSet utiliza hashCode() para
         *   ubicar el bucket y equals() para confirmar la igualdad lógica de contenido entre p1 y p2.
         * - El Set rechaza la inserción de p2 porque considera que el elemento lógicamente ya existe.
         * - El Map encuentra y recupera el valor asociado (10) usando p2 como clave porque ambas instancias
         *   generan el mismo código hash y dan 'true' al compararse con equals().
         */
    }
}