package org.hospitality.app.repository.service;

import org.hospitality.app.entity.service.Service;
import org.hospitality.app.repository.IRepository;

import java.util.Set;

public interface ServiceRepository extends IRepository <Service ,String> {
    Set<Service> getAll();
}




