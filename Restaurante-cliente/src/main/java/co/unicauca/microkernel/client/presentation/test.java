/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.access.Factory;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.clienteService;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.Restaurante;
import co.unicauca.microkernel.common.infra.Utilities;
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
        //PlatoEspecial platoEspecial = new PlatoEspecial(3,1,"Nombre","Descripcion",123,null);
        //Si devuelve nulo, entonces significa que no encontro la ruta de la foto
        byte [] photoRestaurant=Utilities.convertirFoto("/home/fallen/Imágenes/imagen1.png");
        
        Restaurante res=new Restaurante(2,"co","pipo",photoRestaurant,"calle31");
        try{
            String restaurante =servicioRestaurante.saveRestaurant(res);
            System.out.println(restaurante);
            
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "El restaurante ya esta registrado" + ex.getMessage());
        }
    }
    
}
