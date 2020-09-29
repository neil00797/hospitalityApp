package org.hospitality.app.service.user;
/*
    author: @SenzoMkupa
    date: 06-09-2020
 */

import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.hospitality.app.service.IService;

import java.util.Set;

public interface OccupantMedicalDetailsService {
    OccupantMedicalDetails create(OccupantMedicalDetails u);
    OccupantMedicalDetails read(String occupantID,String ailmentID);
    OccupantMedicalDetails update(OccupantMedicalDetails u);
    boolean delete(String occupantID,String ailmentID);
    Set<OccupantMedicalDetails> getAll();
}
