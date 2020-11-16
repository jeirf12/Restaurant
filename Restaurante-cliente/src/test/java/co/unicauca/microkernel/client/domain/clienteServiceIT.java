/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.domain;

import co.unicauca.microkernel.client.access.Factory;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.common.entities.CategoriaEnum;
import co.unicauca.microkernel.common.entities.Cliente;
import co.unicauca.microkernel.common.entities.Pedido;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.PlatoEspecialPed;
import co.unicauca.microkernel.common.entities.RacionDia;
import co.unicauca.microkernel.common.entities.RacionPed;
import co.unicauca.microkernel.common.entities.Restaurante;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fallen
 */
public class clienteServiceIT {
    private final IClienteAccess service;
    private final clienteService  instance;
    private List<RacionDia> platosDias;
    private List<PlatoEspecial> platosEspeciales;
    
    public clienteServiceIT() {
        service=Factory.getInstance().getClienteService();
        instance=new  clienteService(service);
    }

    /**
     * Test of saveRestaurant method, of class clienteService.
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveRestaurant() throws Exception {
        System.out.println("saveRestaurant");
        Restaurante restaurant = new Restaurante(0,1324, "mx", "Burrito", null, 30,30);
        String expResult = "Burrito";
        String result = instance.saveRestaurant(restaurant);
        assertEquals(expResult, result);
    }
    /**
     * Test of saveRacionDia method, of class clienteService.
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveRacionDia() throws Exception {
        System.out.println("saveRacionDia");
        RacionDia racion = new RacionDia(0, CategoriaEnum.PRINCIPIO, 13000, "pupa", 12, null);
        String expResult = "pupa";
        String result = instance.saveRacionDia(racion);
        assertEquals(expResult, result);
        platosDias=instance.listMenuDayAll(1, "administrador");
    }
    /**
     * Test of savePlatoEspecial method, of class clienteService.
     * @throws java.lang.Exception
     */
    @Test
    public void testSavePlatoEspecial() throws Exception {
        System.out.println("savePlatoEspecial");
        PlatoEspecial plato = new PlatoEspecial(0, 12, "uncalunca", "uncal", 12000, null);
        String expResult = "uncalunca";
        String result = instance.savePlatoEspecial(plato);
        assertEquals(expResult, result);
        platosEspeciales=service.listMenuSpecial(1, "administrador");
    }

