package ej1;

public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
        Libro libro2 = new Libro("Rayuela", "Julio Cortázar", 1963);

        // Se imprimen directamente sin llamar explícitamente a .toString()
        System.out.println(libro1);
        System.out.println(libro2);
    }
}
