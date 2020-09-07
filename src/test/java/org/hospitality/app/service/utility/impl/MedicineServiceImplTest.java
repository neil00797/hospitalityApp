package org.hospitality.app.service.utility.impl;
/*
    author: @SenzoMkupa
    date: 06-09-2020
 */

import org.hospitality.app.entity.utility.Medicine;
import org.hospitality.app.factory.utility.MedicineFactory;
import org.hospitality.app.service.utility.MedicineService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedicineServiceImplTest {
    private static MedicineService service =MedicineServiceImpl.getService();
    private static String medDesc = "anti-covid";
    private static Medicine medicine = MedicineFactory.createMedicine(medDesc);

    @Test
    public void d_getAll() {
        Set<Medicine> medicines =service.getAll();
        System.out.println("All medicines "+medicines);
    }

    @Test
    public void a_create() {
        Medicine created = service.create(medicine);
        Assert.assertEquals(medicine.getMedicineID(),created.getMedicineID());
        System.out.println("Created: "+created);
    }

    @Test
    public void b_read() {
        Medicine read = service.read(medicine.getMedicineID());
        Assert.assertEquals(medicine.getMedicineID(),read.getMedicineID());
        System.out.println("Read: "+read);
    }

    @Test
    public void c_update() {
        Medicine updated = new Medicine.Builder()
                .copy(medicine).setMedicineID("10111")
                .setMedicineDesc("help").build();
        System.out.println("Updated: "+updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(medicine.getMedicineID());
        Assert.assertTrue(deleted);
        System.out.println("Successfully deleted!");
    }
}