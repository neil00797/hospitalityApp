package org.hospitality.app.repository.utility;
/*
    author: @SenzoMkupa
    date: 31-08-2020
 */

import org.hospitality.app.entity.utility.Medicine;
import org.hospitality.app.factory.utility.MedicineFactory;
import org.hospitality.app.repository.utility.impl.MedicineRepositoryImpl;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedicineRepositoryImplTest {
    private static MedicineRepository repository = MedicineRepositoryImpl.getRepository();
    private static Medicine medicine = MedicineFactory.createMedicine("Cough syrup");

    @Test
    public void d_getAll() {
        System.out.println("Get all: " + repository.getAll());
    }

    @Test
    public void a_create() {
        Medicine created = repository.create(medicine);
        Assert.assertEquals(medicine.getMedicineID(), created.getMedicineID());
        System.out.println("Created ID: " + created);
    }

    @Test
    public void b_read() {
        Medicine read = repository.read(medicine.getMedicineID());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Medicine updated = new Medicine.Builder().copy(medicine).setMedicineDesc(medicine.getMedicineDesc()).setMedicineID("911").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(medicine.getMedicineID());
        Assert.assertTrue(deleted);
        System.out.println("Successfully deleted!");
    }
}