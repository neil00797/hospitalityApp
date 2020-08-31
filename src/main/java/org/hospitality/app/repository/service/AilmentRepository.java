package org.hospitality.app.repository.service;

import org.hospitality.app.entity.service.Ailment;
import org.hospitality.app.repository.IRepository;

import java.util.Set;

public interface AilmentRepository extends IRepository <Ailment, String> {
    Set<Ailment> getAll();

}
