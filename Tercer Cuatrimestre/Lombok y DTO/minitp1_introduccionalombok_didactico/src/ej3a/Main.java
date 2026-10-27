package ej3a;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1L, "María García", "mgarcia@mail.com", "123456");
        Cliente cliente2 = new Cliente(1L, "María García", "mgc@empresa.com", "abcdef");

        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println("¿Son iguales? " + cliente1.equals(cliente2));
    }
}

/*
COMENTARIOS OBLIGATORIOS - EJERCICIO 3 (PARTE A):
1. ¿Cuántas líneas de código ocuparon todos los métodos escritos manualmente?
   - La implementación manual requirió aproximadamente unas 50 a 60 líneas de código repetitivo (boilerplates) solo para definir constructores, accesores, toString, equals y hashCode.

2. ¿Qué problema podría generar incluir el campo password dentro de toString()?
   - Representa un grave riesgo de seguridad. Al imprimir objetos en los logs del servidor (por consola o archivos de registro), la contraseña del usuario quedaría expuesta en texto plano, facilitando vulnerabilidades de acceso no autorizado.
*/