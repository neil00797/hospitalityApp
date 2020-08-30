package org.hospitality.app.repository.service;
/*
    author: @Shaun Donnelly
    desc: DeliveryRepository
    date: 24-08-2020
 */
import org.hospitality.app.entity.service.Delivery;
import org.hospitality.app.repository.IRepository;

import java.util.Set;

public interface DeliveryRepository extends IRepository<Delivery, String> {
    Set<Delivery> getAll();
}
