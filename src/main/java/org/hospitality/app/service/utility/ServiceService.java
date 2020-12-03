package org.hospitality.app.service.utility;


import org.hospitality.app.entity.utility.Service;
import org.hospitality.app.service.IService;

import java.util.Set;

public interface ServiceService extends IService<Service,String> {
    Set<Service> getAll();

    //business logic
    Set<Service> getAllStartingWithL();

}
