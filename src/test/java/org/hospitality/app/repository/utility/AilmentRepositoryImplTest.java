package org.hospitality.app.repository.service.impl;
/*
    author: @SenzoMkupa
    date: 31-08-2020
 */

import org.hospitality.app.entity.service.Ailment;
import org.hospitality.app.entity.service.Medicine;
import org.hospitality.app.factory.service.AilmentFactory;
import org.hospitality.app.factory.service.MedicineFactory;

import org.hospitality.app.repository.service.AilmentRepository;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AilmentRepositoryImplTest {

    private static AilmentRepository repository = AilmentRepositoryImpl.getRepository();
    private static String medDesc = "panado";
    private static Medicine medicine = MedicineFactory.createMedicine(medDesc);
    private static Ailment ailment = AilmentFactory.createAilment("Covid19",medicine);

    @Test
    public void d_getAll() {
        System.out.println("Get all: " + repository.getAll());
    }

    @Test
    public void a_create() {
        Ailment created = repository.create(ailment);
        Assert.assertEquals(ailment.getAilmentID(), created.getAilmentID());
        System.out.println("Created ID: " + created);
    }

    @Test
    public void b_read() {
        Ailment read = repository.read(ailment.getAilmentID());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Ailment updated = new Ailment.Builder().copy(ailment).setAilmentID("10111").setAilmentDesc("pain").setMedicine(medicine).build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(ailment.getAilmentID());
        Assert.assertTrue(deleted);
        System.out.println("Successfully deleted!");
    }
}