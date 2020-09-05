package org.hospitality.app.factory.utility;

import junit.framework.TestCase;
import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.factory.utility.DeliveryFactory;
import org.junit.Assert;

public class DeliveryFactoryTest extends TestCase {

    public void testCreateDelivery() {
        Delivery delivery = DeliveryFactory.createDelivery("12","Breakfast");
        Assert.assertEquals(delivery, delivery);
    }
}