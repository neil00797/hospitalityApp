package org.hospitality.app.service.utility.impl;

import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.entity.user.Room;
import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.factory.user.OccupantFactory;
import org.hospitality.app.factory.utility.DeliveryFactory;
import org.hospitality.app.service.user.OccupantService;
import org.hospitality.app.service.user.impl.OccupantServiceImpl;
import org.hospitality.app.service.utility.DeliveryService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeliveryServiceImplTest {
    private static DeliveryService service;
    private static Delivery delivery = DeliveryFactory.createDelivery("13", "Food Delivery");
    private static Delivery delivery2 = DeliveryFactory.createDelivery("16", "Medication Collection");

    @Test
    public void e_getAll() {
        Set<Delivery> delivery = service.getAll();

        System.out.println("All Deliveries: " + delivery + "\n");
    }

    @Test
    public void a_create() {
        Delivery created = service.create(delivery);
        Assert.assertEquals(delivery.getDeliveryNumber(), created.getDeliveryNumber());

        Delivery created2 = service.create(delivery2);
        Assert.assertEquals(delivery2.getDeliveryNumber(), created2.getDeliveryNumber());

        System.out.println("Created: " + created + "\n" + "Created2: " + created2 + "\n");
    }

    @Test
    public void b_read() {
        Delivery read = service.read(delivery.getDeliveryNumber());
        Delivery read2 = service.read(delivery2.getDeliveryNumber());

        System.out.println("Read: " + read + "\n" + "Read2: " + read2 + "\n");
    }

    @Test
    public void c_update() {
        Delivery updated = new Delivery.Builder().copy(delivery).setRoomNumber("40").setServiceType("Lunch").build();
        //updated = service.update(updated);

        Delivery updated2 = new Delivery.Builder().copy(delivery2).setRoomNumber("19").build();

        System.out.println("Updated: " + updated + "\n" + "Updated2: " + updated2 + "\n");
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(delivery.getDeliveryNumber());
        Assert.assertTrue(deleted);
        boolean deleted2 = service.delete(delivery2.getDeliveryNumber());
        Assert.assertTrue(deleted2);

        System.out.println("Entry Deleted");
    }
    @Test
    public void d_getNewService() {
        Set<Delivery> deliveryServiceByName = service.getNewService();
        System.out.println("Delivery Medication Service: " + deliveryServiceByName + "\n");

    }


}