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
public class RacionDia {
    private int racId;
    private CategoriaEnum tipo;
    private int precio;
    private String nombre;
    private int menuId;
    private byte [] imagen;

    public RacionDia(){}
    
    public RacionDia(int racId, CategoriaEnum tipo, int precio, String nombre, int menuId, byte [] imagen) {
        this.racId = racId;
        this.tipo = tipo;
        this.precio = precio;
        this.nombre = nombre;
        this.menuId = menuId;
        this.imagen=imagen;
    }

    public int getRacId() {
        return racId;
    }

    public void setRacId(int racId) {
        this.racId = racId;
    }

    public CategoriaEnum getTipo() {
        return tipo;
    }

    public void setTipo(CategoriaEnum tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
}
