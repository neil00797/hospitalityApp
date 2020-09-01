package org.hospitality.app.repository.utility;
/*
    author: @Moliehi Mabilietse
    desc: Service tests for create, read, update and deleting
 */

import org.hospitality.app.entity.utility.Service;
import org.hospitality.app.factory.utility.ServiceFactory;
import org.hospitality.app.repository.utility.ServiceRepository;
import org.hospitality.app.repository.utility.impl.ServiceRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceRepositoryImplTest {
    private static ServiceRepository repository = ServiceRepositoryImpl.getRepository();
    private static Service service = ServiceFactory.createService("Laundry");


    @Test
    public void a_create(){
        Service created = repository.create(service);
        Assert.assertEquals(service.getServiceId(),created.getServiceId());
        System.out.println("Created Id:" + created);
    }


    @Test
    public void b_read(){
        Service read = repository.read(service.getServiceId());
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update(){
        Service updated = new Service.Builder().copy(service).setserviceId("2345").setserviceType("Laundry").build();
        updated = repository.update(updated);
        System.out.println("Updated:" + updated);
    }
    @Test
    public void e_delete(){
        boolean deleted = repository.delete(service.getServiceId());
        Assert.assertTrue(deleted);
    }
    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }

}



