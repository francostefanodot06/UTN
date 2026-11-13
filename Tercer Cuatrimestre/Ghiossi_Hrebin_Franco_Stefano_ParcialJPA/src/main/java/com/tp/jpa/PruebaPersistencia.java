package com.tp.jpa;

import com.tp.jpa.model.Categoria;
import com.tp.jpa.model.DetallePedido;
import com.tp.jpa.model.Pedido;
import com.tp.jpa.model.Producto;
import com.tp.jpa.model.Usuario;
import com.tp.jpa.model.enums.Estado;
import com.tp.jpa.model.enums.FormaPago;
import com.tp.jpa.model.enums.Rol;
import com.tp.jpa.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Pruebas de persistencia (puntos 4 a 8 del TP).
 * Cada bloque usa su propio EntityManager y su propia transacción.
 */
public class PruebaPersistencia {

    public static void main(String[] args) {
        try {
            List<Long> categoriaIds = persistirCategorias();          // 4.c
            List<Long> productoIds = persistirProductos(categoriaIds); // 4.d
            List<Long> usuarioIds = persistirUsuarios();               // 4.a
            persistirPedidos(usuarioIds, productoIds);                 // 4.b
            actualizarProductos(productoIds);                          // 5
            buscarUsuarioPorId(usuarioIds.get(0));                     // 6
            buscarUsuarioPorMail("juan.perez@mail.com");               // 7
            borrarProducto(productoIds.get(9));                        // 8
        } finally {
            JPAUtil.close();
        }
    }

