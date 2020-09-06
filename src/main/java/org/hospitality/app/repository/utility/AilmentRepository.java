package org.hospitality.app.repository.utility;

import org.hospitality.app.entity.utility.Ailment;
import org.hospitality.app.repository.IRepository;
/*
    author: @SenzoMkupa
    date: 31-08-2020
 */


import java.util.Set;

public interface AilmentRepository extends IRepository <Ailment, String> {
    Set<Ailment> getAll();


}
