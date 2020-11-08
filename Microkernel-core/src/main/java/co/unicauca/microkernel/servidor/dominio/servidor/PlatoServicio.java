/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.servidor.dominio.servidor;

import co.unicauca.microkernel.common.entities.*;
import co.unicauca.microkernel.servidor.acceso.IPlatoRepositorio;

/**
 *comunicacion con la capa de bajo nivel
 * metodos contra la base de datos
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public class PlatoServicio {
    /**
     * repositorio de platos, via de comunicacion a bajo nivel
     */
    IPlatoRepositorio repositorio;
    
    public PlatoServicio(IPlatoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public String calcularCosto(int idCliente){
        return repositorio.calcularCosto(idCliente);
    }
    public String savePlatoEspecial(PlatoEspecial plato){
        //hacer validaciones aqui
        return repositorio.savePlatoEspecial(plato);
    }
    public String addPedido(Pedido pedido){
        return repositorio.addPedido(pedido);
    }
    public String addRacionPedido(RacionPed racionPed){
        return repositorio.addRacionPedido(racionPed);
    }
    public String addPlatoEspecialPedido(PlatoEspecialPed platoEspecialPed){
        return repositorio.addPlatoEspecialPedido(platoEspecialPed);
    }
}
