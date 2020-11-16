package co.unicauca.microkernel.common.entities;

import java.time.LocalDateTime;

/**
 *
 * @author jafes
 */
public class Pedido {
    private int idPedido;
    private int cliente;
    private int resId;
    private EstadoPed estado;
    private LocalDateTime fecha;

    public Pedido(int idPedido, int cliente, int resId, EstadoPed estado, LocalDateTime fecha) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.resId = resId;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }    

    public EstadoPed getEstado() {
        return estado;
    }

    public void setEstado(EstadoPed estado) {
        this.estado = estado;
    }
}
