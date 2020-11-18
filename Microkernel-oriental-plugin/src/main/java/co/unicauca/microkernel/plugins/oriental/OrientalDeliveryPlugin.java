package co.unicauca.microkernel.plugins.oriental;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para restaurantes orientales
 * @author Jafes
 */
public class OrientalDeliveryPlugin implements IDeliveryPlugin {

 
    @Override
    public double calculateCostDomicile(Delivery delivery) {
        
        int distancia = (int)(delivery.getDistance());

        double cost;
        
        cost = (distancia*200);
        

        return cost;
    }
    @Override
    public double impuestoRestaurante(Delivery delivery){
        int sumaOrder = delivery.getPrecio();
        
        double cost;
        
        cost = sumaOrder+(sumaOrder*0.2);
        

        return cost;
    }
}
