package org.hospitality.app.repository.service.impl;
/*
    author: @SenzoMkupa
    date: 31-08-2020
 */


import org.hospitality.app.entity.service.Medicine;
import org.hospitality.app.repository.service.MedicineRepository;

import java.util.HashSet;
import java.util.Set;

public class MedicineRepositoryImpl implements MedicineRepository {

    private static MedicineRepository repository = null;
    private Set<Medicine> medicineDB;

    private MedicineRepositoryImpl() {this.medicineDB = new HashSet<>();}

    public static MedicineRepository getRepository(){
        if (repository == null) repository = new MedicineRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Medicine> getAll() {
        return this.medicineDB;
    }

    @Override
    public Medicine create(Medicine medicine) {
        this.medicineDB.add(medicine);
        return medicine;

    }

    @Override
    public Medicine read(String s) {
        for (Medicine medicine: this.medicineDB){
            if (medicine.getMedicineID().equalsIgnoreCase(s));

            return medicine;
        }

        return null;
    }

    @Override
    public Medicine update(Medicine medicine) {
        boolean deleteMedicine = delete(medicine.getMedicineID());
        if (deleteMedicine){
            this.medicineDB.add(medicine);
            return medicine;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Medicine medicine = read(s);

        if(medicine != null){
            this.medicineDB.remove(medicine);
            return true;
        }
        return false;

    }
}
