/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.servidor.acceso;

import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.RacionDia;
import co.unicauca.microkernel.common.entities.Restaurante;

/**
 *interface del repositorio de platos, usarla mediante inyeccion de dependencias
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public interface IPlatoRepositorio {
 
    public String calcularCosto(int idCliente, int idPedido);
    public String saveRestaurant(Restaurante res);
    public String savePlatoEspecial(PlatoEspecial plato);
    
    /**
     * hace un update sobre la tabla platoEspecial
     * @param clave valor con el que se encuentra la tupla
     * @param atributo columna a modificar
     * @param valor nuevo valor
     * @return 
     */
    public String updatePlatoEspecial(PlatoEspecial plato);
    
    /**
     * hace un update sobre la tabla racion
     * @param racion informacion a modificar
     * @return 
     */
    public String updateRacion(RacionDia racion);

    public String listMenuDay(int idRes,String dia);
    public String listMenuSpecial(int idRes);

}