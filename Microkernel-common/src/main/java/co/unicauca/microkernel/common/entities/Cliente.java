package co.unicauca.microkernel.common.entities;

/**
 *
 * @author jafes
 */
public class Cliente {
    private int idCliente;
    private String nombre;
    private int carrera;
    private int calle;
    private TipoClien tipo;
    private String contrasenia;
    private byte [] imagen;
    private int idrestaurante;

    public Cliente() {};

    public Cliente(int idCliente, String nombre, int carrera, int calle, TipoClien tipo, String contrasenia, byte[] imagen) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.carrera = carrera;
        this.calle = calle;
        this.tipo = tipo;
        this.contrasenia = contrasenia;
        this.imagen = imagen;
    }
    public Cliente(String nombre, String contrasenia) {
       this.nombre = nombre;
       this.contrasenia = contrasenia;
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

    public TipoClien getTipo() {
        return tipo;
    }

    public void setTipo(TipoClien tipo) {
        this.tipo = tipo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

  
  

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getIdrestaurante() {
        return idrestaurante;
    }

    public void setIdrestaurante(int idrestaurante) {
        this.idrestaurante = idrestaurante;
    }
    
}
