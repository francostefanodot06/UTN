package com.tp.jpa;

import com.tp.jpa.model.Categoria;
import com.tp.jpa.model.Producto;
import com.tp.jpa.repository.CategoriaRepository;
import com.tp.jpa.repository.ProductoRepository;
import com.tp.jpa.util.JPAUtil;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Menú de consola para el ABM de Categorías y Productos y la consulta JPQL de reportes.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final CategoriaRepository categoriaRepo = new CategoriaRepository();
    private static final ProductoRepository productoRepo = new ProductoRepository();

    public static void main(String[] args) {
        try {
            boolean salir = false;
            while (!salir) {
                System.out.println("\n===== MENÚ PRINCIPAL =====");
                System.out.println("1. Gestionar Categorías");
                System.out.println("2. Gestionar Productos");
                System.out.println("3. Reportes");
                System.out.println("0. Salir");
                switch (leerOpcion()) {
                    case 1 -> menuCategorias();
                    case 2 -> menuProductos();
                    case 3 -> menuReportes();
                    case 0 -> salir = true;
                    default -> System.out.println("Opción inválida.");
                }
            }
        } finally {
            JPAUtil.close();
            System.out.println("Hasta luego.");
        }
    }

    // ------------------------------------------------------------------
    // Categorías
    // ------------------------------------------------------------------

    private static void menuCategorias() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- GESTIÓN DE CATEGORÍAS ---");
            System.out.println("1. Alta");
            System.out.println("2. Modificar");
            System.out.println("3. Baja lógica");
            System.out.println("4. Listado");
            System.out.println("0. Volver");
            switch (leerOpcion()) {
                case 1 -> altaCategoria();
                case 2 -> modificarCategoria();
                case 3 -> bajaCategoria();
                case 4 -> listarCategorias();
                case 0 -> volver = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void altaCategoria() {
        String nombre = leerTexto("Nombre (obligatorio): ");
        if (nombre.isEmpty()) {
            System.out.println("Error: el nombre no puede estar vacío.");
            return;
        }
        String descripcion = leerTexto("Descripción (opcional): ");

        Categoria categoria = Categoria.builder()
                .nombre(nombre)
                .descripcion(descripcion.isEmpty() ? null : descripcion)
                .build();
        // El ID se lee del objeto RETORNADO por guardar()
        Categoria guardada = categoriaRepo.guardar(categoria);
        System.out.println("Categoría creada con ID: " + guardada.getId());
    }

    private static void modificarCategoria() {
        if (!listarCategorias()) {
            return;
        }
        Long id = leerLong("ID de la categoría a modificar: ");
        Optional<Categoria> opt = id == null ? Optional.empty() : categoriaRepo.buscarPorId(id);
        if (opt.isEmpty() || opt.get().isEliminado()) {
            System.out.println("Error: no existe una categoría activa con ese ID.");
            return;
        }
        Categoria categoria = opt.get();
        System.out.println("Nombre actual: " + categoria.getNombre());
        System.out.println("Descripción actual: " + valorOVacio(categoria.getDescripcion()));

        String nombre = leerTexto("Nuevo nombre (Enter para conservar): ");
        String descripcion = leerTexto("Nueva descripción (Enter para conservar): ");
        if (!nombre.isEmpty()) {
            categoria.setNombre(nombre);
        }
        if (!descripcion.isEmpty()) {
            categoria.setDescripcion(descripcion);
        }
        categoriaRepo.guardar(categoria);
        System.out.println("Categoría modificada correctamente.");
    }

    private static void bajaCategoria() {
        Long id = leerLong("ID de la categoría a dar de baja: ");
        Optional<Categoria> opt = id == null ? Optional.empty() : categoriaRepo.buscarPorId(id);
        if (opt.isEmpty() || opt.get().isEliminado()) {
            System.out.println("Error: categoría no encontrada o ya dada de baja.");
            return;
        }
        String nombre = opt.get().getNombre();

        int activos = categoriaRepo.buscarProductosPorCategoria(id).size();
        if (activos > 0) {
            System.out.println("Error: la categoría '" + nombre + "' tiene " + activos
                    + " producto(s) activo(s). Primero deben darse de baja sus productos.");
            return;
        }
        if (categoriaRepo.eliminarLogico(id)) {
            System.out.println("Categoría '" + nombre + "' dada de baja correctamente.");
        } else {
            System.out.println("Error: categoría no encontrada o ya dada de baja.");
        }
    }

    /** Lista las categorías activas. Retorna false si no hay ninguna. */
    private static boolean listarCategorias() {
        List<Categoria> categorias = categoriaRepo.listarActivos();
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías activas.");
            return false;
        }
        System.out.println("\nCategorías activas:");
        for (Categoria c : categorias) {
            System.out.println("  ID: " + c.getId() + " | Nombre: " + c.getNombre()
                    + " | Descripción: " + valorOVacio(c.getDescripcion()));
        }
        return true;
    }

    // ------------------------------------------------------------------
    // Productos
    // ------------------------------------------------------------------

    private static void menuProductos() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- GESTIÓN DE PRODUCTOS ---");
            System.out.println("1. Alta");
            System.out.println("2. Modificar");
            System.out.println("3. Baja lógica");
            System.out.println("4. Listado");
            System.out.println("0. Volver");
            switch (leerOpcion()) {
                case 1 -> altaProducto();
                case 2 -> modificarProducto();
                case 3 -> bajaProducto();
                case 4 -> listarProductos();
                case 0 -> volver = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void altaProducto() {
        if (!listarCategorias()) {
            System.out.println("Error: debe existir al menos una categoría activa para crear productos.");
            return;
        }
        Long idCategoria = leerLong("ID de la categoría: ");
        if (idCategoria == null) {
            System.out.println("Error: ID inválido.");
            return;
        }
        Optional<Categoria> optCat = categoriaRepo.buscarPorId(idCategoria);
        if (optCat.isEmpty() || optCat.get().isEliminado()) {
            System.out.println("Error: no existe una categoría activa con ese ID.");
            return;
        }

        String nombre = leerTexto("Nombre (obligatorio): ");
        if (nombre.isEmpty()) {
            System.out.println("Error: el nombre no puede estar vacío.");
            return;
        }
        String descripcion = leerTexto("Descripción (opcional): ");

        Double precio = parsearDouble(leerTexto("Precio (mayor a 0): "));
        if (precio == null || precio <= 0) {
            System.out.println("Error: el precio debe ser un número mayor a 0. No se guardó el producto.");
            return;
        }
        Integer stock = parsearInt(leerTexto("Stock (mayor o igual a 0): "));
        if (stock == null || stock < 0) {
            System.out.println("Error: el stock debe ser un entero mayor o igual a 0. No se guardó el producto.");
            return;
        }
        String imagen = leerTexto("Imagen (opcional): ");
        String disp = leerTexto("¿Disponible? (S/N, por defecto S): ");
        boolean disponible = !disp.equalsIgnoreCase("N");

        Producto producto = Producto.builder()
                .nombre(nombre)
                .descripcion(descripcion.isEmpty() ? null : descripcion)
                .precio(precio)
                .stock(stock)
                .imagen(imagen.isEmpty() ? null : imagen)
                .disponible(disponible)
                .build();

        try {
            Producto guardado = categoriaRepo.agregarProducto(idCategoria, producto);
            System.out.println("Producto creado con ID: " + guardado.getId()
                    + " en la categoría '" + optCat.get().getNombre() + "' (ID " + idCategoria + ").");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void modificarProducto() {
        List<Producto> activos = productoRepo.listarActivos();
        if (activos.isEmpty()) {
            System.out.println("No hay productos activos.");
            return;
        }
        System.out.println("\nProductos activos:");
        for (Producto p : activos) {
            System.out.println("  ID: " + p.getId() + " | " + p.getNombre()
                    + " | $" + p.getPrecio() + " | stock: " + p.getStock());
        }

        Long id = leerLong("ID del producto a modificar: ");
        Optional<Producto> opt = id == null ? Optional.empty() : productoRepo.buscarPorId(id);
        if (opt.isEmpty() || opt.get().isEliminado()) {
            System.out.println("Error: no existe un producto activo con ese ID.");
            return;
        }
        Producto producto = opt.get();
        System.out.println("Nombre actual: " + producto.getNombre());
        System.out.println("Precio actual: " + producto.getPrecio());
        System.out.println("Stock actual: " + producto.getStock());

        String nombre = leerTexto("Nuevo nombre (Enter para conservar): ");
        String precioTxt = leerTexto("Nuevo precio (Enter para conservar): ");
        String stockTxt = leerTexto("Nuevo stock (Enter para conservar): ");

        Double nuevoPrecio = null;
        if (!precioTxt.isEmpty()) {
            nuevoPrecio = parsearDouble(precioTxt);
            if (nuevoPrecio == null || nuevoPrecio <= 0) {
                System.out.println("Error: el precio debe ser un número mayor a 0. No se guardaron cambios.");
                return;
            }
        }
        Integer nuevoStock = null;
        if (!stockTxt.isEmpty()) {
            nuevoStock = parsearInt(stockTxt);
            if (nuevoStock == null || nuevoStock < 0) {
                System.out.println("Error: el stock debe ser un entero mayor o igual a 0. No se guardaron cambios.");
                return;
            }
        }

        if (!nombre.isEmpty()) {
            producto.setNombre(nombre);
        }
        if (nuevoPrecio != null) {
            producto.setPrecio(nuevoPrecio);
        }
        if (nuevoStock != null) {
            producto.setStock(nuevoStock);
        }
        productoRepo.guardar(producto);
        System.out.println("Producto modificado correctamente.");
    }

    private static void bajaProducto() {
        Long id = leerLong("ID del producto a dar de baja: ");
        if (id == null) {
            System.out.println("Error: ID inválido.");
            return;
        }
        // Se obtiene el nombre antes de la baja para poder mostrarlo en la confirmación
        String nombre = productoRepo.buscarPorId(id).map(Producto::getNombre).orElse(null);
        if (productoRepo.eliminarLogico(id)) {
            System.out.println("Producto '" + nombre + "' dado de baja correctamente.");
        } else {
            System.out.println("Error: producto no encontrado o ya dado de baja.");
        }
    }

    private static void listarProductos() {
        List<Categoria> categorias = categoriaRepo.listarActivos();
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías activas.");
            return;
        }
        boolean hayProductos = false;
        for (Categoria c : categorias) {
            for (Producto p : categoriaRepo.buscarProductosPorCategoria(c.getId())) {
                hayProductos = true;
                String estado = Boolean.TRUE.equals(p.getDisponible()) ? "Disponible" : "No disponible";
                System.out.println("ID: " + p.getId() + " | " + p.getNombre()
                        + " | Precio: $" + p.getPrecio() + " | Stock: " + p.getStock()
                        + " | " + estado + " | Categoría: " + c.getNombre());
            }
        }
        if (!hayProductos) {
            System.out.println("No hay productos activos.");
        }
    }

    // ------------------------------------------------------------------
    // Reportes
    // ------------------------------------------------------------------

    private static void menuReportes() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- REPORTES ---");
            System.out.println("1. Productos por categoría");
            System.out.println("0. Volver");
            switch (leerOpcion()) {
                case 1 -> reporteProductosPorCategoria();
                case 0 -> volver = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void reporteProductosPorCategoria() {
        if (!listarCategorias()) {
            return;
        }
        Long id = leerLong("ID de la categoría: ");
        Optional<Categoria> opt = id == null ? Optional.empty() : categoriaRepo.buscarPorId(id);
        if (opt.isEmpty() || opt.get().isEliminado()) {
            System.out.println("Error: no existe una categoría activa con ese ID.");
            return;
        }
        List<Producto> productos = categoriaRepo.buscarProductosPorCategoria(id);
        if (productos.isEmpty()) {
            System.out.println("La categoría '" + opt.get().getNombre() + "' no tiene productos activos.");
            return;
        }
        System.out.println("\nProductos activos de '" + opt.get().getNombre() + "':");
        for (Producto p : productos) {
            System.out.println("  ID: " + p.getId() + " | Nombre: " + p.getNombre()
                    + " | Precio: $" + p.getPrecio() + " | Stock: " + p.getStock());
        }
    }

    // ------------------------------------------------------------------
    // Utilidades de entrada
    // ------------------------------------------------------------------

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        if (!scanner.hasNextLine()) { // fin de la entrada: cerrar limpiamente
            JPAUtil.close();
            System.exit(0);
        }
        return scanner.nextLine().trim();
    }

    private static int leerOpcion() {
        Integer opcion = parsearInt(leerTexto("Opción: "));
        return opcion == null ? -1 : opcion;
    }

    private static Long leerLong(String mensaje) {
        try {
            return Long.parseLong(leerTexto(mensaje));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static Integer parsearInt(String texto) {
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static Double parsearDouble(String texto) {
        try {
            return Double.parseDouble(texto.replace(',', '.'));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static String valorOVacio(String valor) {
        return valor == null || valor.isEmpty() ? "(sin descripción)" : valor;
    }
}
