package org.hospitality.app.repository.user;

import org.hospitality.app.entity.user.OccupantMedicalDetails;
/*
    author: @SenzoMkupa
    date: 31-08-2020
 */

import java.util.Set;

public interface OccupantMedicalDetailsRepository {
    OccupantMedicalDetails create(OccupantMedicalDetails occupantMedicalDetails);
    OccupantMedicalDetails read(String occupantMedicalDetails);
    OccupantMedicalDetails update(OccupantMedicalDetails occupantMedicalDetails);
    boolean delete(String occupantMedicalDetails);
    Set<OccupantMedicalDetails> getAll();


}