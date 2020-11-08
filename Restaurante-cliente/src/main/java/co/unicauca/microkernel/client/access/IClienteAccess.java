/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.access;

import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.RacionDia;
import co.unicauca.microkernel.common.entities.Restaurante;
import java.util.List;


/**
 * entidad abstracta del los servicios que el cliente puede solicitar al servidor
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public interface IClienteAccess {
    
    public String calcularCosto(int idCliente, int idPedido)throws Exception;
    public String saveRestaurant(Restaurante restaurant) throws Exception;
    public String savePlatoEspecial(PlatoEspecial plato) throws Exception;
    
    //
    public String deleteRacionDia(int rac_id)throws Exception;
    //
    public String deletePlatoEspecial(int plae_id)throws Exception;

    /**
     * Implementacion que se hara en clienteAccessSocket para el recibimiento 
     * de este tipo por parte del servidor que esta devolviendo una respuesta
     * a la solicitud del cliente de listar menu dia
     * 
     * @param idRes
     * @param diaSem
     * @param resource
     * @return
     * @throws Exception 
     */
    public List<RacionDia> listMenuDay(int idRes,String diaSem,String resource)throws Exception;
    /**
     * Implementacion que se hara en clienteAccessSocket para el recibimiento 
     * de este tipo por parte del servidor que esta devolviendo una respuesta
     * a la solicitud del cliente de listar menu especial
     * 
     * @param idRes
     * @param resource
     * @return
     * @throws Exception 
     */
    public List<PlatoEspecial> listMenuSpecial(int idRes,String resource)throws Exception;

}
