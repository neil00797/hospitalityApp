package org.hospitality.app.repository.utility;

import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.repository.IRepository;

import java.util.Set;

public interface StayInfoRepository extends IRepository<StayInformation , String> {
    Set<StayInformation> getAll();
}

