package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.access.Factory;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.clienteService;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonny Rosero
 */
public class test_delete {
    public static void main(String[] args) {
        IClienteAccess service = Factory.getInstance().getClienteService();
        clienteService servicioRestaurante = new clienteService(service);
        
        int rac_id = 1;
        try{
            rac_id = Integer.parseInt(servicioRestaurante.deleteRacionDia(rac_id));
            System.out.println(rac_id+"==racion eliminada");
            
        }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "la racion no existe" + ex.getMessage());
        }
        
        int plae_id = 1;
        try{
            plae_id = Integer.parseInt(servicioRestaurante.deletePlatoEspecial(plae_id));
            System.out.println(plae_id+"==plato eliminado");
            
        }catch(Exception ex) {
                JOptionPane.showMessageDialog(null, "El plato no existe" + ex.getMessage());
        }
    }
}
