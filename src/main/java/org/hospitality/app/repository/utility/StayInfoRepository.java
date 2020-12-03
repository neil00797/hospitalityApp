package org.hospitality.app.repository.utility;

import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StayInfoRepository extends JpaRepository<StayInformation , String> {

}

