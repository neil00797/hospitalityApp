package org.hospitality.app.service.utility;

import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.service.IService;

import java.util.Set;

public interface DeliveryService extends IService <Delivery, String> {
        Set<Delivery> getAll();

}

