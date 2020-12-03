package org.hospitality.app.factory.utility;

import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.util.Helper;

/*
    author: Shaun Donnelly
    desc: Entity for DeliveryFactory
 */

public class DeliveryFactory {
    public static Delivery createDelivery(String roomNumber, String serviceType){
        String deliveryNumber = Helper.generateId();
        Delivery delivery = new Delivery.Builder()
               .setDeliveryNumber(deliveryNumber)
                .setRoomNumber(roomNumber)
                .setServiceType(serviceType)
                .build();
        return delivery;
    }
}
