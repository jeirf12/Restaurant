package co.unicauca.microkernel.servidor.dominio.servidor;

import co.unicauca.microkernel.common.entities.*;

import co.unicauca.microkernel.servidor.acceso.IPlatoRepositorio;

/**
 *comunicacion con la capa de bajo nivel
 * metodos contra la base de datos
 * @author EdynsonMJ
 * @author Jhonny Rosero
 */
public class PlatoServicio {
    /**
     * repositorio de platos, via de comunicacion a bajo nivel
     */
    IPlatoRepositorio repositorio;
    
    public PlatoServicio(IPlatoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public String calcularCosto(int idCliente){
        return repositorio.calcularCosto(idCliente);
    }
    public String savePlatoEspecial(PlatoEspecial plato){
        //hacer validaciones aqui
        return repositorio.savePlatoEspecial(plato);
    }


    /**
     * modifica un plato especial en la base de datos
     * @param plato informacion del plato a modificar
     * @return retorna "FALLO" en caso en caso de errar
     */
    public String updatePlatoEspecial(PlatoEspecial plato){
        //hacer validaciones, conversion del valor
        return repositorio.updatePlatoEspecial(plato);
    }
    
    /**
     * modifica una racion en la base de datos
     * @param racion informacion a modificar
     * @return retorno "FALLO" en caso de error
     */
    public String updateRacion(RacionDia racion){
        //hacer validaciones, conversion del valor
        return repositorio.updateRacion(racion);
    }

    /*
     * 
     * @param rac_id
     * @return 
     */
    public String deleteRacionDia(int rac_id) {
        return repositorio.deleteRacionDia(rac_id);
    }
    /**
     * 
     * @param plae_id
     * @return 
     */
    public String deletePlatoEspecial(int plae_id) {
        return repositorio.deletePlatoEspecial(plae_id);
    }

    public String saveRestaurant(Restaurante restaurant){
        return repositorio.saveRestaurant(restaurant);
    }
    public String listMenuDay(int resId,String dia){
        return repositorio.listMenuDay(resId,dia);
    }
    public String listMenuSpecial(int resId){
        return repositorio.listMenuSpecial(resId);
    }
    public String addPedido(Pedido pedido){
        return repositorio.addPedido(pedido);
    }
    public String addRacionPedido(RacionPed racionPed){
        return repositorio.addRacionPedido(racionPed);
    }
    public String addPlatoEspecialPedido(PlatoEspecialPed platoEspecialPed){
        return repositorio.addPlatoEspecialPedido(platoEspecialPed);
    }
    public String saveRacionDia(RacionDia racion){
        return repositorio.saveRacionDia(racion);
    }
    public String validarAcceso(Cliente cliente) {
        return repositorio.validarAcceso(cliente);
    }
    public String listMenuDayAll(int resId){
        return repositorio.listMenuDayAll(resId);
    } 
}
