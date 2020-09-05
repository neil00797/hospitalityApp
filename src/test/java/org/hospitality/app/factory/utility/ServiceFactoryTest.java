package org.hospitality.app.factory.utility;
/*
    author: @Moliehi Mabilietse
    desc : Service entity
 */

import org.hospitality.app.entity.utility.Service;
import org.hospitality.app.factory.utility.ServiceFactory;
import org.junit.Assert;
import org.junit.Test;

public class ServiceFactoryTest {
    @Test
    public void createService(){
        Service service = ServiceFactory.createService("Laundry");
        Assert.assertEquals(service,service);
    }

}
