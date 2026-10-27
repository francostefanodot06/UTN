package ej3a;

public class Main {
    public static void main(String[] args) {
        // Solicitud de registro recibida (id y fechaCreacion en null)[cite: 26, 27]
        UsuarioDTO solicitud = new UsuarioDTO(null, "Carlos Ruiz", "cruiz@mail.com", "Secr3t!", null);

        // Respuesta enviada al cliente (con id y fechaCreacion generados)[cite: 27]
        UsuarioDTO respuesta = new UsuarioDTO(1L, "Carlos Ruiz", "cruiz@mail.com", "Secr3t!", "2024-05-15");

        System.out.println("[Solicitud de registro recibida]");
        System.out.println(solicitud);
        System.out.println("[Respuesta enviada al cliente]");
        System.out.println(respuesta);
    }
}

/*
COMENTARIOS OBLIGATORIOS - EJERCICIO 3 (PARTE A):
1. ¿Qué campo sensible aparece en la respuesta y no debería enviarse al cliente?
   - El campo `password`, ya que exponer contraseñas (aunque estén hasheadas) en las respuestas de la API es una falla crítica de seguridad[cite: 21, 27].
2. ¿Qué atributos de UsuarioDTO no tienen sentido en una solicitud de registro?
   - Los atributos `id` y `fechaCreacion`, puesto que son datos automáticos generados por el servidor al momento de persistir y no deben ser enviados por el cliente[cite: 23, 27].
3. ¿Por qué utilizar la misma clase para representar la solicitud y la respuesta puede generar problemas?
   - Obliga a manejar valores `null` innecesarios y expone campos sensibles o de control interno que deberían estar estrictamente protegidos en un sentido u otro[cite: 21, 31].
*/