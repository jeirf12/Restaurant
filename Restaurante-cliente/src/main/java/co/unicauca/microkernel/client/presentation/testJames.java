/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.access.Factory;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.clienteService;
import javax.swing.JOptionPane;

/**
 *
 * @author jafes
 */
public class testJames {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IClienteAccess service = Factory.getInstance().getClienteService();
        clienteService servicioRestaurante = new clienteService(service);    
        String rac_id = "";
        try{
            //rac_id = servicioRestaurante.calcularCosto(3,3);
            System.out.println(rac_id);
            
        }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "la racion no existe" + ex.getMessage());
        }
    
    
    }
    
    
}
