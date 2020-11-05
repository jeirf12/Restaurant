/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.common.entities;

/**
 *
 * @author fallen
 */
public class MenuDia {
    private int idMenu;
    private String nombre;
    private DiaEnum diaSem;
    private int resId;

    public MenuDia(int idMenu, String nombre, DiaEnum diaSem, int resId) {
        this.idMenu = idMenu;
        this.nombre = nombre;
        this.diaSem = diaSem;
        this.resId = resId;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DiaEnum getDiaSem() {
        return diaSem;
    }

    public void setDiaSem(DiaEnum diaSem) {
        this.diaSem = diaSem;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
    
    
    
}
