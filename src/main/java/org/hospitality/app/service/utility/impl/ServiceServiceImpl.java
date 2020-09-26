package org.hospitality.app.service.utility.impl;
/*
    author: @Moliehi Mabilietse
    desc : ServiceService
 */

import org.hospitality.app.entity.utility.Service;
import org.hospitality.app.repository.utility.ServiceRepository;
import org.hospitality.app.repository.utility.impl.ServiceRepositoryImpl;
import org.hospitality.app.service.utility.ServiceService;

import java.util.HashSet;
import java.util.Set;

public class ServiceServiceImpl implements ServiceService {
    public static ServiceService service = null;
    private ServiceRepository repository;

    private ServiceServiceImpl(){
        this.repository = ServiceRepositoryImpl.getRepository();
    }
    public static ServiceService getService(){
        if(service == null) service = new ServiceServiceImpl();
        return service;
    }
    @Override
    public Set<Service> getAll(){
        return this.repository.getAll();
    }

    @Override
    public Service create(Service service) {
        return this.repository.create(service);
    }

    @Override
    public Service read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Service update(Service service) {
        return this.repository.update(service);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
    @Override
    public Set<Service> getAllStartingWithL() {
        Set<Service> services = getAll();
        Set<Service> servicesStartingWithL = new HashSet<>();

        for (Service service: services){
            if (service.getServiceType().trim().toUpperCase().startsWith("L")){
                servicesStartingWithL.add(service);
            }
        }
        return servicesStartingWithL;
    }

}
