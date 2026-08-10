// ==========================================
// EJERCICIO 02: Variables y lowerCamelCase
// ==========================================
public class Ejercicio_02 {
    public static void main(String[] args) {
        // String va con Mayúscula porque es un Objeto (Clase), no un primitivo.
        String nombreAlumno = "Jeronimo Cortez";

        // int, double y boolean van en minúscula (son primitivos).
        // Usamos la convención lowerCamelCase para los nombres.
        int edad = 22;
        double altura = 1.83;
        boolean esEstudiante = false;

        // Imprimimos el estado de las variables inicializadas.
        System.out.println("Nombre: " + nombreAlumno);
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura);
        System.out.println("¿Es estudiante?: " + esEstudiante);
    }
}
