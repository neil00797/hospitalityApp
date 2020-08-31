package org.hospitality.app.repository.user.impl;

import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.hospitality.app.repository.user.OccupantMedicalDetailsRepository;


import java.util.HashSet;
import java.util.Set;

public class OccupantMedicalDetailsRepositoryImpl implements OccupantMedicalDetailsRepository {


    private static OccupantMedicalDetailsRepository repository = null;
    private Set<OccupantMedicalDetails> occupantMedicalDetailsDB;

    private OccupantMedicalDetailsRepositoryImpl(){
        this.occupantMedicalDetailsDB = new HashSet<>();
    }

    public static OccupantMedicalDetailsRepository getRepository(){
        if (repository == null) repository = new OccupantMedicalDetailsRepositoryImpl();
        return repository;
    }
    @Override
    public OccupantMedicalDetails create(OccupantMedicalDetails occupantMedicalDetails) {
        this.occupantMedicalDetailsDB.add(occupantMedicalDetails);
        return occupantMedicalDetails;
    }

    @Override
    public OccupantMedicalDetails read(String occupantMedicalDetails) {
        return null;
    }




    @Override
    public OccupantMedicalDetails update(OccupantMedicalDetails occupantMedicalDetails) {

        boolean deleteOccupantMedicalDetails = false;

            if (deleteOccupantMedicalDetails){
                this.occupantMedicalDetailsDB.add(occupantMedicalDetails);
                return occupantMedicalDetails;
            }
            return null;
        }

    @Override
    public boolean delete(String occupantMedicalDetails) {
        OccupantMedicalDetails occupantMedicalDetails1 = read(occupantMedicalDetails);

        if(occupantMedicalDetails1 != null){
            this.occupantMedicalDetailsDB.remove(occupantMedicalDetails1);
            return true;
        }
        return false;
    }




    @Override
    public Set<OccupantMedicalDetails> getAll() {
        return this.occupantMedicalDetailsDB;
    }
}
