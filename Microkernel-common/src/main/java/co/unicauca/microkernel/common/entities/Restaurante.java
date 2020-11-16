package co.unicauca.microkernel.common.entities;

/**
 *
 * @author EdynsonMJ
 */
public class Restaurante {

    private int id;
    private int idCliente;
    private String codigo;
    private String nombre;
    private byte[] imagen;
    private int carrera;
    private int calle;

    public Restaurante() {
    }

    public Restaurante(int id,int idcliente, String codigo, String nombre, byte[] imagen, int carrera,int calle) {
        this.id = id;
        this.idCliente=idcliente;
        this.codigo = codigo;
        this.nombre = nombre;
        this.imagen = imagen;
        this.carrera = carrera;
        this.calle = calle;
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

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public int getCalle() {
        return calle;
    }

    public void setCalle(int calle) {
        this.calle = calle;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
}
