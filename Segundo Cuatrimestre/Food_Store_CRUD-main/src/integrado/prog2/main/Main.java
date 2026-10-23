/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.main;
import integrado.prog2.entities.Categoria;
import integrado.prog2.entities.Pedido;
import integrado.prog2.entities.Producto;
import integrado.prog2.entities.Usuario;
import integrado.prog2.enums.Estado;
import integrado.prog2.enums.FormaPago;
import integrado.prog2.enums.Rol;
import integrado.prog2.service.DataStoreService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author franker
 */
public class Main {
    private static DataStoreService service = new DataStoreService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Carga inicial de algunos datos para testear rápido
        precargarDatos();

        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE PEDIDOS (FOOD STORE) ===");
            System.out.println("1. Categorías");
            System.out.println("2. Productos");
            System.out.println("3. Usuarios");
            System.out.println("4. Pedidos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> menuCategorias();
                case 2 -> menuProductos();
                case 3 -> menuUsuarios();
                case 4 -> menuPedidos();
                case 0 -> System.out.println("¡Gracias por utilizar Food Store!");
                default -> System.out.println("Opción incorrecta.");
            }
        } while (opcion != 0);
    }

    private static void precargarDatos() {
        try {
            service.crearCategoria("Hamburguesas", "Variedad de hamburguesas caseras");
            service.crearCategoria("Bebidas", "Gaseosas y aguas");
            service.crearProducto("Completa con papas", 4500.0, "Carne, queso, huevo y jamón", 15, "hamb_completa.png", true, 1L);
            service.crearProducto("Coca Cola 500ml", 1200.0, "Línea regular", 50, "coca.png", true, 2L);
            service.crearUsuario("Juan", "Pérez", "juan@mail.com", "11223344", "1234", Rol.USUARIO);
            service.crearUsuario("Admin", "General", "admin@foodstore.com", "999999", "adminpass", Rol.ADMIN);
        } catch (Exception ignored) {}
    }

    // --- MENÚS CRUD ---

    private static void menuCategorias() {
        int op;
        do {
            System.out.println("\n--- GESTIÓN DE CATEGORÍAS ---");
            System.out.println("1. Listar categorías");
            System.out.println("2. Crear categoría");
            System.out.println("3. Editar categoría");
            System.out.println("4. Eliminar categoría");
            System.out.println("0. Volver al menú principal");
            System.out.print("Opción: ");
            op = leerEntero();

            try {
                switch (op) {
                    case 1 -> {
                        List<Categoria> lista = service.listarCategorias();
                        if (lista.isEmpty()) {
                            System.out.println("No hay categorías cargadas.");
                        } else {
                            lista.forEach(System.out::println);
                        }
                    }
                    case 2 -> {
                        System.out.print("Nombre de categoría: ");
                        String nom = scanner.nextLine();
                        System.out.print("Descripción: ");
                        String desc = scanner.nextLine();
                        service.crearCategoria(nom, desc);
                        System.out.println("¡Categoría creada con éxito!");
                    }
                    case 3 -> {
                        System.out.print("Ingrese ID de categoría a editar: ");
                        Long id = leerLong();
                        System.out.print("Nuevo Nombre (Vacío para mantener): ");
                        String nom = scanner.nextLine();
                        System.out.print("Nueva Descripción (Vacío para mantener): ");
                        String desc = scanner.nextLine();
                        service.editarCategoria(id, nom, desc);
                        System.out.println("¡Categoría modificada con éxito!");
                    }
                    case 4 -> {
                        System.out.print("Ingrese ID de categoría a eliminar (Baja lógica): ");
                        Long id = leerLong();
                        System.out.print("¿Confirmar eliminación? (S/N): ");
                        if (scanner.nextLine().equalsIgnoreCase("S")) {
                            service.eliminarCategoria(id);
                            System.out.println("Categoría eliminada.");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } while (op != 0);
    }

    private static void menuProductos() {
        int op;
        do {
            System.out.println("\n--- GESTIÓN DE PRODUCTOS ---");
            System.out.println("1. Listar productos");
            System.out.println("2. Crear producto");
            System.out.println("3. Editar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = leerEntero();

            try {
                switch (op) {
                    case 1 -> {
                        List<Producto> lista = service.listarProductos();
                        if (lista.isEmpty()) {
                            System.out.println("No hay productos.");
                        } else {
                            lista.forEach(System.out::println);
                        }
                    }
                    case 2 -> {
                        System.out.print("Nombre: "); String nom = scanner.nextLine();
                        System.out.print("Precio: "); double pr = leerDouble();
                        System.out.print("Descripción: "); String ds = scanner.nextLine();
                        System.out.print("Stock inicial: "); int st = leerEntero();
                        System.out.print("Nombre de imagen: "); String img = scanner.nextLine();
                        System.out.print("ID Categoría asociada: "); Long idCat = leerLong();
                        service.crearProducto(nom, pr, ds, st, img, true, idCat);
                        System.out.println("¡Producto añadido!");
                    }
                    case 3 -> {
                        System.out.print("ID del producto a editar: "); Long id = leerLong();
                        System.out.print("Nuevo nombre (Vacío para omitir): "); String nom = scanner.nextLine();
                        System.out.print("Nuevo precio (-1 para omitir): "); double pr = leerDouble();
                        System.out.print("Nueva descripción (Vacío para omitir): "); String ds = scanner.nextLine();
                        System.out.print("Nuevo Stock (-1 para omitir): "); int st = leerEntero();
                        
                        Double precioParam = pr == -1 ? null : pr;
                        Integer stockParam = st == -1 ? null : st;
                        
                        service.editarProducto(id, nom, precioParam, ds, stockParam, null, null, null);
                        System.out.println("Producto modificado.");
                    }
                    case 4 -> {
                        System.out.print("ID a eliminar: "); Long id = leerLong();
                        System.out.print("Confirmar (S/N): ");
                        if (scanner.nextLine().equalsIgnoreCase("S")) {
                            service.eliminarProducto(id);
                            System.out.println("Producto dado de baja.");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } while (op != 0);
    }

    private static void menuUsuarios() {
        int op;
        do {
            System.out.println("\n--- GESTIÓN DE USUARIOS ---");
            System.out.println("1. Listar usuarios");
            System.out.println("2. Crear usuario");
            System.out.println("3. Editar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = leerEntero();

            try {
                switch (op) {
                    case 1 -> {
                        List<Usuario> lista = service.listarUsuarios();
                        if (lista.isEmpty()) {
                            System.out.println("No hay usuarios.");
                        } else {
                            lista.forEach(System.out::println);
                        }
                    }
                    case 2 -> {
                        System.out.print("Nombre: "); String n = scanner.nextLine();
                        System.out.print("Apellido: "); String a = scanner.nextLine();
                        System.out.print("Email (único): "); String m = scanner.nextLine();
                        System.out.print("Celular: "); String c = scanner.nextLine();
                        System.out.print("Contraseña: "); String pass = scanner.nextLine();
                        System.out.println("Seleccione Rol (1. ADMIN, 2. USUARIO): ");
                        Rol r = leerEntero() == 1 ? Rol.ADMIN : Rol.USUARIO;
                        service.crearUsuario(n, a, m, c, pass, r);
                        System.out.println("Usuario registrado correctamente.");
                    }
                    case 3 -> {
                        System.out.print("ID de usuario a editar: "); Long id = leerLong();
                        System.out.print("Nuevo Email (Vacío para omitir): "); String m = scanner.nextLine();
                        System.out.print("Nuevo Celular (Vacío para omitir): "); String c = scanner.nextLine();
                        service.editarUsuario(id, null, null, m, c, null, null);
                        System.out.println("Usuario modificado.");
                    }
                    case 4 -> {
                        System.out.print("ID a eliminar: "); Long id = leerLong();
                        System.out.print("Confirmar (S/N): ");
                        if (scanner.nextLine().equalsIgnoreCase("S")) {
                            service.eliminarUsuario(id);
                            System.out.println("Usuario eliminado.");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } while (op != 0);
    }

    private static void menuPedidos() {
        int op;
        do {
            System.out.println("\n--- GESTIÓN DE PEDIDOS ---");
            System.out.println("1. Listar pedidos");
            System.out.println("2. Crear pedido");
            System.out.println("3. Cambiar estado / forma de pago");
            System.out.println("4. Eliminar pedido (Baja lógica)");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = leerEntero();

            try {
                switch (op) {
                    case 1 -> {
                        List<Pedido> lista = service.listarPedidos();
                        if (lista.isEmpty()) {
                            System.out.println("No hay pedidos registrados.");
                        } else {
                            lista.forEach(System.out::println);
                        }
                    }
                    case 2 -> {
                        System.out.print("Ingrese ID del Usuario: ");
                        Long idUsr = leerLong();
                        
                        System.out.println("Seleccione Forma de Pago (1. TARJETA, 2. TRANSFERENCIA, 3. EFECTIVO): ");
                        int fpOpt = leerEntero();
                        FormaPago fp = fpOpt == 1 ? FormaPago.TARJETA : (fpOpt == 2 ? FormaPago.TRANSFERENCIA : FormaPago.EFECTIVO);

                        List<int[]> items = new ArrayList<>();
                        String agregarMas;
                        do {
                            System.out.print("Ingrese ID del Producto a comprar: ");
                            Long idProdLong = leerLong();
                            int idProd = idProdLong.intValue(); 
                            
                            System.out.print("Cantidad: ");
                            int cant = leerEntero();
                            
                            items.add(new int[]{idProd, cant});
                            
                            System.out.print("¿Desea agregar otro producto a este pedido? (S/N): ");
                            agregarMas = scanner.nextLine();
                        } while (agregarMas.equalsIgnoreCase("S"));

                        service.registrarPedido(idUsr, fp, items);
                        System.out.println("¡Pedido registrado de forma segura y stock actualizado!");
                    }
                    case 3 -> {
                        System.out.print("ID del Pedido: "); Long idPed = leerLong();
                        System.out.println("Nuevo Estado (1. PENDIENTE, 2. CONFIRMADO, 3. TERMINADO, 4. CANCELADO, 0. No cambiar): ");
                        int estOpt = leerEntero();
                        Estado est = estOpt == 1 ? Estado.PENDIENTE : (estOpt == 2 ? Estado.CONFIRMADO : (estOpt == 3 ? Estado.TERMINADO : (estOpt == 4 ? Estado.CANCELADO : null)));
                        
                        service.actualizarEstadoPedido(idPed, est, null);
                        System.out.println("Pedido actualizado.");
                    }
                    case 4 -> {
                        System.out.print("ID del Pedido a eliminar: "); Long idPed = leerLong();
                        System.out.print("Confirmar (S/N): ");
                        if (scanner.nextLine().equalsIgnoreCase("S")) {
                            service.eliminarPedido(idPed);
                            System.out.println("Pedido eliminado.");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("ERROR AL PROCESAR PEDIDO: " + e.getMessage());
            }
        } while (op != 0);
    }

    // --- MÉTODOS AUXILIARES DE VALIDACIÓN EN CONSOLA ---

    private static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número entero: ");
            }
        }
    }

    private static Long leerLong() {
        while (true) {
            try {
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un ID numérico válido: ");
            }
        }
    }

    private static double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un precio decimal válido: ");
            }
        }
    }
}