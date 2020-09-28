package org.hospitality.app.controller.utility;

import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.factory.utility.DeliveryFactory;
import org.hospitality.app.service.utility.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/create")
    public Delivery create(@RequestBody Delivery delivery) {
        Delivery newDelivery = DeliveryFactory.createDelivery(delivery.getRoomNumber(),delivery.getServiceType());
        return deliveryService.create(newDelivery);
    }

    @GetMapping("/all")
    public Set<Delivery> getAll(){
        return deliveryService.getAll();
    }
}
