/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.access;

import co.unicauca.microkernel.common.infra.Utilities;

/**
 * fabrica que retorna una instancia para el acceso al servidor
 * @author EdynsonMJ
 */
public class Factory {
    private static Factory instance;
    
    private Factory(){
        
    }
    public static Factory getInstance(){
        if(instance == null){
            instance = new Factory();
        }
        return instance;
    }
    /**
     * crea una clase concreta de ClienteAccessSocket que realiza la comunicacion
     * @return 
     */
    public IClienteAccess getClienteService(){
        IClienteAccess result = null;
        String type = Utilities.loadProperty("customer.service");
        switch (type){
            case "default":
                result =new ClienteAccessSocket();
                break;
        }
        return result;
    }
}
