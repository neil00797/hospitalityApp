package org.hospitality.app.factory.utility;
/*
    author: @Moliehi Mabilietse
    desc : Service entity
 */

import org.hospitality.app.entity.utility.Facility;
import org.junit.Assert;
import org.junit.Test;

public class FacilityFactoryTest {
    @Test
    public void createService(){
        Facility service = FacilityFactory.createService("Laundry");
        Assert.assertEquals(service,service);
    }

}
