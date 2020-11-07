/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.access;

import co.unicauca.microkernel.common.entities.PlatoEspecial;


/**
 * entidad abstracta del los servicios que el cliente puede solicitar al servidor
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public interface IClienteAccess {
    
    public String calcularCosto(int idCliente, int idPedido)throws Exception;
    public String savePlatoEspecial(PlatoEspecial plato) throws Exception;
    
    //
    public String deleteRacionDia(int rac_id)throws Exception;
    //
    public String deletePlatoEspecial(int plae_id)throws Exception;
}
