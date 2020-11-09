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
public class PlatoEspecialPed {
    private int plaepId;
    private int pedId;
    private int plaeId;

    public PlatoEspecialPed(int plaepId, int pedId, int plaeId) {
        this.plaepId = plaepId;
        this.pedId = pedId;
        this.plaeId = plaeId;
    }

    public int getPlaeId() {
        return plaeId;
    }

    public void setPlaeId(int plaeId) {
        this.plaeId = plaeId;
    }

    public PlatoEspecialPed() {
    }

    public int getPlaepId() {
        return plaepId;
    }

    public void setPlaepId(int plaepId) {
        this.plaepId = plaepId;
    }

    public int getPedId() {
        return pedId;
    }

    public void setPedId(int pedId) {
        this.pedId = pedId;
    }
    
    
}
