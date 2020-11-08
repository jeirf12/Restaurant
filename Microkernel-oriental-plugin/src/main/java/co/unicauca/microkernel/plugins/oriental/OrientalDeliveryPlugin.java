package co.unicauca.microkernel.plugins.oriental;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.PlatoEspecial;
import co.unicauca.microkernel.common.entities.RacionDia;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

public class OrientalDeliveryPlugin implements IDeliveryPlugin {

    /**
     * El cálculo de Colombia es una mezcla de peso y distancia.
     *
     * @param delivery envío
     * @return costo del envío
     */
    public double calculateCost(Delivery delivery) {
        
        int total = delivery.getPrecio();
        
        int distancia = (int)(delivery.getDistance());

        double cost;
        
        cost = (distancia*0)+total;
        

        return cost;

    }
}
