package org.hospitality.app.repository.service.impl;
/*
    author: @Moliehi Mabilietse
    desc : ServiceRepository
 */


import org.hospitality.app.entity.service.Service;
import org.hospitality.app.repository.service.ServiceRepository;


import java.util.HashSet;
import java.util.Set;

public class ServiceRepositoryImpl implements ServiceRepository{
    private static ServiceRepository repository = null;
    private Set<Service> serviceDB;

    private ServiceRepositoryImpl() {
        this.serviceDB = new HashSet<>();
    }


    public static ServiceRepository getRepository(){
        if (repository == null) repository = new ServiceRepositoryImpl();
        return repository;
    }
    @Override
    public Set<Service> getAll() {
        return serviceDB;
    }

    @Override
    public Service create(Service service) {
        this.serviceDB.add(service);
        return service;
    }

    @Override
    public Service read(String id) {
        for (Service service: this.serviceDB){
            if (service.getServiceId().equalsIgnoreCase(id));
        }
        return null;
    }


    @Override
    public Service update(Service service) {
        boolean deleteService = delete(service.getServiceId());
        if(deleteService){
            this.serviceDB.add(service);
            return service;
        }
        return null;
    }


    @Override
    public boolean delete(String id) {
        Service service = read(id);
        if(service != null){
            this.serviceDB.remove(service);
            return true;
        }
        return false;
    }
}



