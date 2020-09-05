package org.hospitality.app.repository.user.impl;
/*
    author: @SenzoMkupa
    date: 31-08-2020
 */


import org.hospitality.app.entity.service.Ailment;
import org.hospitality.app.entity.service.Medicine;
import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.hospitality.app.factory.service.AilmentFactory;
import org.hospitality.app.factory.service.MedicineFactory;
import org.hospitality.app.factory.user.OccupantMedicalDetailsFactory;
import org.hospitality.app.repository.user.OccupantMedicalDetailsRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OccupantMedicalDetailsRepositoryImplTest {

    private static OccupantMedicalDetailsRepository repository = OccupantMedicalDetailsRepositoryImpl.getRepository();
    private static String medDesc = "panado";
    private static Medicine medicine = MedicineFactory.createMedicine(medDesc);
    private static Ailment ailment = AilmentFactory.createAilment("Covid19",medicine);
    private static Date dob = new Date(1996,05,31);
    private static OccupantMedicalDetails occupantMedicalDetails = OccupantMedicalDetailsFactory.createOccupantMedicalDetails(ailment,700,80,dob);

    @Test
    public void a_create() {
        OccupantMedicalDetails created = repository.create(occupantMedicalDetails);
        Assert.assertEquals(occupantMedicalDetails.getAilment(),created.getAilment());
        System.out.println("Created ID: "+created);
    }

    @Test
    public void b_read() {
    }

    @Test
    public void c_update() {
        OccupantMedicalDetails updated = new OccupantMedicalDetails.Builder().copy(occupantMedicalDetails).setAilment(ailment).setWeight(80).setHeight(800).setDateOfBirth(dob).build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);

    }

    @Test
    public void e_delete() {
        //boolean deleted = repository.delete(occupantMedicalDetails.getAilment());
    }

    @Test
    public void d_getAll() {
        System.out.println("Get all: "+repository.getAll());
    }
}