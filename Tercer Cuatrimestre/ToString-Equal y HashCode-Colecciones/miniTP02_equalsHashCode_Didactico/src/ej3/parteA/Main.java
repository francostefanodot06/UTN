package ej3.parteA;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductoRoto p1 = new ProductoRoto("A001", "Monitor", 300.0);
        ProductoRoto p2 = new ProductoRoto("A001", "Monitor Curvo", 450.0);

        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true
        System.out.println("p1.hashCode(): " + p1.hashCode());
        System.out.println("p2.hashCode(): " + p2.hashCode()); // Son DIFERENTES porque no se sobrescribió hashCode()[cite: 22]

        Set<ProductoRoto> setRoto = new HashSet<>();
        setRoto.add(p1);
        setRoto.add(p2);
        System.out.println("Tamaño del Set (permite duplicados por romper el contrato): " + setRoto.size()); // Muestra 2 (¡Error!)[cite: 22]

        Map<ProductoRoto, Integer> mapRoto = new HashMap<>();
        mapRoto.put(p1, 50);
        System.out.println("Buscando en el Map usando p2: " + mapRoto.get(p2)); // Retorna null (no lo encuentra)[cite: 22]

        /*
         * COMENTARIO EXPLICATIVO OBLIGATORIO:
         * Este comportamiento incorrecto ocurre porque se rompió el contrato entre equals() y hashCode().
         * Aunque p1.equals(p2) es true, sus hashCode() son distintos. Al operar con HashSet y HashMap,
         * Java busca los objetos en 'buckets' diferentes según su hash. Al no coincidir el bucket,
         * el método equals() ni siquiera llega a ejecutarse para compararlos, lo que provoca que el Set acepte
         * duplicados y que el Map no pueda recuperar el valor asociado utilizando una clave equivalente.
         */
    }
}