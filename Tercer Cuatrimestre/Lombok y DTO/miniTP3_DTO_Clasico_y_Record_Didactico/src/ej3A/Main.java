package ej3a;

public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario.Builder()
                .nombre("Juan Pérez")
                .apellido("García")
                .email("juan@mail.com")
                .telefono("1155443322")
                .build();

        Usuario usuario2 = new Usuario.Builder()
                .nombre("María")
                .email("maria@empresa.com")
                .build();

        System.out.println(usuario1);
        System.out.println(usuario2);
    }
}

/*
 ===================================================================================
 COMENTARIO OBLIGATORIO - EJERCICIO 3 PARTE A
 ===================================================================================
 1. ¿Cuántas líneas de código ocupa aproximadamente la clase interna Builder?
    - La clase interna estática Builder ocupa aproximadamente entre 30 y 35 líneas de código (incluyendo la declaración de sus atributos, los métodos fluidos que retornan 'this' y el método build())[cite: 20, 24, 31].

 2. Si fuera necesario agregar un quinto atributo llamado direccion, ¿qué partes de la implementación deberían modificarse?
    - Declarar el campo 'private String direccion;' en la clase principal Usuario.
    - Asignar 'this.direccion = builder.direccion;' dentro del constructor privado de Usuario.
    - Incluir el atributo 'direccion' en la cadena devuelta por el método toString() de Usuario.
    - Declarar el campo 'private String direccion;' dentro de la clase interna estática Builder.
    - Crear el método fluido 'public Builder direccion(String direccion)' dentro de Builder.

 3. ¿En cuántos lugares distintos habría que realizar esos cambios?
    - En 5 lugares distintos dentro del archivo Usuario.java[cite: 20, 25].
 ===================================================================================
*/