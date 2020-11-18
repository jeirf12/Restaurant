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
    private final IPlatoRepositorio repositorio;
    
    public PlatoServicio(IPlatoRepositorio repositorio) {
        this.repositorio = repositorio;
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
    public String saveRacionDia(RacionDia racion,int idRestaurante){
        return repositorio.saveRacionDia(racion,idRestaurante);
    }

    public String payedPedido(Pedido pedido){
        return repositorio.payedPedido(pedido);
    }
    public String cancelPedido(Pedido pedido){
        return repositorio.cancelPedido(pedido);
    }
    public String deleteRacionPedido(int idRacionPedido){
        return repositorio.deleteRacionPedido(idRacionPedido);
    }
    public String deletePlatoEspecialPedido(int idPlatoEspecialPedido){
        return repositorio.deletePlatoEspecialPedido(idPlatoEspecialPedido);
    }



   public String validarAcceso(Cliente cliente){
       return repositorio.validarAcceso(cliente);
   }

    
    public String listMenuDayAll(int resId){
        return repositorio.listMenuDayAll(resId);
    }
    public String listPedido(int idRestaurante){
        return repositorio.listaPedido(idRestaurante);
    }
    public String listRestaurante(String typeRestaurante){
        return repositorio.listRestaurante(typeRestaurante);
    }
    public String listCarritoRacion(int idCliente, int idPedido){
        return repositorio.listCarritoRacion(idCliente, idPedido);
    } 
    public String listCarritoPlatoEspecial(int idCliente, int idPedido){
        return repositorio.listCarritoPlatoEspecial(idCliente, idPedido);
    }
    public String aumentarCantidad(String typeOrden,int idOrden, int cantidadActual){
        return repositorio.aumentarCantidad(typeOrden, idOrden, cantidadActual);
    }
    public String disminuirCantidad(String typeOrden,int idOrden, int cantidadActual){
        return repositorio.disminuirCantidad(typeOrden, idOrden, cantidadActual);
    }
    public String sumOrder(int idCliente, int idPedido){
        return repositorio.sumOrder(idCliente, idPedido);
    }
    public String priceDomicileOrder(int idCliente, int idPedido){
        return repositorio.priceDomicileOrder(idCliente, idPedido);
    }
    public String impuestoRestaurante(int idCliente, int idPedido){
        return repositorio.impuestoRestaurante(idCliente, idPedido);
    }   
    public String total(int idCliente, int idPedido){
        return repositorio.total(idCliente, idPedido);
    }
    public String listHistoryPed(int idCliente, String estado){
        return repositorio.listHistoryPed(idCliente, estado);
    }

}
