package co.unicauca.microkernel.plugins.tradicional;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para restaurantes tipicos
 * @author Jafes
 */
public class TradicionalDeliveryPlugin implements IDeliveryPlugin {

    @Override
    public double calculateCostDomicile(Delivery delivery) {
        
        int distancia = (int)(delivery.getDistance());

        double cost;
        
        cost = (distancia*50);
        

        return cost;
    }
    @Override
    public double impuestoRestaurante(Delivery delivery){
        int sumaOrder = delivery.getPrecio();
        
        double cost;
        
        cost = sumaOrder+(sumaOrder*0.11);
        

        return cost;
    }
}
