/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integrado.prog2.entities;

import integrado.prog2.enums.Estado;
import integrado.prog2.enums.FormaPago;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author franker
 */
public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    private Usuario usuario;
    private List<DetallePedido> detalles;

    public Pedido(Usuario usuario, FormaPago formaPago) {
        super();
        this.fecha = LocalDate.now();
        this.estado = Estado.PENDIENTE;
        this.formaPago = formaPago;
        this.usuario = usuario;
        this.detalles = new ArrayList<>();
        this.total = 0.0;
    }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public FormaPago getFormaPago() { return formaPago; }
    public void setFormaPago(FormaPago formaPago) { this.formaPago = formaPago; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<DetallePedido> getDetalles() { return detalles; }
    public void setDetalles(List<DetallePedido> detalles) { this.detalles = detalles; }

    // El método obligatorio solicitado por la cátedra en la HU-PED-02
    public void addDetallePedido(int cantidad, double subtotal, Producto producto) {
        DetallePedido nuevoDetalle = new DetallePedido(cantidad, producto);
        // Garantizamos que si se altera externamente mantenga la consistencia
        if (subtotal > 0) {
            nuevoDetalle.recalcularSubtotal(); 
        }
        this.detalles.add(nuevoDetalle);
    }

    public DetallePedido findDetallePedidoByProducto(Producto producto) {
        for (DetallePedido dp : detalles) {
            if (dp.getProducto() != null && dp.getProducto().getId().equals(producto.getId())) {
                return dp;
            }
        }
        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        detalles.removeIf(dp -> dp.getProducto() != null && dp.getProducto().getId().equals(producto.getId()));
    }

    @Override
    public void calcularTotal() {
        double acum = 0.0;
        for (DetallePedido dp : detalles) {
            if (!dp.isEliminado()) { // Solo suma los detalles no eliminados lógicamente
                acum += dp.getSubtotal();
            }
        }
        this.total = acum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido [ID=").append(getId())
          .append(", Usuario=").append(usuario != null ? (usuario.getNombre() + " " + usuario.getApellido()) : "N/A")
          .append(", Fecha=").append(fecha)
          .append(", Estado=").append(estado)
          .append(", FormaPago=").append(formaPago)
          .append(", Total=$").append(total).append("]");
        
        boolean tieneDetallesActivos = false;
        for (DetallePedido dp : detalles) {
            if (!dp.isEliminado()) {
                if (!tieneDetallesActivos) {
                    sb.append("\n  Detalles:");
                    tieneDetallesActivos = true;
                }
                sb.append("\n").append(dp.toString());
            }
        }
        return sb.toString();
    }
}
