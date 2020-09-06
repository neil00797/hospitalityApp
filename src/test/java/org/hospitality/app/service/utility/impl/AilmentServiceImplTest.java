package org.hospitality.app.service.utility.impl;
/*
    author: @SenzoMkupa
    date: 06-09-2020
 */

import org.hospitality.app.entity.utility.Ailment;
import org.hospitality.app.entity.utility.Medicine;
import org.hospitality.app.factory.utility.AilmentFactory;
import org.hospitality.app.factory.utility.MedicineFactory;
import org.hospitality.app.service.utility.AilmentService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AilmentServiceImplTest {
    private static AilmentService service = AilmentServiceImpl.getService();
    private static String medDesc = "anti-covid";
    private static Medicine medicine = MedicineFactory.createMedicine(medDesc);
    private static Ailment ailment = AilmentFactory.createAilment("Covid19",medicine);

    @Test
    public void e_getAll() {
        Set<Ailment> ailments =service.getAll();

        System.out.println("All ailments "+ailments);
    }

    @Test
    public void f_findByDesc() {
        String desc = "Pain";
        Set<Ailment> ailFindByDesc =service.findByDesc(desc);
        System.out.println("Ailments described with pain "+ailFindByDesc);
    }

    @Test
    public void a_create() {
        Ailment created = service.create(ailment);
        Assert.assertEquals(ailment.getAilmentID(),created.getAilmentID());
        System.out.println("Created: "+created);
    }

    @Test
    public void b_read() {
        Ailment read = service.read(ailment.getAilmentID());
        Assert.assertEquals(ailment.getAilmentID(),read.getAilmentID());
        System.out.println("Read: "+read);
    }

    @Test
    public void c_update() {
        Ailment updated = new Ailment.Builder().copy(ailment)
                .setAilmentID("911").setAilmentDesc("pain")
                .setMedicine(medicine).build();
        System.out.println("Updated: "+updated);
    }

    @Test
    public void g_delete() {
        boolean deleted = service.delete(ailment.getAilmentID());
        Assert.assertTrue(deleted);
        System.out.println("Successfully deleted!");
    }
}