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
import co.unicauca.microkernel.common.entities.*;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import javax.swing.JOptionPane;

/**
 *
 * @author jafes
 */
public class testCrear {

    /**
     * @param args the command line arguments
     */
    /*
   public static void main(String[] args) {
        IClienteAccess service = Factory.getInstance().getClienteService();
        clienteService servicioRestaurante = new clienteService(service);
        


        //MenuEspecial menuEspecial = new MenuEspecial(366,1);
        //PlatoEspecial platoEspecial = new PlatoEspecial(3,1,"Nombre","Descripcion",123,null);
        //Si devuelve nulo, entonces significa que no encontro la ruta de la foto
        byte [] photoRestaurant=Utilities.convertirFoto("C:\\Users\\Camilo Gonzalez\\Desktop\\prueba\\ss.png");
       Restaurante res=new Restaurante(2,"co","pipo",photoRestaurant,"calle31");
        MenuEspecial menuEspecial = new MenuEspecial(366,1);
        PlatoEspecial platoEspecial = new PlatoEspecial(74,menuEspecial.getId(),"Nombre","Descripcion",123,photoRestaurant);
        try{
            String restaurante =servicioRestaurante.saveRestaurant(res);
            System.out.println(restaurante);
            
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "El restaurante ya esta registrado" + ex.getMessage());
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
    */
}
