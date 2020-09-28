package org.hospitality.app.repository.user.impl;
/*
    author: @SenzoMkupa
    date: 31-08-2020
 */


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
    public OccupantMedicalDetails read(String occupantID, String ailmentID) {
        for (OccupantMedicalDetails occupantMedicalDetails: this.occupantMedicalDetailsDB) {
            if(occupantMedicalDetails.getOccupantID().equalsIgnoreCase(occupantID) && occupantMedicalDetails.getAilment().equalsIgnoreCase(ailmentID));
            return occupantMedicalDetails;
        }
        return null;
    }

    @Override
    public OccupantMedicalDetails update(OccupantMedicalDetails occupantMedicalDetails) {
        boolean deleteOccupantMedicalDetails = delete(occupantMedicalDetails.getOccupantID(),occupantMedicalDetails.getAilment());
        if (deleteOccupantMedicalDetails){
            this.occupantMedicalDetailsDB.add(occupantMedicalDetails);
            return occupantMedicalDetails;
        }
        return null;
    }

    @Override
    public boolean delete(String occupantID, String ailmentID) {
        OccupantMedicalDetails occupantMedicalDetails = read(occupantID,ailmentID);
        if(occupantMedicalDetails != null){
            this.occupantMedicalDetailsDB.remove(occupantMedicalDetails);
            return true;
        }
        return false;
    }

    @Override
    public Set<OccupantMedicalDetails> getAll() {
        return this.occupantMedicalDetailsDB;
    }
}

