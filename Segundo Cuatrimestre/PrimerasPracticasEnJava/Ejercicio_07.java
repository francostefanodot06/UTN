import java.util.Scanner;

// ==========================================
// EJERCICIO 07: Resolución de Bugs
// ==========================================
public class Ejercicio_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa tu nombre: ");

        // RESPUESTA Y SOLUCIÓN:
        // El error original era el uso de 'scanner.nextInt();' para leer un texto,
        // lo cual causaría una excepción o leería datos erróneos.
        // Además, nextInt() deja el carácter 'Enter' en el buffer.
        // La solución es usar .nextLine() para leer la línea completa de texto.
        String nombre = scanner.nextLine();

        System.out.println("Hola, " + nombre);
    }
}
