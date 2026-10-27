package ej3.parteB;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductoCorregido p1 = new ProductoCorregido("A001", "Monitor", 300.0);
        ProductoCorregido p2 = new ProductoCorregido("A001", "Monitor Curvo", 450.0);

        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode()); // Ahora son IGUALES[cite: 22]

        Set<ProductoCorregido> setCorregido = new HashSet<>();
        setCorregido.add(p1);
        setCorregido.add(p2);
        System.out.println("Tamaño del Set corregido: " + setCorregido.size()); // Muestra 1 (rechaza el duplicado)[cite: 22]

        Map<ProductoCorregido, Integer> mapCorregido = new HashMap<>();
        mapCorregido.put(p1, 50);
        System.out.println("Buscando en el Map corregido usando p2: " + mapCorregido.get(p2)); // Retorna 50 correctamente[cite: 22]

        /*
         * COMENTARIO EXPLICATIVO OBLIGATORIO:
         * Se corrigió la implementación agregando el método hashCode() utilizando Objects.hash(codigo),
         * exactamente los mismos atributos evaluados en equals(). Al hacer esto, p1 y p2 generan el mismo
         * código hash, lo que permite que el HashSet y el HashMap los ubiquen en el mismo bucket,
         * ejecuten equals() exitosamente, rechacen duplicados y recuperen los valores asociados sin problemas.
         */
    }
}