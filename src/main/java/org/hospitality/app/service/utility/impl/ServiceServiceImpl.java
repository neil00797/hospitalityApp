package org.hospitality.app.service.utility.impl;
/*
    author: @Moliehi Mabilietse
    desc : ServiceService
 */


import org.hospitality.app.entity.utility.Service;
import org.hospitality.app.repository.utility.ServiceRepository;
import org.hospitality.app.service.utility.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {


    @Autowired
    private ServiceRepository repository;

    @Override
    public Set<Service> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Service create(Service service) {
        return this.repository.save(service);
    }

    @Override
    public Service read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Service update(Service service) {
        if (this.repository.existsById(service.getServiceId())) {
            return this.repository.save(service);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s))
            return false;

        else return true;
    }
    @Override
    public Set<Service> getNewService() {
        Set<Service> services = getAll();
        Set<Service> servicesName = new HashSet<>();

        for (Service service: services){
            if (service.getServiceType().equalsIgnoreCase("Laundry")){
                servicesName.add(service);
            }
        }
        return servicesName;
    }

}


