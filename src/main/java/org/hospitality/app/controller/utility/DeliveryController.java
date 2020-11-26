package org.hospitality.app.controller.utility;

import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.factory.utility.DeliveryFactory;
import org.hospitality.app.service.utility.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hospitality_db/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/create")
    public Delivery create(@RequestBody Delivery delivery) {
        Delivery newDelivery = DeliveryFactory.createDelivery(delivery.getRoomNumber(),delivery.getServiceType());
        return deliveryService.create(newDelivery);
    }

    @GetMapping("/update")
    public Delivery update(@RequestBody Delivery s)
    {
        return deliveryService.update(s);
    }

    @GetMapping("/read/{roomNumber}")
    public Delivery read(@PathVariable String roomNumber)
    {
        return deliveryService.read(roomNumber);
    }

    @GetMapping("/all")
    public Set<Delivery> getAll(){
        return deliveryService.getAll();
    }

    @DeleteMapping("/delete/{roomNumber}")
    public boolean delete(@PathVariable String roomNumber)
    {
        return deliveryService.delete(roomNumber);
    }
}
