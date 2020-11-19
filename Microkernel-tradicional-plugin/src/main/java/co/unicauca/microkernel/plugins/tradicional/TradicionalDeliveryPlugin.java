package co.unicauca.microkernel.plugins.tradicional;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para restaurantes tipicos
 * @author Jafes
 */
public class TradicionalDeliveryPlugin implements IDeliveryPlugin {

    @Override
    public int calculateCostDomicile(Delivery delivery) {
        
        int distancia = (int)(delivery.getDistance());

        int cost;
        
        cost = (distancia*50);
        

        return cost;
    }
    @Override
    public int impuestoRestaurante(Delivery delivery){
        int sumaOrder = delivery.getPrecio();
        
        int cost;
        
        cost = sumaOrder+(int)(sumaOrder*0.11);
        

        return cost;
    }
}
