package ej3b;

public class Main {
    public static void main(String[] args) {
        UsuarioLombok usuario1 = UsuarioLombok.builder()
                .nombre("Juan Pérez")
                .apellido("García")
                .email("juan@mail.com")
                .telefono("1155443322")
                .build();

        UsuarioLombok usuario2 = UsuarioLombok.builder()
                .nombre("María")
                .email("maria@empresa.com")
                .build();

        System.out.println(usuario1);
        System.out.println(usuario2);
    }
}

/*
 ===================================================================================
 COMENTARIO OBLIGATORIO - EJERCICIO 3 PARTE B
 ===================================================================================
 1. ¿Qué diferencia existe entre la cantidad de código necesaria para definir Usuario en la Parte A y UsuarioLombok en la Parte B?
    - En la Parte A se requirieron más de 50 líneas de código para implementar la clase, constructor privado, getters, toString y la clase interna Builder manual[cite: 20, 24, 31]. En la Parte B, la clase UsuarioLombok tiene apenas 10 líneas gracias a que Lombok automatiza toda la infraestructura mediante las anotaciones @Builder y @ToString[cite: 17, 20, 21].

 2. ¿Qué elementos del patrón Builder genera automáticamente la anotación @Builder?
    - Genera automáticamente en tiempo de compilación la clase interna estática (UsuarioLombokBuilder), sus atributos privados, el constructor privado en la clase principal, los métodos fluidos para cada atributo que devuelven 'this' y el método build() que instancia el objeto final[cite: 17, 20, 25].

 3. ¿Cuándo resulta conveniente utilizar el patrón Builder en lugar de un constructor con todos los parámetros? Mencioná al menos dos situaciones concretas:
    - Situación 1: Cuando una clase posee múltiples atributos (4 o más) y varios de ellos son opcionales[cite: 17, 18, 20, 28]. Permite instanciar el objeto pasando únicamente los datos requeridos sin necesidad de crear múltiples constructores telescópicos ni pasar valores null explícitos[cite: 18, 20].
    - Situación 2: Para evitar errores de orden al invocar constructores que reciben muchos parámetros del mismo tipo (por ejemplo, múltiples parámetros String como nombre, apellido, email, telefono)[cite: 17, 18, 20]. La sintaxis fluida nombra explícitamente cada campo durante la construcción, haciendo el código más seguro y legible[cite: 17, 18, 20].
 ===================================================================================
*/