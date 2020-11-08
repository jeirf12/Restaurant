/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.servidor.dominio.servidor;

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

    /**
     * modifica un plato especial en la base de datos
     * @param clave identificador del plato
     * @param atributo columna de la base de datos a modificar
     * @param valor nuevo valor de la celda
     * @return retorna "FALLO" en caso en caso de errar
     */
    public String updatePlatoEspecial(String clave, String atributo, String valor){
        //hacer validaciones, conversion del valor
        return repositorio.updatePlatoEspecial(clave, atributo, valor);
    }
    
    /**
     * modifica una racion en la base de datos
     * @param clave identificador de la racion
     * @param atributo columna de la base de datos a modificar
     * @param valor nuevo valor para la celda
     * @return retorno "FALLO" en caso de error
     */
    public String updateRacion(String clave, String atributo, String valor){
        //hacer validaciones, conversion del valor
        return repositorio.updateRacion(clave, atributo, valor);
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
