/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.domain;

import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.Restaurante;
import java.util.List;

/**
 * servicios que el cliente puede usar del servidor (mascaras)
 * se comunica con la capa de bajo nivel que envia la solicitud
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public class clienteService {
    private final IClienteAccess service;
    /**
     * inyeccion de dependencias
     * @param service un clase concreta que implementa la interfaz de acceso, se instancia con una fabrica
     */
    public clienteService(IClienteAccess service) {
        this.service = service;
    }
    public String calcularCosto(int idCliente, int idPedido)throws Exception{
        
        return service.calcularCosto(idCliente, idPedido);
    }
    public String saveRestaurant(Restaurante restaurant) throws Exception{
        return service.saveRestaurant(restaurant);
    }
    public String savePlatoEspecial(PlatoEspecial plato) throws Exception{
        return service.savePlatoEspecial(plato);
    }
    
    //
    public String deleteRacionDia(int rac_id) throws Exception{
        return service.deleteRacionDia(rac_id);
    }
    //
    public String deletePlatoEspecial(int plae_id) throws Exception{
        return service.deletePlatoEspecial(plae_id);
    }
}
