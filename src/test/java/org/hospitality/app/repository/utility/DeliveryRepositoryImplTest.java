package org.hospitality.app.repository.utility;
/*
    author: @Shaun Donnelly
    desc: DeliveryRepositoryImplTest
    date: 24-08-2020
 */

import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.factory.utility.DeliveryFactory;
import org.hospitality.app.repository.utility.DeliveryRepository;
import org.hospitality.app.repository.utility.impl.DeliveryRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeliveryRepositoryImplTest{
    private static DeliveryRepository repository = DeliveryRepositoryImpl.getRepository();
    private static Delivery delivery = DeliveryFactory.createDelivery("13","Food Delivery");

    @Test
    public void a_create(){
        Delivery created = repository.create(delivery);
        Assert.assertEquals(delivery.getDeliveryNumber(), created.getDeliveryNumber());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read(){
        Delivery read = repository.read(delivery.getDeliveryNumber());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update(){
        Delivery updated = new Delivery.Builder().copy(delivery).setRoomNumber("22").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete(){
        boolean deleted = repository.delete(delivery.getDeliveryNumber());
        Assert.assertTrue(deleted);
    }

    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }
}