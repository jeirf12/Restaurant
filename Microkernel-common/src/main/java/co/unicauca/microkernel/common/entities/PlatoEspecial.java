package co.unicauca.microkernel.common.entities;

/**
 *
 * @author jafes
 */
public class PlatoEspecial{
    
    private int menuEsp;
    private int id_pe;
    private String nombre;
    private String descripcion;
    private int precio;
    private byte [] imagen;
    
    public PlatoEspecial(){};
    /**
     * contructor parametrizado para la creacion de un plato especial
     * @param descripcion descripcion que tendrta el plato
     * @param id_pe
     * @param nombre nombre del plato
     * @param precio precio para la venta
     * @param menuEsp
     */
    public PlatoEspecial(int id_pe, int menuEsp, String nombre, String descripcion, int precio,byte [] imagen) {
        this.menuEsp = menuEsp;
        this.id_pe = id_pe;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen=imagen;
    }


    public int getMenuEsp() {
        return menuEsp;
    }

    public void setMenuEsp(int menuEsp) {
        this.menuEsp = menuEsp;
    }

    public int getId_pe() {
        return id_pe;
    }

    public void setId_pe(int id_pe) {
        this.id_pe = id_pe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
