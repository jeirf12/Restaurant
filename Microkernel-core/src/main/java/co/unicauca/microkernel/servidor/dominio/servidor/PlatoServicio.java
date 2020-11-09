/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.servidor.dominio.servidor;

import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.RacionDia;
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

    /**
     * modifica un plato especial en la base de datos
     * @param plato informacion del plato a modificar
     * @return retorna "FALLO" en caso en caso de errar
     */
    public String updatePlatoEspecial(PlatoEspecial plato){
        //hacer validaciones, conversion del valor
        return repositorio.updatePlatoEspecial(plato);
    }
    
    /**
     * modifica una racion en la base de datos
     * @param racion informacion a modificar
     * @return retorno "FALLO" en caso de error
     */
    public String updateRacion(RacionDia racion){
        //hacer validaciones, conversion del valor
        return repositorio.updateRacion(racion);
    }

    public String saveRestaurant(Restaurante restaurant){
        return repositorio.saveRestaurant(restaurant);
    }
    public String listMenuDay(int resId,String dia){
        return repositorio.listMenuDay(resId,dia);
    }
    public String listMenuSpecial(int resId){
        return repositorio.listMenuSpecial(resId);
    }
}
