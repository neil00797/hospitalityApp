package org.hospitality.app.repository.service.impl;
/*
    author: @Shaun Donnelly
    desc: DeliveryRepositoryImpl
    date: 24-08-2020
 */
import org.hospitality.app.entity.service.Delivery;
import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.repository.service.DeliveryRepository;

import java.util.HashSet;
import java.util.Set;


public class DeliveryRepositoryImpl implements DeliveryRepository {

    private static DeliveryRepository repository = null;
    private Set<Delivery> deliveryDB;

    private DeliveryRepositoryImpl(){
        this.deliveryDB = new HashSet<>();
    }

    public static DeliveryRepository getRepository(){
        if (repository == null) repository = new DeliveryRepositoryImpl();
        return repository;
    }

    @Override
    public Delivery create(Delivery delivery) {
        this.deliveryDB.add(delivery);
        return delivery;
    }

    @Override
    public Delivery read(String deliveryNumber) {
        for (Delivery delivery: this.deliveryDB){
            if (delivery.getDeliveryNumber().equalsIgnoreCase(deliveryNumber))
                return delivery;
        }
        return null;
    }

    @Override
    public Delivery update(Delivery delivery) {
        boolean deleteDelivery = delete(delivery.getDeliveryNumber());
        if (deleteDelivery){
            this.deliveryDB.add(delivery);
            return delivery;
        }
        return null;
    }

    @Override
    public boolean delete(String receiptNumber) {
        Delivery delivery = read(receiptNumber);
        if(delivery != null){
            this.deliveryDB.remove(delivery);
            return true;
        }
        return false;
    }

    @Override
    public Set<Delivery> getAll() {
        return this.deliveryDB;
    }
}