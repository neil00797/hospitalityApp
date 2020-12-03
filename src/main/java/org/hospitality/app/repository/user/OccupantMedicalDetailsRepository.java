package org.hospitality.app.repository.user;

import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
    author: @SenzoMkupa
    date: 31-08-2020
 */

@Repository
public interface OccupantMedicalDetailsRepository extends JpaRepository<OccupantMedicalDetails , String> {

}

