package org.hospitality.app.factory.service;

import org.hospitality.app.entity.service.Medicine;
import org.hospitality.app.util.Helper;

public class MedicineFactory {
    public static Medicine createMedicine (String medicineDesc){
        String medicineId = Helper.generateId();
        Medicine medicine = new Medicine.Builder()
                .setMedicineID(medicineId)
                .setMedicineDesc(medicineDesc)
                .build();
        return medicine;
    }
}
