package org.hospitality.app.service.utility.impl;
/*
    author: @Moliehi Mabilietse
    desc : ServiceService
 */


import org.hospitality.app.entity.utility.Facility;
import org.hospitality.app.repository.utility.FacilityRepository;
import org.hospitality.app.service.utility.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FacilityServiceImpl implements FacilityService {


    @Autowired
    private FacilityRepository repository;

    @Override
    public Set<Facility> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Facility create(Facility service) {
        return this.repository.save(service);
    }

    @Override
    public Facility read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Facility update(Facility service) {
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
    public Set<Facility> getNewService() {
        Set<Facility> services = getAll();
        Set<Facility> servicesName = new HashSet<>();

        for (Facility service: services){
            if (service.getServiceType().equalsIgnoreCase("Laundry")){
                servicesName.add(service);
            }
        }
        return servicesName;
    }

}


