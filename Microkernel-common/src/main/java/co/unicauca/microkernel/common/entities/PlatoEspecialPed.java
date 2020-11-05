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

    public PlatoEspecialPed(int plaepId, int pedId) {
        this.plaepId = plaepId;
        this.pedId = pedId;
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
