/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.common.entities;

/**
 *
 * @author jafes
 */
public class RacionPed {
    private int racpId;
    private int pedId;
    private int racId;
    private int cantidad;

    public RacionPed(int racpId, int pedId, int racId, int cantidad) {
        this.racpId = racpId;
        this.pedId = pedId;
        this.racId = racId;
        this.cantidad = cantidad;
    }

    public RacionPed() {
    }

    public int getRacpId() {
        return racpId;
    }

    public void setRacpId(int racpId) {
        this.racpId = racpId;
    }

    public int getPedId() {
        return pedId;
    }

    public void setPedId(int pedId) {
        this.pedId = pedId;
    }

    public int getRacId() {
        return racId;
    }

    public void setRacId(int racId) {
        this.racId = racId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
