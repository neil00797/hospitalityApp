package org.hospitality.app.repository.service;

import org.hospitality.app.entity.service.Medicine;
import org.hospitality.app.repository.IRepository;
/*
    author: @SenzoMkupa
    date: 31-08-2020
 */


import java.util.Set;

public interface MedicineRepository extends IRepository<Medicine,String> {
    Set<Medicine> getAll();
<<<<<<< HEAD
}
=======
}
>>>>>>> 4ab93862dbd3e0e558d97df4be06332fdbfdac0d
