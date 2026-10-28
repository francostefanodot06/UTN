# TP Integrador: Lombok y DTO

## Estructura y Decisiones Tomadas
1. **Gradle**: Se configuró el proyecto utilizando dependencias de Lombok en `build.gradle` (`compileOnly` y `annotationProcessor`).
2. **Lombok**: Se utilizó `@SuperBuilder` en todas las entidades ya que existe herencia desde la clase abstracta `Base`. Esto permite instanciar objetos heredados mediante el patrón Builder de manera limpia.
3. **Colecciones Set**: Para garantizar el correcto comportamiento del `Set` y evitar duplicados, la identidad de los objetos fue definida exclusivamente por el atributo `id` en la clase `Base`, utilizando `@EqualsAndHashCode(onlyExplicitlyIncluded = true)`.
4. **DTO (Data Transfer Object)**: Se creó `UsuarioDTO` mediante un `record` de Java. Esto garantiza la inmutabilidad y facilita la transferencia de datos excluyendo los atributos sensibles requeridos por la consigna (rol y contraseña).
