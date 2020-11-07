/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.domain;

import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.common.entities.PlatoEspecial;

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
    public String savePlatoEspecial(PlatoEspecial plato) throws Exception{
        return service.savePlatoEspecial(plato);
    }
    
    /**
     * el cliente solicita la modificacion de un parametro en la base de datos para plato especial
     * @param clave identificador del plato
     * @param atributo columna a ser modificada
     * @param valor nuevo valor a almacenar
     * @return true si la operacion es exitosa, false si erra
     * @throws Exception 
     */
    public boolean updatePlatoEspecial(int clave, String atributo, String valor) throws Exception{
        //validaciones
        return service.updatePlatoEspecial(clave, atributo, valor);
    }
    
    /**
     * el cliente solicita la modificacion de un parametro en la base de datos para racion
     * @param clave identificador de la racion
     * @param atributo columna a ser modificada
     * @param valor nuevo valor a almacenar
     * @return true si la operacion es exitosa, false si erra
     * @throws Exception 
     */
    public boolean updateRacion(int clave, String atributo, String valor) throws Exception{
        //validaciones
        return service.updateRacion(clave, atributo, valor);
    }
}
