
 # Food Store - Sistema de Gestión de Pedidos de Comida

Este proyecto consiste en un sistema de consola desarrollado en **Java** utilizando el paradigma de **Programación Orientada a Objetos (POO)**. Permite la administración integral de categorías, productos, usuarios y pedidos en un entorno simulado de comercio de comidas.

## 🚀 Alcance y Arquitectura
* **Capa de Modelo (Entities):** Modelado consistente mediante herencia de una clase abstracta común `Base`, asegurando consistencia e identidades atómicas (`id` y baja lógica por `eliminado`).
* **Capa de Servicio (Service):** Manejo seguro de lógica transaccional y operaciones en memoria mediante Colecciones (`ArrayList`). Implementa control de consistencia de stocks ante excepciones.
* **Interfaz de Consola (Main):** Menú iterativo estructurado con robustas validaciones de entrada de datos contra errores de tipo de dato.

## 🛠️ Tecnologías Utilizadas
* **Lenguaje:** Java (JDK 17 o superior)
* **IDE Recomendado:** NetBeans 17+
* **Gestor de Dependencias:** Maven / Ant nativo de NetBeans
* **Control de Versiones:** Git
