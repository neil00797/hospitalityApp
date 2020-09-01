package org.hospitality.app.repository.utility;

import org.hospitality.app.entity.utility.Service;
import org.hospitality.app.repository.IRepository;

import java.util.Set;

public interface ServiceRepository extends IRepository <Service ,String> {
    Set<Service> getAll();
}




