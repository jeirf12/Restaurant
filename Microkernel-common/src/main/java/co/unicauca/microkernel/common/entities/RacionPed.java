package co.unicauca.microkernel.common.entities;

/**
 *
 * @author jafes
 */
public class RacionPed {
    private int racpId;
    private int pedId;
    private int racId;

    public RacionPed(int racpId, int pedId, int racId) {
        this.racpId = racpId;
        this.pedId = pedId;
        this.racId = racId;
    }

    public int getRacId() {
        return racId;
    }

    public void setRacId(int racId) {
        this.racId = racId;
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
