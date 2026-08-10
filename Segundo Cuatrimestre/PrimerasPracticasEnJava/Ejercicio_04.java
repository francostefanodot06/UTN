import java.util.Scanner;

// ==========================================
// EJERCICIO 04: Operadores Aritméticos
// ==========================================
public class Ejercicio_04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese el primer número entero:");
        int num1 = Integer.parseInt(input.nextLine());

        System.out.println("Ingrese el segundo número entero:");
        int num2 = Integer.parseInt(input.nextLine());

        // Las expresiones matemáticas se encierran en paréntesis para forzar la
        // prioridad y separar la concatenación de texto de la operación real.
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));

        // Nota: Al dividir enteros, Java descarta los decimales.
        // Lo solucionaremos de forma explícita en el Ejercicio 06.
        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
    }
}
