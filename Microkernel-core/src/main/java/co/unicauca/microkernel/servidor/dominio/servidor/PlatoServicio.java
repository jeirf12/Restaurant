/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.servidor.dominio.servidor;

import co.unicauca.microkernel.common.entities.Pedido;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.Restaurante;
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

    public String calcularCosto(int idCliente, int idPedido){
        return repositorio.calcularCosto(idCliente, idPedido);
    }
    public String savePlatoEspecial(PlatoEspecial plato){
        //hacer validaciones aqui
        return repositorio.savePlatoEspecial(plato);
    }
}
