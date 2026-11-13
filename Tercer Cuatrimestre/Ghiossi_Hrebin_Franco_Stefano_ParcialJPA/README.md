# Parcial 2 – Programación III: JPA (Repositorios y ABM de Categorías y Productos)

## Descripción

Extensión del proyecto Gradle del TP de la Unidad 8 (JPA + Hibernate 6 + H2 en archivo).
Se agregaron repositorios para `Categoria` y `Producto` y un menú de consola que permite:

- **ABM de Categorías**: alta, modificación, baja lógica y listado.
- **ABM de Productos**: alta (asociado a una categoría), modificación, baja lógica y listado.
- **Reportes**: consulta JPQL de productos activos por categoría.

Las bajas son siempre lógicas (`eliminado = true`); nunca se usa `remove()`.

### Archivos nuevos

| Archivo | Responsabilidad |
|---|---|
| `repository/BaseRepository.java` | CRUD genérico: `guardar`, `buscarPorId`, `listarActivos`, `eliminarLogico` |
| `repository/CategoriaRepository.java` | `buscarProductosPorCategoria` (JPQL con JOIN `c.productos`) y `agregarProducto` |
| `repository/ProductoRepository.java` | Hereda el CRUD de `BaseRepository<Producto>` |
| `Main.java` | Menú de consola |

No se modificó ninguna clase del TP base (entidades, enums, `JPAUtil`, `persistence.xml`).
Único cambio de configuración: en `build.gradle`, `mainClass` apunta a `com.tp.jpa.Main` y
la tarea `run` redirige la entrada estándar para poder leer del teclado.

## Cómo ejecutarlo

Requisitos: JDK 17 o superior y Gradle (o el wrapper, si se usa).

```bash
cd tp-jpa
gradle run
```

Con `gradle --console=plain run` se ve mejor el menú. La base H2 se crea en `./data/jpa_db`.
Hibernate imprime el SQL en consola (`show_sql=true` en `persistence.xml`), por lo que
se mezcla con el menú.

Orden sugerido para probar: crear 2 categorías → crear productos → listar → reporte
"Productos por categoría" → baja lógica de un producto → repetir el reporte.
