package org.hospitality.app.factory.service;
/*
    author: @Moliehi Mabilietse
    desc : Service entity
 */

import org.hospitality.app.entity.service.Service;
import org.hospitality.app.factory.service.ServiceFactory;
import org.junit.Assert;
import org.junit.Test;

public class ServiceFactoryTest {
    @Test
    public void createService(){
        Service service = ServiceFactory.createService("Laundry");
        Assert.assertEquals(service,service);
    }

}
