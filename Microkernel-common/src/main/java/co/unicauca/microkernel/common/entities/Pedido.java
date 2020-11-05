/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private LocalDateTime fecha;

    public Pedido(int idPedido, int cliente, int resId, LocalDateTime fecha) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.resId = resId;
        this.fecha = fecha;
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
}
