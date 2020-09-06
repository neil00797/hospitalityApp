package org.hospitality.app.service.user;
/*
    author: @SenzoMkupa
    date: 06-09-2020
 */

import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.hospitality.app.service.IService;

import java.util.Set;

public interface OccupantMedicalDetailsService extends IService<OccupantMedicalDetails,OccupantMedicalDetails> {
    Set<OccupantMedicalDetails> getAll();
}
