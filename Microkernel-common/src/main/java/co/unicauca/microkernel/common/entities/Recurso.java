/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.common.entities;

/**
 *
 * @author EdynsonMJ
 */
public class Recurso {
    private String nombre;
    private byte[] recurso;

    public Recurso() {
    }

    public Recurso(String nombre, byte[] recurso) {
        this.nombre = nombre;
        this.recurso = recurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getRecurso() {
        return recurso;
    }

    public void setRecurso(byte[] recurso) {
        this.recurso = recurso;
    }
    
}
