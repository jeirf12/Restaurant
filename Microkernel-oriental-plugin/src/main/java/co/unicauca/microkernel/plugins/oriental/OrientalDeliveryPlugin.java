package co.unicauca.microkernel.plugins.oriental;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para restaurantes orientales
 * @author Jafes
 */
public class OrientalDeliveryPlugin implements IDeliveryPlugin {

 
    @Override
    public int calculateCostDomicile(Delivery delivery) {
        
        int distancia = (int)(delivery.getDistance());

        int cost;
        
        cost = (int)(distancia*200);
        

        return cost;
    }
    @Override
    public int impuestoRestaurante(Delivery delivery){
        int sumaOrder = delivery.getPrecio();
        
        int cost;
        
        cost = sumaOrder+(int)(sumaOrder*0.2);
        

        return cost;
    }
}
