import java.util.Scanner;

// ==========================================
// EJERCICIO 06: Conversiones de tipo y División (Casting)
// ==========================================
public class Ejercicio_06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("--- Comparativa de División en Java ---");

        System.out.println("Ingrese el dividendo (entero):");
        int num1 = Integer.parseInt(input.nextLine());

        System.out.println("Ingrese el divisor (entero):");
        int num2 = Integer.parseInt(input.nextLine());

        System.out.println("\n--- Resultados ---");

        // 1. DIVISIÓN ENTERA (El problema)
        // Al dividir dos enteros (int), Java asume que el resultado debe ser un entero.
        // Por lo tanto, trunca (corta) cualquier parte decimal ANTES de guardarlo,
        // incluso si lo guardamos en una variable de tipo double.
        double resultadoIncorrecto = num1 / num2;
        System.out.println("División sin casting (se pierden decimales): " + resultadoIncorrecto);

        // 2. DIVISIÓN CON CASTING EXPLÍCITO (La solución)
        // Al colocar (double) antes de num1, convertimos temporalmente ese valor
        // a un número con decimales antes de que ocurra la división.
        // Al haber un double en la operación matemática, Java realiza una división precisa.
        double resultadoPreciso = (double) num1 / num2;
        System.out.println("División con casting a double (resultado exacto): " + resultadoPreciso);

        /* * EJEMPLO DE PRUEBA DE ESCRITORIO:
         * Si el usuario ingresa 10 y 4:
         * - resultadoIncorrecto guardará 2.0 (porque 10 / 4 es 2.5, pero el .5 se destruye en la división entera).
         * - resultadoPreciso guardará 2.5 (porque al forzar a double, calcula con decimales reales).
         */
    }
}