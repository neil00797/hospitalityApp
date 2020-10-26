package org.hospitality.app.service.utility.impl;

import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.repository.utility.DeliveryRepository;
import org.hospitality.app.service.utility.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    private static DeliveryService service = null;
    @Autowired
    private DeliveryRepository repository;

    /*  private DeliveryServiceImpl(){
          this.repository = DeliveryRepositoryImpl.getRepository();
      }

      public static DeliveryService getService(){
          if (service == null)
              service = new DeliveryServiceImpl();
          return service;
      }*/
    @Override
    public Set<Delivery> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Delivery> getNewService() {
        Set<Delivery> deliveries = getAll();
        Set<Delivery> deliveryServiceByName = new HashSet<>();

        for (Delivery delivery : deliveries) {
            if (delivery.getServiceType().equalsIgnoreCase("Medication Collection")) {
                deliveryServiceByName.add(delivery);
            }
        }
        return deliveryServiceByName;
    }


    @Override
    public Delivery create(Delivery delivery) {
        return this.repository.save(delivery);
    }

    @Override
    public Delivery read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Delivery update(Delivery delivery) {
        if (this.repository.existsById(delivery.getDeliveryNumber())) {
            return this.repository.save(delivery);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
         this.repository.deleteById(s);
         if(this.repository.existsById(s))
             return false;

         else return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryServiceImpl that = (DeliveryServiceImpl) o;
        return repository.equals(that.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repository);
    }
}
