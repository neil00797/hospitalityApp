package org.hospitality.app.service.utility;


import org.hospitality.app.entity.utility.Facility;
import org.hospitality.app.service.IService;

import java.util.Set;

public interface FacilityService extends IService<Facility,String> {
    Set<Facility> getAll();

    //business logic
    Set<Facility> getNewService();
}
