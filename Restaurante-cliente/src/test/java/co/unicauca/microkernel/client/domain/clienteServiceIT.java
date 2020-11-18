/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.client.domain;

import co.unicauca.microkernel.client.access.Factory;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.common.entities.CategoriaEnum;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.RacionDia;
import co.unicauca.microkernel.common.entities.Restaurante;
import java.util.ArrayList;
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
        Restaurante restaurant = new Restaurante(0,1, "mx", "Burrito Sabanero", null, 30,30);
        String expResult = "Burrito Sabanero";
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
        RacionDia racion = new RacionDia(0, CategoriaEnum.CARNE, 13000, "carne de borrego", 1, null);
        String expResult = "carne de borrego";
        String result = instance.saveRacionDia(racion,1);
        int idrac=0;
        platosDias=instance.listMenuDayAll(1, "administrador");
        for (RacionDia pdia : platosDias) {
            if (pdia.getNombre().equals("carne de borrego")) {
                idrac=pdia.getRacId();
                break;
            }
        }
        instance.deleteRacionDia(idrac);
        assertEquals(expResult, result);
    }
    /**
     * Test of savePlatoEspecial method, of class clienteService.
     * @throws java.lang.Exception
     */
    @Test
    public void testSavePlatoEspecial() throws Exception {
        System.out.println("savePlatoEspecial");
        PlatoEspecial plato = new PlatoEspecial(0, 1, "Arroz chino", "rendidor", 13000, null);
        String expResult = "Arroz chino";
        String result = instance.savePlatoEspecial(plato);
        int idpes=0;
        platosEspeciales=instance.listMenuSpecial(1, "administrador");
        for (PlatoEspecial pesp : platosEspeciales) {
            if (pesp.getNombre().equals("Arroz chino")) {
                idpes=pesp.getId_pe();
                break;
            }
        };
        instance.deletePlatoEspecial(idpes);
        assertEquals(expResult, result);
    }

    /**
     * Test of updatePlatoEspecial method, of class clienteService.
     * @throws java.lang.Exception
     */
    @Test
    public void testSupdatePlatoEspecial() throws Exception {
        int idPlatoespecial=0;
        PlatoEspecial plaesp=new PlatoEspecial(0, 1, "Bandeja paisa", "rica y nutritiva", 124000, null);
        instance.savePlatoEspecial(plaesp);
        
        platosEspeciales=instance.listMenuSpecial(1, "administrador");
        System.out.println("updatePlatoEspecial");
        PlatoEspecial plato = new PlatoEspecial(0, 1, "Hoja de achotes", "natural", 12000, null);
        //esta forma de obtener el codigo no es la mas optima
        //debido a que el codigo del plato es incremental
        //toca buscar la forma de obtener ese codigo
        //implementar
        for (PlatoEspecial pesp : platosEspeciales) {
            if (pesp.getNombre().equals("Bandeja paisa") && pesp.getMenuEsp()==1) {
                idPlatoespecial=pesp.getId_pe();
                break;
            }
        }
        plato.setId_pe(idPlatoespecial);
        
        boolean expResult = true;
        boolean result = instance.updatePlatoEspecial(plato);
        instance.deletePlatoEspecial(idPlatoespecial);
        assertEquals(expResult, result);
        
    }
    /**
     * Test of updateRacion method, of class clienteService.
     * @throws java.lang.Exception
     */
    @Test
    public void testSupdateRacion() throws Exception {
        int idracion=0;
        RacionDia racion=new RacionDia(0, CategoriaEnum.BASE, 12000, "Arroz con pollo", 1, null);
        instance.saveRacionDia(racion,1);
        
        platosDias=instance.listMenuDayAll(1,"administrador");
        System.out.println("updateRacion");
        RacionDia racionActualizar = new RacionDia(0, CategoriaEnum.BASE, 13000, "Arroz con pimenton", 1, null);
        //esta forma de obtener el codigo no es la mas optima
        //debido a que el codigo del plato es incremental
        //toca buscar la forma de obtener ese codigo
        //implementar
        for (RacionDia rac : platosDias) {
            if (rac.getNombre().equals("Arroz con pollo") && rac.getMenuId()==1) {
                idracion=rac.getRacId();
                break;
            }
        }
        racionActualizar.setRacId(idracion);
        boolean expResult = true;
        boolean result = instance.updateRacion(racionActualizar);
        instance.deleteRacionDia(idracion);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of deletePlatoEspecial method, of class clienteService.
     * @throws java.lang.Exception
     */
    @Test
    public void testTdeletePlatoEspecial() throws Exception {
        System.out.println("deletePlatoEspecial");
        int plae_id = 0;
        PlatoEspecial plaespe=new PlatoEspecial(0, 1, "arroz con yuca", "delicioso!", 23000, null);
        instance.savePlatoEspecial(plaespe);
        
        platosEspeciales=instance.listMenuSpecial(1, "administrador");
        //esta forma de obtener el codigo no es la mas optima
        //debido a que el codigo del plato es incremental
        //toca buscar la forma de obtener ese codigo
        //implementar
        for (PlatoEspecial pesp : platosEspeciales) {
            if (pesp.getNombre().equals("arroz con yuca") && pesp.getMenuEsp()==1) {
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
   @Test
    public void testTdeleteRacionDia() throws Exception {
        System.out.println("deleteRacionDia");
        int rac_id=0;
        RacionDia racion=new RacionDia(0, CategoriaEnum.PRINCIPIO, 12000, "lentejas", 1, null);
        instance.saveRacionDia(racion,1);
        
        platosDias=instance.listMenuDayAll(1, "administrador");
         //esta forma de obtener el codigo no es la mas optima
        //debido a que el codigo del plato es incremental
        //toca buscar la forma de obtener ese codigo
        //implementar
        for (RacionDia rac : platosDias) {
            if (rac.getNombre().equals("lentejas") && rac.getMenuId()==1) {
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
    @Test
    public void testListMenuDay() throws Exception {
        System.out.println("listMenuDay");
        //Usuario Administrador
        //INSERT INTO `cliente` (`CLI_ID`, `CLI_NOMBRE`, `CLI_CARRERA`, `CLI_CALLE`, `CLI_FOTO`,
        //`CLI_TIPO`, `CLI_CONTRASENIA`) 
        //VALUES ('12345', 'Manuel', '40', '30', NULL, 'ADMINISTRADOR', '12345');
        //------------------------------------------------------------------------
        //Restaurante
       // instance.saveRestaurant(new Restaurante(2, 12345,"mx", "Mexicano wey", null, 20, 10));
        //crear menu 15 para este restaurante
        RacionDia rac=new RacionDia(0, CategoriaEnum.BEBIDA, 1200, "Cholados", 15, null);
        instance.saveRacionDia(rac,2);
        //INSERT INTO `menudia` (`MEND_ID`, `RES_ID`, `MEND_DIASEM`) 
        //VALUES ('15', '2', 'LUNES'), ('14', '2', 'MARTES');
        int idrac=0;
        platosDias=instance.listMenuDay(2,"LUNES","administrador");
        for (RacionDia pdia : platosDias) {
            if (pdia.getNombre().equalsIgnoreCase("Cholados") && pdia.getMenuId()==15) {
                idrac=pdia.getRacId();
                break;
            }
        }
        rac.setRacId(idrac);
        List<RacionDia> racdia=new ArrayList<>();
        racdia.add(rac);
        
        String diaSem = "LUNES";
        String resource = "administrador";
        List<RacionDia> expResult = racdia;
        List<RacionDia> result = instance.listMenuDay(2, diaSem, resource);
        instance.deleteRacionDia(idrac);
        assertEquals(expResult.get(0).getNombre(), result.get(0).getNombre());
    }

    /**
     * Test of listMenuSpecial method, of class clienteService.
     * @throws java.lang.Exception
     */
    @Test
    public void testListMenuSpecial() throws Exception {
        System.out.println("listMenuSpecial");
        //Usuario Administrador
        //INSERT INTO `cliente` (`CLI_ID`, `CLI_NOMBRE`, `CLI_CARRERA`, `CLI_CALLE`, `CLI_FOTO`,
        //`CLI_TIPO`, `CLI_CONTRASENIA`) 
        //VALUES ('12345', 'Manuel', '40', '30', NULL, 'ADMINISTRADOR', '12345');
        //------------------------------------------------------------------------
        //Restaurante
       // instance.saveRestaurant(new Restaurante(2, 12345,"mx", "Mexicano wey", null, 20, 10));
        //crear menu 14 para este restaurante
        PlatoEspecial plae=new PlatoEspecial(0, 14,"Arroz con Leche", "rico y rendidor", 12000, null);
        instance.savePlatoEspecial(plae);
        //INSERT INTO `menuespecial` (`MENE_ID`, `RES_ID`) VALUES ('14', '2'), ('15', '2');
        int idpes=0;
        platosEspeciales=instance.listMenuSpecial(2,"administrador");
        for (PlatoEspecial pes : platosEspeciales) {
            if (pes.getNombre().equalsIgnoreCase("arroz con leche") && pes.getMenuEsp()==14) {
                idpes=pes.getId_pe();
                break;
            }
        }
        plae.setId_pe(idpes);
        List<PlatoEspecial> platoEsp=new ArrayList<>();
        platoEsp.add(plae);
        
        String resource = "administrador";
        List<PlatoEspecial> expResult = platoEsp;
        List<PlatoEspecial> result = instance.listMenuSpecial(2, resource);
        instance.deletePlatoEspecial(idpes);
        assertEquals(expResult.get(0).getNombre(), result.get(0).getNombre());
    }

    /**
     * Test of listMenuDayAll method, of class clienteService.
     * @throws java.lang.Exception
     */
    @Test
    public void testListMenuDayAll() throws Exception {
        System.out.println("listMenuDayAll");
        //Usuario Administrador
        //INSERT INTO `cliente` (`CLI_ID`, `CLI_NOMBRE`, `CLI_CARRERA`, `CLI_CALLE`, `CLI_FOTO`,
        //`CLI_TIPO`, `CLI_CONTRASENIA`) 
        //VALUES ('12345', 'Manuel', '40', '30', NULL, 'ADMINISTRADOR', '12345');
        //------------------------------------------------------------------------
        //Restaurante
       // instance.saveRestaurant(new Restaurante(2, 12345,"mx", "Mexicano wey", null, 20, 10));
        //crear menu 14 para este restaurante
        RacionDia rac=new RacionDia(0, CategoriaEnum.CARNE, 12000, "Pollo Asado", 14, null);
        instance.saveRacionDia(rac,2);
        //INSERT INTO `menudia` (`MEND_ID`, `RES_ID`, `MEND_DIASEM`) 
        //VALUES ('15', '2', 'LUNES'), ('14', '2', 'MARTES');
       /* Cliente cl=new Cliente("Manuel", "12345");
        String resul=instance.validarAcceso(cl);
        String [] dat=resul.split("-");
        idRes=Integer.parseInt(dat[1]);*/
        int idrac=0;
        platosDias=instance.listMenuDayAll(2, "administrador");
        for (RacionDia pdia : platosDias) {
            if (pdia.getNombre().equalsIgnoreCase("Pollo Asado") && pdia.getMenuId()==14) {
                idrac=pdia.getRacId();
                break;
            }
        }
        rac.setRacId(idrac);
        List<RacionDia> racdia=new ArrayList<>();
        racdia.add(rac);
        
        String resource = "administrador";
        List<RacionDia> expResult = racdia;
        List<RacionDia> result = instance.listMenuDayAll(2, resource);
        instance.deleteRacionDia(idrac);
        assertEquals(expResult.get(0).getNombre(), result.get(0).getNombre());
        
    }

    /**
     * Test of validarAcceso method, of class clienteService.
     * @throws java.lang.Exception
     */
/*    @Test
    public void testValidarAcceso() throws Exception {
        System.out.println("validarAcceso");
        Cliente cliente = new Cliente("Manuel", "12345");
        String expResult = "ADMINISTRADOR-2-Mexicano wey";
        String result = instance.validarAcceso(cliente);
        assertEquals(expResult, result);
    }
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
