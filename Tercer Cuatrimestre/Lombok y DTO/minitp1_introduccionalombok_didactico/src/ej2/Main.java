package ej2;

public class Main {
    public static void main(String[] args) {
        Pedido pedido1 = new Pedido(1L, "Compra de insumos", 3200.0);
        Pedido pedido2 = new Pedido(1L, "Compra de insumos", 3200.0);
        Pedido pedido3 = new Pedido(2L, "Mantenimiento", 8750.0);

        System.out.println(pedido1);
        System.out.println(pedido2);
        System.out.println(pedido3);

        System.out.println("pedido1.equals(pedido2): " + pedido1.equals(pedido2));
        System.out.println("pedido1.equals(pedido3): " + pedido1.equals(pedido3));
    }
}

/*
COMENTARIOS OBLIGATORIOS - EJERCICIO 2:
1. ¿Qué resultado habría dado pedido1 == pedido2?
   - Habría dado `false`.

2. ¿Por qué el resultado obtenido con == es diferente del obtenido con equals()?
   - El operador `==` compara las referencias en memoria (si apuntan exactamente al mismo objeto físico en el heap). Como `pedido1` y `pedido2` son dos instancias distintas creadas con `new` en diferentes espacios de memoria, `==` retorna falso aunque sus atributos tengan los mismos valores. En cambio, el método `equals()` sobrescrito por Lombok compara el contenido (valor por valor de sus atributos)[cite: 3].

3. ¿Qué habría devuelto equals() si no hubieras agregado @EqualsAndHashCode?
   - Habría devuelto `false` al comparar `pedido1` y `pedido2`, ya que Java habría utilizado por defecto el método `equals()` heredado de la clase `Object`, el cual evalúa igualdad de referencias de la misma manera que el operador `==`[cite: 3, 7].
*/