    /**
     * Test of updatePlatoEspecial method, of class clienteService.
     * @throws java.lang.Exception
     */
/*    @Test
    public void testSupdatePlatoEspecial() throws Exception {
        int idPlatoespecial=0;
        
        System.out.println("updatePlatoEspecial");
        PlatoEspecial plato = new PlatoEspecial(0, 12, "uncalunca", "pumpal", 12000, null);
        //esta forma de obtener el codigo no es la mas optima
        //debido a que el codigo del plato es incremental
        //toca buscar la forma de obtener ese codigo
        //implementar
        for (PlatoEspecial pesp : platosEspeciales) {
            if (pesp.getNombre().equals("uncalunca") && pesp.getMenuEsp()==12) {
                idPlatoespecial=pesp.getId_pe();
                break;
            }
        }
        plato.setId_pe(idPlatoespecial);
        boolean expResult = true;
        boolean result = instance.updatePlatoEspecial(plato);
        platosEspeciales=service.listMenuSpecial(1, "administrador");
        assertEquals(expResult, result);
    }
    /**
     * Test of updateRacion method, of class clienteService.
     * @throws java.lang.Exception
     */
/*    @Test
    public void testSupdateRacion() throws Exception {
        int idracion=0;
        System.out.println("updateRacion");
        RacionDia racion = new RacionDia(0, CategoriaEnum.BASE, 13000, "pupa", 12, null);
        //esta forma de obtener el codigo no es la mas optima
        //debido a que el codigo del plato es incremental
        //toca buscar la forma de obtener ese codigo
        //implementar
        for (RacionDia rac : platosDias) {
            if (rac.getNombre().equals("pupa") && rac.getMenuId()==12) {
                idracion=rac.getRacId();
                break;
            }
        }
        racion.setRacId(idracion);
        boolean expResult = true;
        boolean result = instance.updateRacion(racion);
        platosDias=instance.listMenuDayAll(1, "administrador");
        assertEquals(expResult, result);
    }
    
     /**
     * Test of deletePlatoEspecial method, of class clienteService.
     * @throws java.lang.Exception
     */
/*    @Test
    public void testTdeletePlatoEspecial() throws Exception {
        System.out.println("deletePlatoEspecial");
        int plae_id = 0;
        //esta forma de obtener el codigo no es la mas optima
        //debido a que el codigo del plato es incremental
        //toca buscar la forma de obtener ese codigo
        //implementar
        for (PlatoEspecial pesp : platosEspeciales) {
            if (pesp.getNombre().equals("uncalunca") && pesp.getMenuEsp()==12) {
                plae_id=pesp.getId_pe();
                break;
            }
        }
        String expResult = ""+plae_id;
        String result = instance.deletePlatoEspecial(plae_id);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteRacionDia method, of class clienteService.
     * @throws java.lang.Exception
     */
/*    @Test
    public void testTdeleteRacionDia() throws Exception {
        System.out.println("deleteRacionDia");
        int rac_id = 0;
         //esta forma de obtener el codigo no es la mas optima
        //debido a que el codigo del plato es incremental
        //toca buscar la forma de obtener ese codigo
        //implementar
        for (RacionDia rac : platosDias) {
            if (rac.getNombre().equals("pupa") && rac.getMenuId()==12) {
                rac_id=rac.getRacId();
                break;
            }
        }
        String expResult = ""+rac_id;
        String result = instance.deleteRacionDia(rac_id);
        assertEquals(expResult, result);
    }

    /**
     * Test of addPedido method, of class clienteService.
     * @throws java.lang.Exception
     */
/*    @Test
    public void testAddPedido() throws Exception {
        System.out.println("addPedido");
        Pedido pedido = null;
        String expResult = "";
        String result = instance.addPedido(pedido);
        assertEquals(expResult, result);
    }

    /**
     * Test of addRacionPedido method, of class clienteService.
     * @throws java.lang.Exception
     */
/*    @Test
    public void testAddRacionPedido() throws Exception {
        System.out.println("addRacionPedido");
        RacionPed racionPed = null;
        String expResult = "";
        String result = instance.addRacionPedido(racionPed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPlatoEspecialPedido method, of class clienteService.
     * @throws java.lang.Exception
     */
 /*   @Test
    public void testAddPlatoEspecialPedido() throws Exception {
        System.out.println("addPlatoEspecialPedido");
        PlatoEspecialPed platoEspecialPed = null;
        String expResult = "";
        String result = instance.addPlatoEspecialPedido(platoEspecialPed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of listMenuDay method, of class clienteService.
     * @throws java.lang.Exception
     */
/*    @Test
    public void testListMenuDay() throws Exception {
        System.out.println("listMenuDay");
        int idRes = 0;
        String diaSem = "";
        String resource = "";
        List<RacionDia> expResult = null;
        List<RacionDia> result = instance.listMenuDay(idRes, diaSem, resource);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listMenuSpecial method, of class clienteService.
     * @throws java.lang.Exception
     */
/*    @Test
    public void testListMenuSpecial() throws Exception {
        System.out.println("listMenuSpecial");
        int idRes = 0;
        String resource = "";
        List<PlatoEspecial> expResult = null;
        List<PlatoEspecial> result = instance.listMenuSpecial(idRes, resource);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listMenuDayAll method, of class clienteService.
     * @throws java.lang.Exception
     */
/*    @Test
    public void testListMenuDayAll() throws Exception {
        System.out.println("listMenuDayAll");
        int idRes = 0;
        String resource = "";
        List<RacionDia> expResult = null;
        List<RacionDia> result = instance.listMenuDayAll(idRes, resource);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarAcceso method, of class clienteService.
     * @throws java.lang.Exception
     */
/*    @Test
    public void testValidarAcceso() throws Exception {
        System.out.println("validarAcceso");
        Cliente cliente = null;
        String expResult = "";
        String result = instance.validarAcceso(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
      /**
     * Test of calcularCosto method, of class clienteService.
     * @throws java.lang.Exception
     */
/*    @Test
    public void testCalcularCosto() throws Exception {
        System.out.println("calcularCosto");
        int idCliente = 1423;
        String expResult = "";
        String result = instance.calcularCosto(idCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
