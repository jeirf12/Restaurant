/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.access.Factory;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.clienteService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EdynsonMJ
 */
public class test_edynson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        /*EdynsonModificarRacion ed = new EdynsonModificarRacion();
        ed.setVisible(true); 
        EdynsonModificarPlato mod = new EdynsonModificarPlato();
        mod.setVisible(true);*/
        List<String> l = new ArrayList<String>();
        l.add("1");
        FramePrincipalAdmin f = new FramePrincipalAdmin(l);
        f.setVisible(true);
    }   
}