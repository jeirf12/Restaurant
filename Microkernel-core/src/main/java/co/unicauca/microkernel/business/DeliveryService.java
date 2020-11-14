package co.unicauca.microkernel.business;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;
import co.unicauca.microkernel.plugin.manager.DeliveryPluginManager;

public class DeliveryService {

    public double calculateDeliveryCost(Delivery deliveryData) throws Exception {

        String resCode = deliveryData.getResCode();
        DeliveryPluginManager manager = DeliveryPluginManager.getInstance();
        IDeliveryPlugin plugin = manager.getDeliveryPlugin(resCode);

        if (plugin == null) {
            throw new Exception("No hay un plugin disponible para el Restaurante indicado: " + resCode);
        }

        return plugin.calculateCost(deliveryData);

    }

}
