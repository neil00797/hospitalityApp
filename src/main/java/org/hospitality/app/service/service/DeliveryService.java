package org.hospitality.app.service.service;

import org.hospitality.app.entity.service.Delivery;
import org.hospitality.app.service.IService;

import java.util.Set;

public interface DeliveryService extends IService <Delivery, String> {
        Set<Delivery> getAll();

}

