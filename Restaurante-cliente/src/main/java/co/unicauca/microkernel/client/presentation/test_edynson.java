/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.access.Factory;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.clienteService;

/**
 *
 * @author EdynsonMJ
 */
public class test_edynson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        /*IClienteAccess service = Factory.getInstance().getClienteService();
        clienteService servicioRestaurante = new clienteService(service);*/
        /**atributos plato especial: 
         * PLAE_DESCRIPCION
         * PLAE_FOTO
         * PLAE_NOMBRE
         * PLAE_PRECIO
         **/
        //clave, atributo, valor
        //servicioRestaurante.updatePlatoEspecial(1, "PLAE_PRECIO", "30000");
        
        /**atributos plato especial: 
         * MEND_ID
         * RAC_NOMBRE
         * RAC_FOTO
         * RAC_TIPO: Base, Entrada, Principio, Carne, Bebida
         * RAC_PRECIO
         **/
        /*if(servicioRestaurante.updateRacion(1, "RAC_PRECIO", "345346")){
            System.out.println("EXITO PERRO");
        }else{
            System.out.println("FALLO PERRO");
        }
        System.out.println("hola");*/
        FrameEdynson ed = new FrameEdynson();
        ed.setVisible(true);
    }   
}