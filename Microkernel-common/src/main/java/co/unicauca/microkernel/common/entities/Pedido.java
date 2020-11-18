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
    private LocalDateTime fechaCreado;
    private LocalDateTime fechaPagado;

    public Pedido(int idPedido, int cliente, int resId, EstadoPed estado, LocalDateTime fechaCreado, LocalDateTime fechaPagado) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.resId = resId;
        this.estado = estado;
        this.fechaCreado = fechaCreado;
        this.fechaPagado = fechaPagado;
    }
    public Pedido(int idPedido, int cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
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

    public EstadoPed getEstado() {
        return estado;
    }

    public void setEstado(EstadoPed estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(LocalDateTime fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public LocalDateTime getFechaPagado() {
        return fechaPagado;
    }

    public void setFechaPagado(LocalDateTime fechaPagado) {
        this.fechaPagado = fechaPagado;
    }
    
    
}
