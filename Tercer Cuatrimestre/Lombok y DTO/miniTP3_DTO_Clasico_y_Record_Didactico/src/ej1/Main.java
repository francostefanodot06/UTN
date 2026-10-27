package ej1;

public class Main {
    public static void main(String[] args) {
        ProductoRecordDto producto = new ProductoRecordDto(1L, "Auriculares Bluetooth", 45000.0);

        System.out.println("Nombre: " + producto.nombre());
        System.out.println("Precio: " + producto.precio());
        System.out.println("DTO completo: " + producto);
    }
}

/*
 ===================================================================================
 COMENTARIO OBLIGATORIO - EJERCICIO 1
 ===================================================================================
 1. ¿Cuáles son los cuatro elementos principales que el compilador genera automáticamente al declarar un record?
    - El constructor canónico con todos los componentes como parámetros[cite: 19].
    - Los métodos accesores (accessors) públicos e inmutables para cada componente (con el mismo nombre del campo, sin prefijo 'get')[cite: 19].
    - El método toString() con el formato estandarizado ClassName[campo=valor, ...][cite: 19, 20].
    - Los métodos equals() y hashCode() basados en la comparación por valor de todos sus componentes[cite: 19].

 2. ¿Por qué el accessor del componente nombre se llama nombre() y no getNombre()?
    - Porque los records en Java no siguen la convención JavaBean tradicional de getters/setters mutables[cite: 19, 26, 29]. Representan datos puros e inmutables[cite: 17, 19, 29], por lo que utilizan accesores basados en el nombre exacto del componente para ofrecer una sintaxis más concisa y directa[cite: 17, 19].

 3. ¿Qué diferencia presenta el formato de toString() de un record respecto del de un POJO?
    - El toString() autogenerado por un record utiliza obligatoriamente el formato definido por Java: ClassName[campo1=valor1, campo2=valor2] (utiliza corchetes '[]' y no incluye comillas simples alrededor de los valores de tipo String)[cite: 19, 20, 26]. En un POJO tradicional, el toString() se sobrescribe manualmente utilizando habitualmente llaves '{}' e incluyendo comillas alrededor de los textos[cite: 19, 26].
 ===================================================================================
*/