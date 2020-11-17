package co.unicauca.microkernel.common.entities;

/**
 *
 * @author EdynsonMJ
 */
public class Restaurante {

    private int id;
    private String codigo;
    private String nombre;
    private byte[] imagen;
    private int calle;
    private int carrera;

    public Restaurante() {
    }

    public Restaurante(int id, String codigo, String nombre, byte[] imagen, int calle, int carrera) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.imagen = imagen;
        this.calle = calle;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCalle() {
        return calle;
    }

    public void setCalle(int calle) {
        this.calle = calle;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }
    
}
