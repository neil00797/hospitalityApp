package org.hospitality.app.service.utility.impl;


import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.repository.utility.StayInfoRepository;
import org.hospitality.app.service.utility.StayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
    Thaakir Ajouhaar - 217244394

 */
@Service
public class StayInfoServiceImpl implements StayInfoService
{
    @Autowired
    private StayInfoRepository repository;

    @Override
    public Set<StayInformation> getAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public StayInformation create(StayInformation stayInformation)
    {
        return this.repository.save(stayInformation);
    }

    @Override
    public StayInformation read(String s)
    {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public StayInformation update(StayInformation stayInformation) {
        if (this.repository.existsById(stayInformation.getOccupantId()))
        {
            return this.repository.save(stayInformation);
        }
        return null;
    }

    @Override
    public boolean delete(String s)
    {
        this.repository.deleteById(s);
        if(this.repository.existsById(s)) return false;
        else return true;


    }


    public Set<StayInformation> getStayDuration() {
        Set<StayInformation> stayInformations = getAll();
        Set<StayInformation> stayInformationStayDuration = new HashSet<>();

        for (StayInformation stayInformation: stayInformations){
            if (stayInformation.getStayDuration().equalsIgnoreCase("3 weeks"))
            {
                stayInformationStayDuration.add(stayInformation);
            }
        }
        return stayInformationStayDuration;
    }
}
