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
public class HistorialPed {
    
    private int idRes;
    private String nombre;
    private String fechaCreado;
    private String fechaPagado;

    public HistorialPed(int idRes, String nombre, String fechaCreado, String fechaPagado) {
        this.idRes = idRes;
        this.nombre = nombre;
        this.fechaCreado = fechaCreado;
        this.fechaPagado = fechaPagado;
    }

    public HistorialPed() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(String fechaCreado) {
        this.fechaCreado = fechaCreado;
    }

    public String getFechaPagado() {
        return fechaPagado;
    }

    public void setFechaPagado(String fechaPagado) {
        this.fechaPagado = fechaPagado;
    }

    public int getIdRes() {
        return idRes;
    }

    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }
    
    
    
}