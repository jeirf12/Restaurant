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

    public RacionPed(int racpId, int pedId) {
        this.racpId = racpId;
        this.pedId = pedId;
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
    
    
}
