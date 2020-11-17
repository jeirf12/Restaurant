package co.unicauca.microkernel.common.entities;

/**
 *
 * @author jafes
 */
public class PlatoEspecialPed {
    private int plaepId;
    private int pedId;
    private int plaeId;
    private int cantidad;

    public PlatoEspecialPed(int plaepId, int pedId, int plaeId, int cantidada) {
        this.plaepId = plaepId;
        this.pedId = pedId;
        this.plaeId = plaeId;
        this.cantidad = cantidad;
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

    public int getPlaeId() {
        return plaeId;
    }

    public void setPlaeId(int plaeId) {
        this.plaeId = plaeId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
