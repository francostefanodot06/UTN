package ej3b;

public class Main {
    public static void main(String[] args) {
        RegistroRequestDTO request = new RegistroRequestDTO("Carlos Ruiz", "cruiz@mail.com", "Secr3t!");
        UsuarioResponseDTO response = new UsuarioResponseDTO(1L, "Carlos Ruiz", "cruiz@mail.com", "2024-05-15");

        System.out.println("[Solicitud de registro recibida]");
        System.out.println(request);
        System.out.println("[Respuesta enviada al cliente]");
        System.out.println(response);
    }
}

/*
COMENTARIOS OBLIGATORIOS - EJERCICIO 3 (PARTE B):
1. ¿Qué problema de seguridad se resolvió al separar los DTOs?
   - Se evitó la exposición de la contraseña en las respuestas del servidor y se previno que el cliente manipule campos de control interno como el `id` o la `fechaCreacion` al registrarse[cite: 21, 23, 28].
2. ¿Por qué RegistroRequestDTO no incluye id ni fechaCreacion?
   - Porque son generados de forma exclusiva por el backend al procesar y almacenar la información, por lo que el cliente no debe ni tiene por qué enviarlos[cite: 23, 28].
3. ¿Por qué UsuarioResponseDTO no incluye password?
   - Porque el campo de la contraseña es información altamente sensible que nunca debe retornar al cliente por razones elementales de seguridad[cite: 21, 28].
4. Si el servidor incorpora el atributo apellido en la información del perfil que devuelve al cliente, ¿cuál de los dos DTOs debería modificarse? Justificá tu respuesta.
   - Se debería modificar únicamente el `UsuarioResponseDTO`, ya que es el contrato encargado exclusivamente de formatear y estructurar la información de salida que recibe el cliente[cite: 23, 28].
*/