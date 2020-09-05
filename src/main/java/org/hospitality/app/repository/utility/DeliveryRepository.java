package org.hospitality.app.repository.utility;
/*
    author: @Shaun Donnelly
    desc: DeliveryRepository
    date: 24-08-2020
 */
import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.repository.IRepository;

import java.util.Set;

public interface DeliveryRepository extends IRepository<Delivery, String> {
    Set<Delivery> getAll();
}
