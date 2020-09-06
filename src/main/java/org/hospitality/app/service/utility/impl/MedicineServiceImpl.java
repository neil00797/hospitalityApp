package org.hospitality.app.service.utility.impl;
/*
    author: @SenzoMkupa
    date: 06-09-2020
 */

import org.hospitality.app.entity.utility.Medicine;
import org.hospitality.app.repository.utility.MedicineRepository;
import org.hospitality.app.repository.utility.impl.MedicineRepositoryImpl;
import org.hospitality.app.service.utility.MedicineService;

import java.util.Set;

public class MedicineServiceImpl implements MedicineService {
    private static MedicineService service= null;
    private MedicineRepository repository;

    private MedicineServiceImpl(){
        this.repository= MedicineRepositoryImpl.getRepository();
    }
    public static MedicineService getService(){
        if (service ==null)
            service = new MedicineServiceImpl();
        return service;
    }
    @Override
    public Set<Medicine> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Medicine create(Medicine medicine) {
        return this.repository.create(medicine);
    }

    @Override
    public Medicine read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Medicine update(Medicine medicine) {
        return this.repository.update(medicine);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
