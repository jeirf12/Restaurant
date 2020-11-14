/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.access.Factory;
import static co.unicauca.microkernel.client.access.Factory.getInstance;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.clienteService;


import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.Restaurante;
import co.unicauca.microkernel.common.infra.Utilities;
import co.unicauca.microkernel.common.entities.*;
import static co.unicauca.microkernel.common.entities.CategoriaEnum.BEBIDA;
import static co.unicauca.microkernel.common.entities.DiaEnum.DOMINGO;
import static co.unicauca.microkernel.common.infra.Utilities.convertirFoto;
import static java.lang.System.out;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author jafes
 */
public class testCrear {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        var service = getInstance().getClienteService();
        var servicioRestaurante = new clienteService(service);
        //MenuEspecial menuEspecial = new MenuEspecial(366,1);
        //PlatoEspecial platoEspecial = new PlatoEspecial(3,1,"Nombre","Descripcion",123,null);
        //Si devuelve nulo, entonces significa que no encontro la ruta de la foto
        var photoRestaurant=convertirFoto("C:\\Users\\Camilo Gonzalez\\Desktop\\prueba\\ss.png");
       var res=new Restaurante(2,"co","pipo",photoRestaurant,"calle31");
        var menuEspecial = new MenuEspecial(366,1);
        var platoEspecial = new PlatoEspecial(74,menuEspecial.getId(),"Nombre","Descripcion",123,photoRestaurant);
        try{
            var restaurante =servicioRestaurante.saveRestaurant(res);
            out.println(restaurante);
            
        }catch(Exception ex) {
            showMessageDialog(null, "El restaurante ya esta registrado" + ex.getMessage());
        }

        var menuDia = new MenuDia(123, DOMINGO,1);
        var racion = new RacionDia(44, BEBIDA,55,"cocacola",menuDia.getIdMenu(),photoRestaurant);
        
        try{
            var racionD = servicioRestaurante.saveRacionDia(racion);
            out.println(racionD);
            
        }catch(Exception ex) {
                showMessageDialog(null, "La racion ya esta registrada" + ex.getMessage());
        }

    }
    
}
