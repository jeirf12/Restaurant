package co.unicauca.microkernel.plugins.mexicano;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
/**
 * Plugin para restaurantes mexicanos
 * @author Jafes
 */
public class MexicanoDeliveryPlugin implements IDeliveryPlugin {

    
    @Override
    public double calculateCostDomicile(Delivery delivery) {
        
        int distancia = (int)(delivery.getDistance());

        double cost;
        
        cost = (distancia*100);
        

        return cost;
    }
    @Override
    public double impuestoRestaurante(Delivery delivery){
        int sumaOrder = delivery.getPrecio();
        
        double cost;
        
        cost = sumaOrder+(sumaOrder*0.19);
        

        return cost;
    }
}
