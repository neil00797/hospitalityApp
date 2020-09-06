package org.hospitality.app.service.user.impl;
/*
    author: @SenzoMkupa
    date: 06-09-2020
 */

import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.hospitality.app.repository.user.OccupantMedicalDetailsRepository;
import org.hospitality.app.repository.user.impl.OccupantMedicalDetailsRepositoryImpl;
import org.hospitality.app.service.user.OccupantMedicalDetailsService;

import java.util.Set;

public class OccupantMedicalDetailsServiceImpl implements OccupantMedicalDetailsService {
    private static OccupantMedicalDetailsService service = null;
    private OccupantMedicalDetailsRepository repository;

    private OccupantMedicalDetailsServiceImpl(){
        this.repository = OccupantMedicalDetailsRepositoryImpl.getRepository();
    }
    public static OccupantMedicalDetailsService getService(){
        if (service==null)
            service = new OccupantMedicalDetailsServiceImpl();
        return service;
    }
    @Override
    public Set<OccupantMedicalDetails> getAll() {
        return this.repository.getAll();
    }

    @Override
    public OccupantMedicalDetails create(OccupantMedicalDetails occupantMedicalDetails) {
        return this.repository.create(occupantMedicalDetails);
    }

    @Override
    public OccupantMedicalDetails read(OccupantMedicalDetails occupantMedicalDetails) {
      //  return this.repository.read();
        return null;
    }

    @Override
    public OccupantMedicalDetails update(OccupantMedicalDetails occupantMedicalDetails) {
        return this.repository.update(occupantMedicalDetails);
    }

    @Override
    public boolean delete(OccupantMedicalDetails occupantMedicalDetails) {
        //return this.repository.delete();
        return false;
    }
}
