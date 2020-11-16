package co.unicauca.microkernel.client.domain;

import co.unicauca.microkernel.client.access.IClienteAccess;
import java.util.List;
import co.unicauca.microkernel.common.entities.*;

/**
 * servicios que el cliente puede usar del servidor (mascaras)
 * se comunica con la capa de bajo nivel que envia la solicitud
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public class clienteService {
    private final IClienteAccess service;
    /**
     * inyeccion de dependencias
     * @param service un clase concreta que implementa la interfaz de acceso, se instancia con una fabrica
     */
    public clienteService(IClienteAccess service) {
        this.service = service;
    }
    public String calcularCosto(int idCliente)throws Exception{
        
        return service.calcularCosto(idCliente);
    }
    public String saveRestaurant(Restaurante restaurant) throws Exception{
        return service.saveRestaurant(restaurant);
    }
    public String savePlatoEspecial(PlatoEspecial plato) throws Exception{
        return service.savePlatoEspecial(plato);
    }
    public String saveRacionDia(RacionDia racion) throws Exception{
        return service.saveRacionDia(racion);
    }
    /**
     * el cliente solicita la modificacion de un parametro en la base de datos para plato especial
     * @param plato informacion del plato a actualizar
     * @return true si la operacion es exitosa, false si erra
     * @throws Exception 
     */
    public boolean updatePlatoEspecial(PlatoEspecial plato) throws Exception{
        //validaciones
        return service.updatePlatoEspecial(plato);
    }
    
    /**
     * el cliente solicita la modificacion de un parametro en la base de datos para racion
     * @param racion informacion de la racion a actualizar
     * @return true si la operacion es exitosa, false si erra
     * @throws Exception 
     */
    public boolean updateRacion(RacionDia racion) throws Exception{
        //validaciones
        return service.updateRacion(racion);
    }
    public String deleteRacionDia(int rac_id) throws Exception{
        return service.deleteRacionDia(rac_id);
    }
    public String deletePlatoEspecial(int plae_id) throws Exception{
        return service.deletePlatoEspecial(plae_id);
    }
    public String addPedido(Pedido pedido) throws Exception{
        return service.addPedido(pedido);
    }
    public String addRacionPedido(RacionPed racionPed) throws Exception{
        return service.addRacionPedido(racionPed);
    }
    public String addPlatoEspecialPedido(PlatoEspecialPed platoEspecialPed) throws Exception{
        return service.addPlatoEspecialPedido(platoEspecialPed);
    }
    public List<RacionDia> listMenuDay(int idRes,String diaSem,String resource)throws Exception{
        return service.listMenuDay(idRes, diaSem, resource);
    }
    public List<PlatoEspecial> listMenuSpecial(int idRes,String resource)throws Exception{
        return service.listMenuSpecial(idRes, resource);
    }
    public List<RacionDia> listMenuDayAll(int idRes,String resource)throws Exception{
        return service.listMenuDayAll(idRes,resource);
    }
    public String validarAcceso (Cliente cliente)throws Exception{
        return service.validarAcceso(cliente);
    }
}
