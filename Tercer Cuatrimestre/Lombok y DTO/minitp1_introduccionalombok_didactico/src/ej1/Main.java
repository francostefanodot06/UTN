package ej1;

public class Main {
    public static void main(String[] args) {
        // Primer objeto usando constructor sin parámetros y setters
        Producto producto1 = new Producto();
        producto1.setId(1L);
        producto1.setNombre("Notebook");
        producto1.setPrecio(1500.0);

        // Modificar el nombre usando el setter correspondiente
        producto1.setNombre("Auriculares Bluetooth");
        System.out.println(producto1);

        // Segundo objeto usando el constructor con todos los parámetros
        Producto producto2 = new Producto(2L, "Mouse", 800.0);
        System.out.println(producto2);
    }
}

/*
COMENTARIOS OBLIGATORIOS - EJERCICIO 1:
1. ¿Qué código genera cada una de las cinco anotaciones utilizadas?
   - @NoArgsConstructor: Genera un constructor vacío (sin parámetros): public Producto() {}.
   - @AllArgsConstructor: Genera un constructor con un parámetro por cada campo de la clase: public Producto(Long id, String nombre, Double precio) {}[cite: 2].
   - @Getter: Genera los métodos de acceso getX() para cada uno de los atributos de la clase[cite: 3].
   - @Setter: Genera los métodos de modificación setX(...) para cada uno de los atributos[cite: 3].
   - @ToString: Genera el método toString() que incluye en formato de texto el nombre de la clase y el valor de todos sus atributos[cite: 3].

2. ¿Cuál es la diferencia entre @NoArgsConstructor y @AllArgsConstructor?
   - La diferencia radica en la cantidad de parámetros que recibe el constructor generado. @NoArgsConstructor no recibe ninguno (permite instanciar el objeto vacíos, algo útil para frameworks como Spring), mientras que @AllArgsConstructor exige pasarle valores para todos los atributos en el orden en que fueron declarados al momento de crear la instancia[cite: 2].

3. ¿Qué ocurriría si eliminaras la anotación @ToString y luego ejecutaras System.out.println(producto)?
   - Se imprimiría la representación por defecto heredada de la clase Object de Java, que muestra el nombre de la clase seguido de una arroba y el código hash en hexadecimal (por ejemplo: ej1.Producto@3764951d), en lugar de mostrar los valores de los atributos[cite: 7].
*/