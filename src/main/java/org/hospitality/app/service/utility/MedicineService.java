package org.hospitality.app.service.utility;
/*
    author: @SenzoMkupa
    date: 06-09-2020
 */

import org.hospitality.app.entity.utility.Medicine;
import org.hospitality.app.service.IService;

import java.util.Set;

public interface MedicineService extends IService<Medicine,String> {
    Set<Medicine> getAll();

}
