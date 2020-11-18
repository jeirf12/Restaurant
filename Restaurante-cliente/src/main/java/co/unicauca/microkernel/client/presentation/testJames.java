/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.access.Factory;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.clienteService;
import co.unicauca.microkernel.common.entities.HistorialPed;
import co.unicauca.microkernel.common.entities.Restaurante;
import java.util.ArrayList;
import java.util.List;
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
        List<HistorialPed> restaurante = new ArrayList<>();
        IClienteAccess service = Factory.getInstance().getClienteService();
        clienteService servicioRestaurante = new clienteService(service);    
        String rac_id = "";
        try{
            restaurante = servicioRestaurante.listHistoryPed(1,"PAGADO");
            System.out.println("tamaño lista"+restaurante.size());
            
        }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "la racion no existe" + ex.getMessage());
        }
    
    
    }
    
    
}
