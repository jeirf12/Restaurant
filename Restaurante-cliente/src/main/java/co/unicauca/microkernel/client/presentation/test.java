/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.access.Factory;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.clienteService;
import co.unicauca.microkernel.common.entities.MenuEspecial;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import javax.swing.JOptionPane;

/**
 *
 * @author jafes
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IClienteAccess service = Factory.getInstance().getClienteService();
        clienteService servicioRestaurante = new clienteService(service);
        
        //MenuEspecial menuEspecial = new MenuEspecial(366,1);
        PlatoEspecial platoEspecial = new PlatoEspecial(3,1,"Nombre","Descripcion",123,null);
        try{
            String platoE = servicioRestaurante.savePlatoEspecial(platoEspecial);
            System.out.println(platoE);
            
        }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "El plato ya esta registrado" + ex.getMessage());
        }
    }
    
}
