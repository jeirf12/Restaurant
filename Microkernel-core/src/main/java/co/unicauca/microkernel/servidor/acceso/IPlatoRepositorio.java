package co.unicauca.microkernel.servidor.acceso;

import co.unicauca.microkernel.common.entities.*;

/**
 *interface del repositorio de platos, usarla mediante inyeccion de dependencias
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public interface IPlatoRepositorio {
 
    public String saveRestaurant(Restaurante res);

    public String savePlatoEspecial(PlatoEspecial plato);

    /**
     * hace un update sobre la tabla platoEspecial
     * @param plato informacion a modificar
     * @return 
     */
    public String updatePlatoEspecial(PlatoEspecial plato);
    
    /**
     * hace un update sobre la tabla racion
     * @param racion informacion a modificar
     * @return 
     */
    public String updateRacion(RacionDia racion);

    /**
     * 
     * @param rac_id
     * @return 
     */
    public String deleteRacionDia(int rac_id);
    /**
     * 
     * @param plae_id
     * @return 
     */
    public String deletePlatoEspecial(int plae_id);

    public String listMenuDay(int idRes,String dia);
    public String listMenuSpecial(int idRes);
    public String listMenuDayAll(int idRes);

    public String calcularCosto(int idCliente);
    
    public String addPedido(Pedido pedido);
    public String addRacionPedido(RacionPed racionPed);
    public String addPlatoEspecialPedido(PlatoEspecialPed platoEspecialPed);
    public String saveRacionDia(RacionDia racion,int idRestaurante);
    public String validarAcceso(Cliente cliente);
}