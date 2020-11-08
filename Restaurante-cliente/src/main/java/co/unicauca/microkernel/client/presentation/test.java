/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.access.Factory;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.clienteService;
import co.unicauca.microkernel.common.entities.*;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
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
        
        MenuEspecial menuEspecial = new MenuEspecial(366,1);
        PlatoEspecial platoEspecial = new PlatoEspecial(1,menuEspecial.getId(),"Nombre","Descripcion",123);
        Clock cl = Clock.systemUTC();
        LocalDateTime date = LocalDateTime.now();
        Pedido pedido = new Pedido(1,1,1,EstadoPed.CREADO,LocalDateTime.of(date.getYear(),date.getMonth(),date.getDayOfMonth(),date.getHour(),date.getMinute()));
        try{
            String platoE = servicioRestaurante.addPedido(pedido);
            System.out.println(date);
            System.out.println(platoE);
            
        }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "El plato ya esta registrado" + ex.getMessage());
        }
    }
    
}
