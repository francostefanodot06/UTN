# Trabajo Práctico N° 6: Colecciones y Relaciones entre Clases
 Este proyecto corresponde al Trabajo Práctico N° 6 de la **Tecnicatura Universitaria en Programación (UTN)**. En él se abordan de manera progresiva el uso de estructuras dinámicas, enumeraciones y el diseño de relaciones complejas entre objetos utilizando **Java**.

---

## 🚀 Objetivo General
Desarrollar estructuras de datos dinámicas en Java mediante el uso de colecciones (`ArrayList`) y enumeraciones (`enum`), implementando sistemas con funcionalidades progresivas que refuerzan conceptos clave de la programación orientada a objetos (POO).

---

## 📂 Estructura del Proyecto

El proyecto está organizado de forma modular en tres paquetes principales, resolviendo problemas de negocio independientes:

### 🔹 Ejercicio 1: Sistema de Gestión de Inventario (`Ejercicio_01`)
Un sistema para controlar el stock de una tienda, gestionando la disponibilidad, precios y categorías fijas de los productos.
* **Conceptos Clave:** Encapsulamiento, ciclo *for-each*, colecciones dinámicas y atributos/métodos estáticos.
* **Uso de `enum` con métodos:** Se modeló la categoría del producto incluyendo descripciones personalizadas dentro del enumerador:
    * `ALIMENTOS` ("Productos comestibles")
    * `ELECTRONICA` ("Dispositivos electrónicos")
    * `ROPA` ("Prendas de vestir")
    * `HOGAR` ("Artículos para el hogar")
* **Funcionalidades del Inventario:** Alta, baja, búsqueda por ID, actualización de stock, reportes analíticos (producto con mayor stock, totalización de unidades) y filtrado avanzado por rango de precios o categorías.

### 🔹 Ejercicio 2: Administración de Biblioteca (`Ejercicio_02`)
Modelado de un sistema de catálogo de libros asociados a sus respectivos autores.
* **Conceptos Clave:** Relación de **Composición 1 a N**.
* **Regla de Negocio Estricta:** Un libro pertenece obligatoriamente a una biblioteca y su ciclo de vida está ligado a ella. Si la biblioteca se elimina, también se eliminan sus libros. La instanciación de un `Libro` ocurre de forma interna dentro de los métodos de la `Biblioteca`.
* **Funcionalidades:** Listar catálogo detallado (incluyendo datos de autores), búsquedas por ISBN, filtrado por año de publicación y listado único de autores disponibles.

### 🔹 Ejercicio 3: Sistema Académico Universitario (`Ejercicio_03`)
Modelado de la relación bidireccional entre profesores y los cursos asignados dentro de una universidad.
* **Conceptos Clave:** **Relación Bidireccional** e **Invariante de Asociación**.
* **Sincronización Segura:** Cada vez que se asigna, cambia o remueve el profesor de un curso, el sistema actualiza automáticamente ambos extremos de la relación en memoria para evitar inconsistencias de datos o bucles infinitos de referencias cruzadas.
* **Funcionalidades:** Alta y baja de profesores/cursos en la administración central de la `Universidad`, reasignación dinámica de docentes, desvinculación segura (limpieza de referencias a `null`) y reportes analíticos de carga horaria (cantidad de cursos por profesor).


## 📈 Conclusiones Aprendidas en este TP
1.  **Uso de `this` y Sobrecarga:** Claridad en el acceso a atributos de instancia y flexibilidad al inicializar objetos con múltiples constructores.
2.  **Modularidad y Depuración:** Implementación del método `toString()` y métodos específicos de muestra de datos para optimizar los registros en la consola del sistema.
3.  **Relaciones Seguras:** El diseño y control manual de invariantes de asociación bidireccionales, una competencia fundamental para comprender cómo estructurar lógica compleja antes de migrar a frameworks de persistencia (como Hibernate/JPA).
