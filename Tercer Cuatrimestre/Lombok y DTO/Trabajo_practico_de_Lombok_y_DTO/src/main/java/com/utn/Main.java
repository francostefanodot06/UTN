package com.utn;

import com.utn.dtos.UsuarioDTO;
import com.utn.entities.*;
import com.utn.enums.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciar 3 Categorías
        Categoria cat1 = Categoria.builder().id(1L).nombre("Electrónica").build();
        Categoria cat2 = Categoria.builder().id(2L).nombre("Hogar").build();
        Categoria cat3 = Categoria.builder().id(3L).nombre("Jardín").build();

        // 2. Instanciar 10 Productos
        Set<Producto> catalogo = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            Producto p = Producto.builder()
                    .id((long) i)
                    .nombre("Producto " + i)
                    .precio(1500.0 * i)
                    .stock(100)
                    .disponible(true)
                    .build();
            catalogo.add(p);
        }
        Producto[] arrayProductos = catalogo.toArray(new Producto[0]);

        // 3. Instanciar 2 Usuarios
        Usuario u1 = Usuario.builder()
                .id(1L).nombre("Ana").apellido("Gómez").mail("ana@mail.com")
                .contraseña("1234").rol(Rol.USUARIO).build();

        Usuario u2 = Usuario.builder()
                .id(2L).nombre("Luis").apellido("Pérez").mail("luis@mail.com")
                .contraseña("abcd").rol(Rol.ADMIN).build();

        // Crear DTO para el Usuario 1 ocultando datos sensibles
        UsuarioDTO u1DTO = new UsuarioDTO(u1.getId(), u1.getNombre(), u1.getApellido(), u1.getMail(), u1.getCelular());

        // 4. Instanciar 3 Pedidos con al menos 2 detalles cada uno
        Pedido ped1 = Pedido.builder().id(1L).fecha(LocalDate.now()).estado(Estado.PENDIENTE).formaPago(FormaPago.EFECTIVO).build();
        ped1.addDetallePedido(2, arrayProductos[0]);
        ped1.addDetallePedido(1, arrayProductos[1]);
        u1.getPedidos().add(ped1);

        Pedido ped2 = Pedido.builder().id(2L).fecha(LocalDate.now()).estado(Estado.CONFIRMADO).formaPago(FormaPago.TARJETA).build();
        ped2.addDetallePedido(3, arrayProductos[2]);
        ped2.addDetallePedido(1, arrayProductos[3]);
        u1.getPedidos().add(ped2);

        Pedido ped3 = Pedido.builder().id(3L).fecha(LocalDate.now()).estado(Estado.TERMINADO).formaPago(FormaPago.TRANSFERENCIA).build();
        ped3.addDetallePedido(5, arrayProductos[4]);
        ped3.addDetallePedido(2, arrayProductos[5]);
        u2.getPedidos().add(ped3);

        // 5. Mostrar por consola: un producto, el listado y los pedidos del usuario top
        System.out.println("--- MOSTRAR UN PRODUCTO ---");
        System.out.println(arrayProductos[0].toString());

        System.out.println("\n--- LISTADO DE PRODUCTOS CARGADOS ---");
        catalogo.forEach(System.out::println);

        System.out.println("\n--- PEDIDOS DEL USUARIO CON MÁS PEDIDOS ---");
        Usuario usuarioTop = u1.getPedidos().size() > u2.getPedidos().size() ? u1 : u2;
        System.out.println("Usuario: " + usuarioTop.getNombre() + " (DTO: " + u1DTO + ")");
        usuarioTop.getPedidos().forEach(pedido -> {
            System.out.println(pedido);
            pedido.getDetalles().forEach(dp -> System.out.println("   -> " + dp));
        });

        // 6. Instanciar producto duplicado y comparar
        System.out.println("\n--- PRUEBA DE EQUALS CON PRODUCTO DUPLICADO ---");
        Producto pDuplicado = Producto.builder()
                .id(1L) // Mismo ID para que equals dé true
                .nombre("Producto 1 Clonado")
                .build();

        System.out.println("¿El catálogo ya contiene al producto con ID 1? " + catalogo.contains(pDuplicado));

        boolean seAgrego = catalogo.add(pDuplicado);
        System.out.println("¿Se pudo agregar el duplicado al Set? " + seAgrego);
        System.out.println("Tamaño del catálogo final: " + catalogo.size());
    }
}