package org.hospitality.app.repository.utility;

import org.hospitality.app.entity.user.StayInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StayInfoRepository extends JpaRepository<StayInformation, String>
{

}

