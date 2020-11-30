package org.hospitality.app.service.utility.impl;
/*
    author: @Moliehi Mabilietse
    desc: Service test
 */
import org.hospitality.app.entity.utility.Facility;
import org.hospitality.app.factory.utility.FacilityFactory;
import org.hospitality.app.service.utility.FacilityService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacilityServiceImplTest {

    @Autowired
    private static FacilityService service;
    private static Facility facility = FacilityFactory.createService("Laundry");

    @Test
    public void d_getAll(){
        Set<Facility> services = service.getAll();
        assertEquals(1,services.size());
        System.out.println("Services: " + services);
    }
    @Test
    public void a_create(){
        Facility created = service.create(facility);
        Assert.assertEquals(facility.getServiceId(),created.getServiceId());
        System.out.println("Created: " + created);
    }
    @Test
    public void b_read(){
        Facility read = service.read(facility.getServiceId());
        System.out.println("Read: " + read);
    }
    @Test
    public void c_update(){
        Facility updated = new Facility.Builder().copy(facility).setServiceId("6789").setServiceType("Laundry").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }
    @Test
    public void f_delete(){
        boolean deleted = service.delete(facility.getServiceId());
        Assert.assertTrue(deleted);
        System.out.println("Deleted successful");
    }
    @Test
    public void e_getAll(){
        Set<Facility> servicess = service.getNewService();
        System.out.println("All services: " + servicess);
    }
}
