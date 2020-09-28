package org.hospitality.app.repository.user;

import org.hospitality.app.entity.user.OccupantMedicalDetails;
/*
    author: @SenzoMkupa
    date: 31-08-2020
 */

import java.util.Set;

public interface OccupantMedicalDetailsRepository {
    OccupantMedicalDetails create(OccupantMedicalDetails occupantMedicalDetails);
    OccupantMedicalDetails read(String occupantMedicalDetails,String ailmentID);
    OccupantMedicalDetails update(OccupantMedicalDetails occupantMedicalDetails);
    boolean delete(String occupantID,String ailmentID);
    Set<OccupantMedicalDetails> getAll();


}

