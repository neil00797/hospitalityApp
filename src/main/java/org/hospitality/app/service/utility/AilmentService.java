package org.hospitality.app.service.utility;
/*
    author: @SenzoMkupa
    date: 06-09-2020
 */

import org.hospitality.app.entity.utility.Ailment;
import org.hospitality.app.service.IService;

import java.util.Set;

public interface AilmentService extends IService<Ailment,String> {
    Set<Ailment> getAll();

    Set<Ailment> findByDesc(String s);
}
