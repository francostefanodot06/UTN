package ej3b;

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
COMENTARIOS OBLIGATORIOS - EJERCICIO 3 (PARTE B):
1. Comparación entre implementaciones y ventajas de Lombok:
   - La implementación manual exige escribir de forma tediosa constructores, getters, setters y sobreescrituras de métodos, lo que incrementa las posibilidades de cometer errores humanos y dificulta la lectura del código. En contraste, Lombok reduce drásticamente las líneas de código mediante anotaciones limpias, delegando la generación del bytecode al compilador de forma automática y transparente.

2. ¿En qué situaciones utilizarías @EqualsAndHashCode y en cuáles @EqualsAndHashCode(of = "id")?
   - @EqualsAndHashCode genérico (sin parámetros) se utiliza cuando todos los campos de una entidad son relevantes para determinar si dos objetos son exactamente idénticos (por ejemplo, en objetos de valor o DTOs simples).
   - @EqualsAndHashCode(of = "id") se utiliza en entidades de persistencia o modelos donde existe una clave de negocio o identificador único (como un ID de base de datos), permitiendo que dos instancias se consideren equivalentes por su identidad principal aunque algunos de sus atributos no clave (como el correo o teléfono) hayan cambiado[cite: 8].
*/