package org.hospitality.app.service.utility.impl;


import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.repository.utility.StayInfoRepository;
import org.hospitality.app.repository.utility.impl.StayInfoRepositoryImpl;
import org.hospitality.app.service.utility.StayInfoService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/*
    Thaakir Ajouhaar - 217244394

 */
@Service
public class StayInfoServiceImpl implements StayInfoService
{
    private static StayInfoService service = null;
    private StayInfoRepository repository;

    private StayInfoServiceImpl()
    {
        this.repository = StayInfoRepositoryImpl.getRepository();
    }

    public static StayInfoService getService()
    {
        if (service == null)
            service = new StayInfoServiceImpl();
        return service;
    }

    @Override
    public Set<StayInformation> getAll()
    {
        return this.repository.getAll();
    }

    @Override
    public StayInformation create(StayInformation stayInformation)
    {
        return this.repository.create(stayInformation);
    }

    @Override
    public StayInformation read(String s)
    {
        return this.repository.read(s);
    }

    @Override
    public StayInformation update(StayInformation stayInformation)
    {
        return this.repository.update(stayInformation);
    }

    @Override
    public boolean delete(String s)
    {
        return this.repository.delete(s);
    }

    @Override
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
