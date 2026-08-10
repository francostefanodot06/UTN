// ==========================================
// EJERCICIO 08: Prueba de Escritorio
// ==========================================
public class Ejercicio_08 {
    public static void main(String[] args) {
        int a = 5;
        int b = 2;
        int resultado = a / b;

        System.out.println("Resultado: " + resultado);

        /* * RESPUESTA TEÓRICA (Prueba de escritorio):
         * 1. a vale 5
         * 2. b vale 2
         * 3. a / b -> 5 / 2. Matemáticamente es 2.5
         * ¿Por qué el valor final es 2?
         * Porque en Java, al dividir dos variables de tipo 'int', el compilador
         * asume que el resultado debe ser obligatoriamente un 'int'.
         * Por lo tanto, trunca (corta) la parte decimal sin redondear.
         */
    }
}
