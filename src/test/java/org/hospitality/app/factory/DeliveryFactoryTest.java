package org.hospitality.app.factory;

import junit.framework.TestCase;
import org.hospitality.app.entity.Delivery;
import org.junit.Assert;

public class DeliveryFactoryTest extends TestCase {

    public void testCreateDelivery() {
        Delivery delivery = DeliveryFactory.createDelivery("12","Breakfast");
        Assert.assertEquals(delivery, delivery);
    }
}