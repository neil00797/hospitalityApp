package org.hospitality.app.service.service.impl;

import org.hospitality.app.entity.service.Delivery;
import org.hospitality.app.repository.service.DeliveryRepository;
import org.hospitality.app.repository.service.impl.DeliveryRepositoryImpl;
import org.hospitality.app.service.IService;
import org.hospitality.app.service.service.DeliveryService;


import java.util.Set;

public class DeliveryServiceImpl implements DeliveryService {
    private static DeliveryService service = null;
    private DeliveryRepository repository;

    private DeliveryServiceImpl(){
        this.repository = DeliveryRepositoryImpl.getRepository();
    }

    public static DeliveryService getService(){
        if (service == null)
            service = new DeliveryServiceImpl();
        return service;
    }
    @Override
    public Set<Delivery> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Delivery create(Delivery delivery) {
        return this.repository.create(delivery);
    }

    @Override
    public Delivery read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Delivery update(Delivery delivery) {
        return this.repository.update(delivery);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
