/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.access.Factory;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.clienteService;
import co.unicauca.microkernel.common.entities.CategoriaEnum;
import co.unicauca.microkernel.common.entities.DiaEnum;
import co.unicauca.microkernel.common.entities.MenuDia;
import co.unicauca.microkernel.common.entities.MenuEspecial;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.RacionDia;
import co.unicauca.microkernel.common.infra.Utilities;
import javax.swing.JOptionPane;

/**
 *
 * @author jafes
 */
public class testCrear {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        IClienteAccess service = Factory.getInstance().getClienteService();
        clienteService servicioRestaurante = new clienteService(service);
        
        //Si devuelve nulo, entonces significa que no encontro la ruta de la foto
        byte [] photoRestaurant=Utilities.convertirFoto("C:\\Users\\Camilo Gonzalez\\Desktop\\prueba\\ss.png");
       
        MenuEspecial menuEspecial = new MenuEspecial(366,1);
        PlatoEspecial platoEspecial = new PlatoEspecial(74,menuEspecial.getId(),"Nombre","Descripcion",123,photoRestaurant);
        try{
            String platoE = servicioRestaurante.savePlatoEspecial(platoEspecial);
            System.out.println(platoE);
            
        }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "El plato ya esta registrado" + ex.getMessage());
        }
        MenuDia menuDia = new MenuDia(123,DiaEnum.Domingo,1);
        RacionDia racion = new RacionDia(44,CategoriaEnum.BEBIDA,55,"cocacola",menuDia.getIdMenu(),photoRestaurant);
        
        try{
            String racionD = servicioRestaurante.saveRacionDia(racion);
            System.out.println(racionD);
            
        }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "La racion ya esta registrada" + ex.getMessage());
        }
    }
    
}
