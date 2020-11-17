package co.unicauca.microkernel.client.presentation;

import co.unicauca.microkernel.client.access.Factory;
import static co.unicauca.microkernel.client.access.Factory.getInstance;
import co.unicauca.microkernel.client.access.IClienteAccess;
import co.unicauca.microkernel.client.domain.clienteService;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.System.out;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Jhonny Rosero
 */
public class test_delete {
    /*
    public static void main(String[] args) {
        var service = getInstance().getClienteService();
        var servicioRestaurante = new clienteService(service);
        var rac_id = 1;
        try{
            rac_id = parseInt(servicioRestaurante.deleteRacionDia(rac_id));
            out.println(rac_id+"==racion eliminada");
            
        }catch(Exception ex) {
                showMessageDialog(null, "la racion no existe" + ex.getMessage());
        }
        
        var plae_id = 1;
        try{
            plae_id = parseInt(servicioRestaurante.deletePlatoEspecial(plae_id));
            out.println(plae_id+"==plato eliminado");
            
        }catch(Exception ex) {
                showMessageDialog(null, "El plato no existe" + ex.getMessage());
        }
    }*/
}