    // ---------------------------------------------------------------- 4.c
    private static List<Long> persistirCategorias() {
        System.out.println("\n=== 4.c Persistiendo 3 categorías ===");
        List<Long> ids = new ArrayList<>();
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            String[][] datos = {
                    {"Bebidas", "Gaseosas, jugos y aguas"},
                    {"Comidas", "Platos principales y minutas"},
                    {"Postres", "Dulces y postres"}
            };
            for (String[] d : datos) {
                Categoria c = Categoria.builder().nombre(d[0]).descripcion(d[1]).build();
                em.persist(c);
                ids.add(c.getId());
            }
            tx.commit();
        } catch (RuntimeException e) {
            rollback(tx);
            throw e;
        } finally {
            em.close();
        }
        return ids;
    }

    // ---------------------------------------------------------------- 4.d
    private static List<Long> persistirProductos(List<Long> categoriaIds) {
        System.out.println("\n=== 4.d Persistiendo 10 productos ===");
        List<Long> ids = new ArrayList<>();
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            // nombre, precio, descripcion, stock, indice de categoria
            Object[][] datos = {
                    {"Coca-Cola 500ml", 1500.0, "Gaseosa cola", 50, 0},
                    {"Agua mineral 500ml", 1000.0, "Agua sin gas", 80, 0},
                    {"Jugo de naranja", 1800.0, "Jugo exprimido", 30, 0},
                    {"Cerveza artesanal", 3200.0, "Pinta IPA", 40, 0},
                    {"Hamburguesa completa", 6500.0, "Con lechuga, tomate y huevo", 25, 1},
                    {"Pizza muzzarella", 7200.0, "Pizza grande de 8 porciones", 20, 1},
                    {"Milanesa con papas", 8000.0, "Milanesa de ternera con papas fritas", 15, 1},
                    {"Flan con dulce de leche", 2800.0, "Flan casero", 18, 2},
                    {"Helado 1/4 kg", 3500.0, "Tres sabores a elección", 22, 2},
                    {"Brownie", 2500.0, "Brownie con nuez", 12, 2}
            };
            for (Object[] d : datos) {
                Producto p = Producto.builder()
                        .nombre((String) d[0])
                        .precio((Double) d[1])
                        .descripcion((String) d[2])
                        .stock((Integer) d[3])
                        .imagen(((String) d[0]).toLowerCase().replace(' ', '_') + ".jpg")
                        .disponible(true)
                        .build();
                // 1) persistir el producto para que reciba su ID
                em.persist(p);
                // 2) misma transacción: asociarlo a su categoría
                Categoria c = em.find(Categoria.class, categoriaIds.get((Integer) d[4]));
                c.addProducto(p);
                ids.add(p.getId());
            }
            tx.commit(); // acá se completa la columna categoria_id
        } catch (RuntimeException e) {
            rollback(tx);
            throw e;
        } finally {
            em.close();
        }
        return ids;
    }

    // ---------------------------------------------------------------- 4.a
    private static List<Long> persistirUsuarios() {
        System.out.println("\n=== 4.a Persistiendo 2 usuarios ===");
        List<Long> ids = new ArrayList<>();
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Usuario u1 = Usuario.builder()
                    .nombre("Juan").apellido("Pérez")
                    .mail("juan.perez@mail.com").celular("1155551111")
                    .contrasenia("1234").rol(Rol.ADMIN).build();
            Usuario u2 = Usuario.builder()
                    .nombre("María").apellido("Gómez")
                    .mail("maria.gomez@mail.com").celular("1155552222")
                    .contrasenia("abcd").rol(Rol.USUARIO).build();
            em.persist(u1);
            em.persist(u2);
            ids.add(u1.getId());
            ids.add(u2.getId());
            tx.commit();
        } catch (RuntimeException e) {
            rollback(tx);
            throw e;
        } finally {
            em.close();
        }
        return ids;
    }

    // ---------------------------------------------------------------- 4.b
    private static void persistirPedidos(List<Long> usuarioIds, List<Long> productoIds) {
        System.out.println("\n=== 4.b Persistiendo 3 pedidos (2+ detalles c/u) ===");
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Usuario u1 = em.find(Usuario.class, usuarioIds.get(0));
            Usuario u2 = em.find(Usuario.class, usuarioIds.get(1));

            // Se usan los productos 1..9; el décimo queda libre para la prueba de borrado.
            Pedido p1 = nuevoPedido(Estado.PENDIENTE, FormaPago.TARJETA);
            p1.addDetallePedido(2, em.find(Producto.class, productoIds.get(0)));
            p1.addDetallePedido(1, em.find(Producto.class, productoIds.get(4)));

            Pedido p2 = nuevoPedido(Estado.CONFIRMADO, FormaPago.EFECTIVO);
            p2.addDetallePedido(1, em.find(Producto.class, productoIds.get(5)));
            p2.addDetallePedido(3, em.find(Producto.class, productoIds.get(1)));
            p2.addDetallePedido(1, em.find(Producto.class, productoIds.get(7)));

            Pedido p3 = nuevoPedido(Estado.TERMINADO, FormaPago.TRANSFERENCIA);
            p3.addDetallePedido(2, em.find(Producto.class, productoIds.get(6)));
            p3.addDetallePedido(2, em.find(Producto.class, productoIds.get(8)));

            // persist del pedido cascadea a sus detalles
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);

            u1.addPedido(p1);
            u1.addPedido(p2);
            u2.addPedido(p3);

            tx.commit();
            System.out.println("Totales: p1=" + p1.getTotal() + " p2=" + p2.getTotal() + " p3=" + p3.getTotal());
        } catch (RuntimeException e) {
            rollback(tx);
            throw e;
        } finally {
            em.close();
        }
    }

    private static Pedido nuevoPedido(Estado estado, FormaPago formaPago) {
        return Pedido.builder()
                .fecha(LocalDate.now())
                .estado(estado)
                .formaPago(formaPago)
                .total(0.0)
                .build();
    }

    // ---------------------------------------------------------------- 5
    private static void actualizarProductos(List<Long> productoIds) {
        System.out.println("\n=== 5. Actualizando 2 productos ===");
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Producto a = em.find(Producto.class, productoIds.get(0));
            a.setPrecio(1700.0);
            a.setStock(60);

            Producto b = em.find(Producto.class, productoIds.get(4));
            b.setDescripcion("Hamburguesa doble con cheddar");
            b.setPrecio(7000.0);
            // entidades managed: el commit genera los UPDATE (dirty checking)
            tx.commit();
            System.out.println("Actualizado: " + a.getNombre() + " -> $" + a.getPrecio()
                    + " | " + b.getNombre() + " -> $" + b.getPrecio());
        } catch (RuntimeException e) {
            rollback(tx);
            throw e;
        } finally {
            em.close();
        }
    }

    // ---------------------------------------------------------------- 6
    private static void buscarUsuarioPorId(Long id) {
        System.out.println("\n=== 6. Buscar usuario por id ===");
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Usuario u = em.find(Usuario.class, id);
            if (u == null) {
                System.out.println("No existe usuario con id " + id);
                return;
            }
            System.out.println("Encontrado: " + u.getId() + " - " + u.getNombre() + " "
                    + u.getApellido() + " <" + u.getMail() + "> rol=" + u.getRol());
            // pedidos es LAZY: se accede con el EntityManager todavía abierto
            System.out.println("Pedidos del usuario: " + u.getPedidos().size());
            for (Pedido p : u.getPedidos()) {
                System.out.println("  Pedido " + p.getId() + " " + p.getEstado()
                        + " total=" + p.getTotal() + " detalles=" + p.getDetalles().size());
                for (DetallePedido d : p.getDetalles()) {
                    System.out.println("    " + d.getCantidad() + " x " + d.getProducto().getNombre()
                            + " = " + d.getSubtotal());
                }
            }
        } finally {
            em.close();
        }
    }

    // ---------------------------------------------------------------- 7
    private static void buscarUsuarioPorMail(String mail) {
        System.out.println("\n=== 7. Buscar usuario por mail ===");
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Usuario u = em.createQuery(
                            "SELECT u FROM Usuario u WHERE u.mail = :mail", Usuario.class)
                    .setParameter("mail", mail)
                    .getSingleResult();
            System.out.println("Encontrado por mail: " + u.getId() + " - " + u.getNombre() + " " + u.getApellido());
        } catch (NoResultException e) {
            System.out.println("No existe usuario con mail " + mail);
        } finally {
            em.close();
        }
    }

    // ---------------------------------------------------------------- 8
    private static void borrarProducto(Long productoId) {
        System.out.println("\n=== 8. Borrar 1 producto ===");
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Producto p = em.find(Producto.class, productoId);
            if (p == null) {
                System.out.println("No existe producto con id " + productoId);
                tx.rollback();
                return;
            }
            // Antes de borrar hay que sacarlo de la colección de su categoría
            // (Categoria administra la relación y tiene cascade ALL).
            List<Categoria> categorias = em.createQuery(
                            "SELECT c FROM Categoria c JOIN c.productos pr WHERE pr.id = :id", Categoria.class)
                    .setParameter("id", productoId)
                    .getResultList();
            for (Categoria c : categorias) {
                c.getProductos().remove(p);
            }
            String nombre = p.getNombre();
            em.remove(p);
            tx.commit();
            System.out.println("Producto borrado: " + nombre);
        } catch (RuntimeException e) {
            rollback(tx);
            throw e;
        } finally {
            em.close();
        }
    }

    private static void rollback(EntityTransaction tx) {
        if (tx != null && tx.isActive()) {
            tx.rollback();
        }
    }
}
