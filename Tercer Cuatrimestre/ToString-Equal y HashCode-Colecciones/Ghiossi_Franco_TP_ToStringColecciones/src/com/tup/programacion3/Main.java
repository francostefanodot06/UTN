package com.tup.programacion3;

import com.tup.programacion3.entities.*;
import com.tup.programacion3.enums.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // --- 1. INSTANCIAR 3 CATEGORÍAS ---
        Categoria cat1 = new Categoria(); cat1.setId(1L); cat1.setNombre("Electrónica");
        Categoria cat2 = new Categoria(); cat2.setId(2L); cat2.setNombre("Periféricos");
        Categoria cat3 = new Categoria(); cat3.setId(3L); cat3.setNombre("Audio");

        // --- 2. INSTANCIAR 10 PRODUCTOS ---
        Set<Producto> catalogo = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            Producto p = new Producto();
            p.setId((long) i);
            p.setNombre("Producto " + i);
            p.setPrecio(1000.0 * i);
            p.setStock(50);
            p.setDisponible(true);
            catalogo.add(p);
        }

        // Convertimos a array para acceder fácil a productos específicos en los pedidos
        Producto[] prodArray = catalogo.toArray(new Producto[0]);

        // --- 3. INSTANCIAR 2 USUARIOS ---
        Usuario u1 = new Usuario();
        u1.setId(1L); u1.setNombre("Franco"); u1.setRol(Rol.USUARIO);

        Usuario u2 = new Usuario();
        u2.setId(2L); u2.setNombre("Admin"); u2.setRol(Rol.ADMIN);

        // --- 4. INSTANCIAR 3 PEDIDOS (Mínimo 2 detalles por pedido) ---
        Pedido ped1 = new Pedido(); ped1.setId(1L); ped1.setFecha(LocalDate.now()); ped1.setEstado(Estado.PENDIENTE); ped1.setFormaPago(FormaPago.TARJETA);
        ped1.addDetallePedido(2, prodArray[0]);
        ped1.addDetallePedido(1, prodArray[1]);

        Pedido ped2 = new Pedido(); ped2.setId(2L); ped2.setFecha(LocalDate.now()); ped2.setEstado(Estado.CONFIRMADO); ped2.setFormaPago(FormaPago.EFECTIVO);
        ped2.addDetallePedido(3, prodArray[2]);
        ped2.addDetallePedido(1, prodArray[3]);

        Pedido ped3 = new Pedido(); ped3.setId(3L); ped3.setFecha(LocalDate.now()); ped3.setEstado(Estado.TERMINADO); ped3.setFormaPago(FormaPago.TRANSFERENCIA);
        ped3.addDetallePedido(5, prodArray[4]);
        ped3.addDetallePedido(2, prodArray[5]);

        // Asignamos pedidos a usuarios (u1 tendrá más pedidos)
        u1.getPedidos().add(ped1);
        u1.getPedidos().add(ped2);
        u2.getPedidos().add(ped3);

        // --- 5. MOSTRAR REQUISITOS POR CONSOLA ---
        System.out.println("====== MOSTRAR UN PRODUCTO ======");
        System.out.println(prodArray[0]);

        System.out.println("\n====== LISTADO COMPLETO DE PRODUCTOS ======");
        catalogo.forEach(System.out::println);

        System.out.println("\n====== PEDIDOS DEL USUARIO CON MÁS PEDIDOS ======");
        Usuario usuarioTop = u1.getPedidos().size() > u2.getPedidos().size() ? u1 : u2;
        System.out.println("Usuario con más pedidos: " + usuarioTop.getNombre());
        usuarioTop.getPedidos().forEach(pedido -> {
            System.out.println(pedido);
            pedido.getDetalles().forEach(detalle -> System.out.println("   -> " + detalle));
        });

        // --- 6. PRODUCTO DUPLICADO Y COMPROBACIÓN DE SET ---
        System.out.println("\n====== PRUEBA DE EQUALS, HASHCODE Y SET ======");
        Producto pDuplicado = new Producto();
        pDuplicado.setId(1L); // Mismo ID que Producto 1
        pDuplicado.setNombre("Producto 1 - CLON");

        System.out.println("Intentando agregar un producto con ID ya existente...");
        System.out.println("¿El catalogo ya lo contiene según equals()? " + catalogo.contains(pDuplicado));

        boolean agregado = catalogo.add(pDuplicado);
        System.out.println("¿Se pudo agregar al Set? " + agregado);
        System.out.println("Cantidad de productos en catálogo (Debe seguir siendo 10): " + catalogo.size());
    }
}