package org.hospitality.app.repository.service.impl;


import org.hospitality.app.entity.service.Delivery;
import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.repository.service.DeliveryRepository;
import org.hospitality.app.repository.service.StayInfoRepository;

import java.util.HashSet;
import java.util.Set;


public class StayInfoRepositoryImpl implements StayInfoRepository
{

    private static StayInfoRepository repository = null;
    private Set<StayInformation> stayInfoDB;

    private StayInfoRepositoryImpl(){
        this.stayInfoDB = new HashSet<>();
    }

    public static StayInfoRepository getRepository(){
        if (repository == null) repository = new StayInfoRepositoryImpl();
        return repository;
    }

    @Override
    public Set<StayInformation> getAll() {
        return null;
    }

    @Override
    public StayInformation create(StayInformation stayInformation) {
        this.stayInfoDB.add(stayInformation);
        return stayInformation;
    }

    @Override
    public StayInformation read(String occupantId) {
        for (StayInformation stayInformation: this.stayInfoDB){
            if (stayInformation.getOccupantId().equalsIgnoreCase(occupantId))
                return stayInformation;
        }
        return null;
    }

    @Override
    public StayInformation update(StayInformation stayInformation) {
        boolean deleteStayInformation = delete(stayInformation.getOccupantId());
        if (deleteStayInformation){
            this.stayInfoDB.add(stayInformation);
            return stayInformation;
        }
        return null;
    }

    @Override
    public boolean delete(String occupantId) {
        StayInformation stayInformation = read(occupantId);
        if(stayInformation != null){
            this.stayInfoDB.remove(stayInformation);
            return true;
        }
        return false;
    }
}

