package ej1;

public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto("P001", "Laptop", 1200.0);
        Producto p2 = new Producto("P001", "Laptop Gamer", 1500.0); // Mismo código, distinto nombre/precio
        Producto p3 = new Producto("P002", "Mouse", 25.0);

        System.out.println("--- PRUEBAS DE COMPARACIÓN ---");

        // 1. Con operador == (compara referencias en memoria)
        System.out.println("p1 == p2: " + (p1 == p2)); // false, son instancias distintas en memoria[cite: 21]
        System.out.println("p1 == p3: " + (p1 == p3)); // false

        // 2. Con equals() (compara contenido lógico basado en el código)
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // true, porque comparten el mismo código[cite: 21]
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // false

        // 3. Verificación de hashCode()
        System.out.println("hashCode p1: " + p1.hashCode());
        System.out.println("hashCode p2: " + p2.hashCode()); // Coinciden porque equals() y hashCode() usan el código
        System.out.println("hashCode p3: " + p3.hashCode());

        /*
         * COMENTARIO EXPLICATIVO OBLIGATORIO:
         * - p1 == p2 devuelve false porque el operador '==' evalúa la igualdad de referencias,
         *   es decir, si ambas variables apuntan exactamente al mismo espacio físico en la memoria RAM.
         * - p1.equals(p2) pasa a ser true tras sobrescribir equals() porque la lógica implementada
         *   compara el contenido del atributo 'codigo', determinando que representan el mismo producto lógicamente.
         */
    }
}