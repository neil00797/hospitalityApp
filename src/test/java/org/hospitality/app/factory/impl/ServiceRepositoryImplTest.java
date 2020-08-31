package org.hospitality.app.factory.impl;
/*
    author: @Moliehi Mabilietse
    desc: Service tests for create, read, update and deleting
 */

import org.hospitality.app.entity.service.Service;
import org.hospitality.app.factory.service.ServiceFactory;
import org.hospitality.app.repository.service.ServiceRepository;
import org.hospitality.app.repository.service.impl.ServiceRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class ServiceRepositoryImplTest implements ServiceRepository{
    private static ServiceRepository repository = ServiceRepositoryImpl.getRepository();
    private static Service service = ServiceFactory.createService("Laundry");


    @Test
    public void create(){
        Service created = repository.create(service);
        Assert.assertEquals(service.getServiceId(),created.getServiceId());
        System.out.println("Created Id:" + created);
    }
    @Test
    public void read(){
        Service read = repository.read(service.getServiceId());
        System.out.println("Read:" + read);
    }
    @Test
    public void update(){
        Service updated = new Service.Builder().copy(service).setserviceId("2345").setserviceType("Laundry").build();
        updated = repository.update(updated);
        System.out.println("Updated:" + updated);
    }
    @Test
    public void delete(){
        boolean deleted = repository.delete(service.getServiceId());
        Assert.assertTrue(deleted);
    }
    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }

    @Override
    public Set<Service> getAll() {
        return null;
    }

    @Override
    public Service create(Service service) {
        return null;
    }

    @Override
    public Service read(String s) {
        return null;
    }

    @Override
    public Service update(Service service) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}



