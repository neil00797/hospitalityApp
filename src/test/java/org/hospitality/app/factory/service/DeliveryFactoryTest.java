package org.hospitality.app.factory.service;

import junit.framework.TestCase;
import org.hospitality.app.entity.service.Delivery;
import org.hospitality.app.factory.service.DeliveryFactory;
import org.junit.Assert;

public class DeliveryFactoryTest extends TestCase {

    public void testCreateDelivery() {
        Delivery delivery = DeliveryFactory.createDelivery("12","Breakfast");
        Assert.assertEquals(delivery, delivery);
    }
}