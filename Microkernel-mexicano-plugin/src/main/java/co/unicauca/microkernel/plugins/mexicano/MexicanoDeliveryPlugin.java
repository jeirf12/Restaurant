package co.unicauca.microkernel.plugins.mexicano;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para envios a Mexico
 * @author Libardo, Julio
 */
public class MexicanoDeliveryPlugin implements IDeliveryPlugin {

    
    @Override
    public double calculateCostDomicile(Delivery delivery) {

        int total = delivery.getPrecio();
        
        int distancia = (int)(delivery.getDistance());

        double cost;
        
        cost = (distancia)+(total*1000);
        

        return cost;
    }
    @Override
    public double impuestoRestaurante(Delivery delivery){
        return 0;
    }
}
