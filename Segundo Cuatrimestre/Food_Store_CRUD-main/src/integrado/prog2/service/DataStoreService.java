/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.service;

import integrado.prog2.entities.Categoria;
import integrado.prog2.entities.DetallePedido;
import integrado.prog2.entities.Pedido;
import integrado.prog2.entities.Producto;
import integrado.prog2.entities.Usuario;
import integrado.prog2.enums.Estado;
import integrado.prog2.enums.FormaPago;
import integrado.prog2.enums.Rol;
import integrado.prog2.exception.EntidadNoEncontradaException;
import integrado.prog2.exception.NegocioException;
import integrado.prog2.exception.StockInvalidoException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author franker
 */
public class DataStoreService {
    private List<Categoria> categorias = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    private long nextIdCategoria = 1;
    private long nextIdProducto = 1;
    private long nextIdUsuario = 1;
    private long nextIdPedido = 1;
    private long nextIdDetalle = 1; // Contador para los detalles del pedido

    // --- GESTIÓN DE CATEGORÍAS ---
    public void crearCategoria(String nombre, String descripcion) throws NegocioException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new NegocioException("El nombre de la categoría no puede estar vacío.");
        }
        for (Categoria c : categorias) {
            if (!c.isEliminado() && c.getNombre().equalsIgnoreCase(nombre.trim())) {
                throw new NegocioException("Ya existe una categoría con ese nombre.");
            }
        }
        Categoria cat = new Categoria(nombre.trim(), descripcion);
        cat.setId(nextIdCategoria++);
        categorias.add(cat);
    }

    public List<Categoria> listarCategorias() {
        List<Categoria> activas = new ArrayList<>();
        for (Categoria c : categorias) {
            if (!c.isEliminado()) activas.add(c);
        }
        return activas;
    }

    public Categoria buscarCategoriaPorId(Long id) throws EntidadNoEncontradaException {
        for (Categoria c : categorias) {
            if (c.getId().equals(id) && !c.isEliminado()) return c;
        }
        throw new EntidadNoEncontradaException("Categoría activa no encontrada con ID: " + id);
    }

    public void editarCategoria(Long id, String nuevoNombre, String nuevaDescripcion) throws EntidadNoEncontradaException, NegocioException {
        Categoria c = buscarCategoriaPorId(id);
        if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
            for (Categoria cat : categorias) {
                if (!cat.getId().equals(id) && !cat.isEliminado() && cat.getNombre().equalsIgnoreCase(nuevoNombre.trim())) {
                    throw new NegocioException("Ya existe otra categoría activa con ese nombre.");
                }
            }
            c.setNombre(nuevoNombre.trim());
        }
        if (nuevaDescripcion != null) {
            c.setDescripcion(nuevaDescripcion);
        }
    }

    public void eliminarCategoria(Long id) throws EntidadNoEncontradaException {
        Categoria c = buscarCategoriaPorId(id);
        c.setEliminado(true);
        // Soft delete en cascada para productos asociados
        for (Producto p : productos) {
            if (p.getCategoria() != null && p.getCategoria().getId().equals(id)) {
                p.setEliminado(true);
            }
        }
    }

    // --- GESTIÓN DE PRODUCTOS ---
    public void crearProducto(String nombre, Double precio, String descripcion, int stock, String imagen, Boolean disponible, Long idCategoria) 
            throws NegocioException, EntidadNoEncontradaException {
        if (nombre == null || nombre.trim().isEmpty()) throw new NegocioException("El nombre del producto no puede estar vacío.");
        if (precio < 0) throw new NegocioException("El precio no puede ser menor a 0.");
        if (stock < 0) throw new NegocioException("El stock no puede ser menor a 0.");
        
        Categoria cat = buscarCategoriaPorId(idCategoria);
        Producto prod = new Producto(nombre.trim(), precio, descripcion, stock, imagen, disponible, cat);
        prod.setId(nextIdProducto++);
        productos.add(prod);
    }

    public List<Producto> listarProductos() {
        List<Producto> activos = new ArrayList<>();
        for (Producto p : productos) {
            if (!p.isEliminado()) activos.add(p);
        }
        return activos;
    }

    public Producto buscarProductoPorId(Long id) throws EntidadNoEncontradaException {
        for (Producto p : productos) {
            if (p.getId().equals(id) && !p.isEliminado()) return p;
        }
        throw new EntidadNoEncontradaException("Producto activo no encontrado con ID: " + id);
    }

    public void editarProducto(Long id, String nombre, Double precio, String descripcion, Integer stock, String imagen, Boolean disponible, Long idCategoria) 
            throws EntidadNoEncontradaException, NegocioException {
        Producto p = buscarProductoPorId(id);
        if (nombre != null && !nombre.trim().isEmpty()) p.setNombre(nombre.trim());
        if (precio != null) {
            if (precio < 0) throw new NegocioException("El precio no puede ser negativo.");
            p.setPrecio(precio);
        }
        if (descripcion != null) p.setDescripcion(descripcion);
        if (stock != null) {
            if (stock < 0) throw new NegocioException("El stock no puede ser negativo.");
            p.setStock(stock);
        }
        if (imagen != null) p.setImagen(imagen);
        if (disponible != null) p.setDisponible(disponible);
        if (idCategoria != null) {
            Categoria cat = buscarCategoriaPorId(idCategoria);
            p.setCategoria(cat);
        }
    }

    public void eliminarProducto(Long id) throws EntidadNoEncontradaException {
        Producto p = buscarProductoPorId(id);
        p.setEliminado(true);
    }

    // --- GESTIÓN DE USUARIOS ---
    public void crearUsuario(String nombre, String apellido, String mail, String celular, String contraseña, Rol rol) throws NegocioException {
        if (mail == null || mail.trim().isEmpty()) throw new NegocioException("El mail es obligatorio.");
        for (Usuario u : usuarios) {
            if (!u.isEliminado() && u.getMail().equalsIgnoreCase(mail.trim())) {
                throw new NegocioException("El mail ingresado ya está registrado por otro usuario.");
            }
        }
        Usuario u = new Usuario(nombre, apellido, mail.trim(), celular, contraseña, rol);
        u.setId(nextIdUsuario++);
        usuarios.add(u);
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> activos = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (!u.isEliminado()) activos.add(u);
        }
        return activos;
    }

    public Usuario buscarUsuarioPorId(Long id) throws EntidadNoEncontradaException {
        for (Usuario u : usuarios) {
            if (u.getId().equals(id) && !u.isEliminado()) return u;
        }
        throw new EntidadNoEncontradaException("Usuario activo no encontrado con ID: " + id);
    }

    public void editarUsuario(Long id, String nombre, String apellido, String mail, String celular, String contraseña, Rol rol) 
            throws EntidadNoEncontradaException, NegocioException {
        Usuario u = buscarUsuarioPorId(id);
        if (nombre != null) u.setNombre(nombre);
        if (apellido != null) u.setApellido(apellido);
        if (mail != null && !mail.trim().isEmpty()) {
            for (Usuario usr : usuarios) {
                if (!usr.getId().equals(id) && !usr.isEliminado() && usr.getMail().equalsIgnoreCase(mail.trim())) {
                    throw new NegocioException("El mail ingresado ya está en uso por otro usuario.");
                }
            }
            u.setMail(mail.trim());
        }
        if (celular != null) u.setCelular(celular);
        if (contraseña != null) u.setContraseña(contraseña);
        if (rol != null) u.setRol(rol);
    }

    public void eliminarUsuario(Long id) throws EntidadNoEncontradaException {
        Usuario u = buscarUsuarioPorId(id);
        u.setEliminado(true);
    }

    // --- GESTIÓN DE PEDIDOS ---
    public List<Pedido> listarPedidos() {
        List<Pedido> activos = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (!p.isEliminado()) activos.add(p);
        }
        return activos;
    }

    public Pedido buscarPedidoPorId(Long id) throws EntidadNoEncontradaException {
        for (Pedido p : pedidos) {
            if (p.getId().equals(id) && !p.isEliminado()) return p;
        }
        throw new EntidadNoEncontradaException("Pedido no encontrado.");
    }

   
    public void registrarPedido(Long idUsuario, FormaPago formaPago, List<int[]> items) 
        throws EntidadNoEncontradaException, StockInvalidoException, NegocioException {
    
    Usuario u = buscarUsuarioPorId(idUsuario);
    
    
    if (u == null) {
        throw new EntidadNoEncontradaException("No se encontró un usuario activo con el ID: " + idUsuario);
    }
    
    if (items == null || items.isEmpty()) throw new NegocioException("El pedido debe tener al menos un detalle.");

    Pedido temporal = new Pedido(u, formaPago);
        List<Producto> productosAfectados = new ArrayList<>();
        List<Integer> stocksAnteriores = new ArrayList<>();

        try {
            for (int[] item : items) {
                Long idProd = (long) item[0];
                int cantidad = item[1];

                if (cantidad <= 0) throw new NegocioException("La cantidad debe ser mayor a 0.");

                Producto p = buscarProductoPorId(idProd);
                if (p.getStock() < cantidad) {
                    throw new StockInvalidoException("Stock insuficiente para el producto: " + p.getNombre() + " (Disponibles: " + p.getStock() + ")");
                }

                // Guardar estado previo por si ocurre un fallo
                productosAfectados.add(p);
                stocksAnteriores.add(p.getStock());

                // Restar stock
                p.setStock(p.getStock() - cantidad);

                // Agregar detalle usando el método obligatorio de Pedido
                double subtotal = cantidad * p.getPrecio();
                temporal.addDetallePedido(cantidad, subtotal, p);
                
                // Asigno ID manual al detalle respetando el diagrama de clases
                temporal.getDetalles().get(temporal.getDetalles().size() - 1).setId(nextIdDetalle++);
            }

            // Calcular total final usando la interfaz
            temporal.calcularTotal();
            temporal.setId(nextIdPedido++);
            pedidos.add(temporal);

        } catch (Exception e) {
            // Revertir stocks en memoria si salta una excepción para mantener consistencia
            for (int i = 0; i < productosAfectados.size(); i++) {
                productosAfectados.get(i).setStock(stocksAnteriores.get(i));
            }
            throw e; 
        }
    }

    public void actualizarEstadoPedido(Long idPedido, Estado nuevoEstado, FormaPago nuevaForma) throws EntidadNoEncontradaException {
        Pedido p = buscarPedidoPorId(idPedido);
        if (nuevoEstado != null) p.setEstado(nuevoEstado);
        if (nuevaForma != null) p.setFormaPago(nuevaForma);
    }

    public void eliminarPedido(Long idPedido) throws EntidadNoEncontradaException {
        Pedido p = buscarPedidoPorId(idPedido);
        p.setEliminado(true);
        // Marcar detalles como eliminados
        for (DetallePedido dp : p.getDetalles()) {
            dp.setEliminado(true);
        }
    }
}