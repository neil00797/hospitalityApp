package org.hospitality.app.factory;
/*
    author: @Moliehi Mabilietse
    desc: Factory Test case for service
 */


import org.hospitality.app.entity.Service;
import org.junit.Assert;
import org.junit.Test;

public class ServiceFactoryTest {

    @Test
    public void createService(){
        Service service = ServiceFactory.createService("Laundry");
        Assert.assertEquals(service,service);
    }

}
