package co.unicauca.microkernel.common.entities;

/**
 * Envio
 * @author Libardo, Julio
 */
public class Delivery {

    private int precio;
    private double distance;
    private String resCode;

    public Delivery(int precio, double distance, String resCode) {
        this.precio = precio;
        this.distance = distance;
        this.resCode = resCode;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    
    
}
