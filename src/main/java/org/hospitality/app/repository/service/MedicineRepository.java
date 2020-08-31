package org.hospitality.app.repository.service;

import org.hospitality.app.entity.service.Medicine;
import org.hospitality.app.repository.IRepository;

import java.util.Set;

public interface MedicineRepository extends IRepository<Medicine,String> {
    Set<Medicine> getAll();
}
