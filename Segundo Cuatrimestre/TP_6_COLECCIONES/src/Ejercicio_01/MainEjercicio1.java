/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio_01;

/**
 *UTN Tecnicatura Universitaria en Programación
 * Trabajo Practico 6: Colecciones
 * Franco Stefano Ghiossi Hrebin
 * @author franker
 */
public class MainEjercicio1 {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        inventario.agregarProducto(new Producto("P01", "Arroz 1kg", 1200.0, 50, CategoriaProducto.ALIMENTOS));
        inventario.agregarProducto(new Producto("P02", "Auriculares Bluetooth", 25000.0, 15, CategoriaProducto.ELECTRONICA));
        inventario.agregarProducto(new Producto("P03", "Remera Algodón", 8500.0, 30, CategoriaProducto.ROPA));
        inventario.agregarProducto(new Producto("P04", "Sartén Antiadherente", 18000.0, 8, CategoriaProducto.HOGAR));
        inventario.agregarProducto(new Producto("P05", "Fideos 500g", 1500.0, 120, CategoriaProducto.ALIMENTOS));

        System.out.println("\n--- 2. LISTADO INICIAL ---");
        inventario.listarProductos();

     
        System.out.println("\n--- 3. BUSCAR PRODUCTO POR ID (P02) ---");
        Producto buscado = inventario.buscarProductoPorId("P02");
        if (buscado != null) buscado.mostrarInfo();

        
        System.out.println("\n--- 4. FILTRAR POR ALIMENTOS ---");
        inventario.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);

     
        System.out.println("\n--- 5. ELIMINAR PRODUCTO (P03) ---");
        if (inventario.eliminarProducto("P03")) System.out.println("Producto P03 eliminado con éxito.");
        inventario.listarProductos();

      
        System.out.println("\n--- 6. ACTUALIZAR STOCK DE P01 A 75 ---");
        inventario.actualizarStock("P01", 75);
        inventario.buscarProductoPorId("P01").mostrarInfo();

      
        System.out.println("\n--- 7. TOTAL DE STOCK EN TIENDA ---");
        System.out.println("Total de unidades: " + inventario.obtenerTotalStock());

       
        System.out.println("\n--- 8. PRODUCTO CON MAYOR STOCK ---");
        Producto maxStock = inventario.obtenerProductoConMayorStock();
        if (maxStock != null) maxStock.mostrarInfo();

        System.out.println("\n--- 9. FILTRAR POR PRECIO ($1000 a $3000) ---");
        inventario.filtrarProductosPorPrecio(1000.0, 3000.0);

        System.out.println("\n--- 10. MOSTRAR CATEGORÍAS DISPONIBLES ---");
        inventario.mostrarCategoriasDisponibles();
    }
}
