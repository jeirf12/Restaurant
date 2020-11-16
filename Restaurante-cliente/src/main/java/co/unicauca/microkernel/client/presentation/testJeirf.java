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
import co.unicauca.microkernel.common.entities.RacionDia;
import static java.lang.System.out;
import java.util.List;

/**
 *
 * @author fallen
 */
public class testJeirf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var service = getInstance().getClienteService();
        var servicioRestaurante = new clienteService(service);
        try {
            List<RacionDia> pdia=servicioRestaurante.listMenuDay(1, "LUNES", "administrador");
            List<PlatoEspecial> pes=servicioRestaurante.listMenuSpecial(1, "administrador");
            List<RacionDia> pdiaAll=servicioRestaurante.listMenuDayAll(1, "administrador");
            for (RacionDia rdia : pdia) {
                System.out.println("valor rdia: "+rdia.getNombre());
            }
            for (var pe : pes) {
                out.println("valor pes: "+pe.getNombre());
            }
            for (RacionDia rdia : pdiaAll) {
                System.out.println("valor rdiaAll: "+rdia.getNombre());
            }
            
        } catch (Exception e) {
            out.println("FALLO PERRAS");
        }
        
    }
    
}
