package org.hospitality.app.repository.utility;
/*
    author: @Shaun Donnelly
    desc: DeliveryRepository
    date: 24-08-2020
 */
import org.hospitality.app.entity.utility.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, String> {
    //Set<Delivery> getAll();
}
