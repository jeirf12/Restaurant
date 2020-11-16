package co.unicauca.microkernel.plugins.oriental;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

public class OrientalDeliveryPlugin implements IDeliveryPlugin {

    @Override
    public double calculateCostDomicile(Delivery delivery) {
        
        int total = delivery.getPrecio();
        
        int distancia = (int)(delivery.getDistance());

        double cost;
        
        cost = (distancia*0)+total;
        

        return cost;

    }
    @Override
    public double impuestoRestaurante(Delivery delivery){
        return 0;
    }
}
