package co.unicauca.microkernel.plugins.mexicano;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para restaurantes mexicanos
 * @author Jafes
 */
public class MexicanoDeliveryPlugin implements IDeliveryPlugin {

    
    @Override
    public int calculateCostDomicile(Delivery delivery) {
        
        double distancia = (delivery.getDistance());

        int cost;
        
        cost = (int)(distancia*100);
        

        return cost;
    }
    @Override
    public int impuestoRestaurante(Delivery delivery){
        int sumaOrder = delivery.getPrecio();
        
        int cost;
        
        cost = sumaOrder+(int)(sumaOrder*0.19);
        

        return cost;
    }
}
