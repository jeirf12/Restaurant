/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.domain;

import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.common.entities.*;

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
    public String calcularCosto(int idCliente)throws Exception{
        
        return service.calcularCosto(idCliente);
    }
    public String savePlatoEspecial(PlatoEspecial plato) throws Exception{
        return service.savePlatoEspecial(plato);
    }
    public String addPedido(Pedido pedido) throws Exception{
        return service.addPedido(pedido);
    }
    public String addRacionPedido(RacionPed racionPed) throws Exception{
        return service.addRacionPedido(racionPed);
    }
    public String addPlatoEspecialPedido(PlatoEspecialPed platoEspecialPed) throws Exception{
        return service.addPlatoEspecialPedido(platoEspecialPed);
    }
}
