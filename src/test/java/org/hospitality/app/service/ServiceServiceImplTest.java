package org.hospitality.app.service;
/*
    author: @Moliehi Mabilietse
    desc: Service test
 */
import org.hospitality.app.entity.utility.Service;
import org.hospitality.app.factory.utility.ServiceFactory;
import org.hospitality.app.service.utility.ServiceService;
import org.hospitality.app.service.utility.impl.ServiceServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceServiceImplTest {
    private static ServiceService service = ServiceServiceImpl.getService();
    private static Service ser = ServiceFactory.createService("Laundry");

    @Test
    public void d_getAll(){
        Set<Service> services = service.getAll();
        assertEquals(1,services.size());
        System.out.println("Services: " + services);
    }
    @Test
    public void a_create(){
        Service created = service.create(ser);
        Assert.assertEquals(ser.getServiceId(),created.getServiceId());
        System.out.println("Created: " + created);
    }
    @Test
    public void b_read(){
        Service read = service.read(ser.getServiceId());
        System.out.println("Read: " + read);
    }
    @Test
    public void c_update(){
        Service updated = new Service.Builder().copy(ser).setserviceId("6789").setserviceType("Laundry").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }
    @Test
    public void f_delete(){
        boolean deleted = service.delete(ser.getServiceId());
        Assert.assertTrue(deleted);
        System.out.println("Deleted successful");
    }
    @Test
    public void e_getAllStartingWithL(){
        Set<Service> serviceStartWithL = service.getAllStartingWithL();
        System.out.println("Starts with L: " + serviceStartWithL);
    }
}
