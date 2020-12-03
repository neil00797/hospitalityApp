package org.hospitality.app.repository.utility;

import org.hospitality.app.entity.utility.Medicine;
import org.hospitality.app.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
    author: @SenzoMkupa
    date: 31-08-2020
 */


import java.util.Set;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,String> {

}

