import java.util.Scanner;

// ==========================================
// EJERCICIO 03: Entrada de Datos Segura
// ==========================================
public class Ejercicio_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declaración (reserva de memoria)
        String nombre;
        int edad;

        System.out.println("Ingrese su nombre:");
        // Leemos texto puro
        nombre = input.nextLine();

        System.out.println("Ingrese su edad:");
        // ESTRATEGIA PROFESIONAL: Siempre leemos como String usando nextLine()
        // y luego convertimos (parseamos) al tipo numérico deseado.
        // Esto evita que quede un salto de línea (\n) flotando en el buffer.
        edad = Integer.parseInt(input.nextLine());

        System.out.println("Datos ingresados -> Nombre: " + nombre + " | Edad: " + edad);
    }
}
