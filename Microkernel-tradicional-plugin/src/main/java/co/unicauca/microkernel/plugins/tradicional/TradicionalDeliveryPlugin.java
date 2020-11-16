package co.unicauca.microkernel.plugins.tradicional;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

public class TradicionalDeliveryPlugin implements IDeliveryPlugin {

    @Override
    public double calculateCostDomicile(Delivery delivery) {
        
        int total = delivery.getPrecio();
        
        int distancia = (int)(delivery.getDistance());

        double cost;
        
        cost = (distancia*0)+(total*0);
        

        return cost;

    }
    @Override
    public double impuestoRestaurante(Delivery delivery){
        return 0;
    }
}
