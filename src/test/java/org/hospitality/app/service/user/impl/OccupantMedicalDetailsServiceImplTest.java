package org.hospitality.app.service.user.impl;

import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.hospitality.app.factory.user.OccupantMedicalDetailsFactory;
import org.hospitality.app.service.user.OccupantMedicalDetailsService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OccupantMedicalDetailsServiceImplTest {
    private static OccupantMedicalDetailsService service = OccupantMedicalDetailsServiceImpl.getService();
    private static Date dob = new Date(1996,05,31);
    private static OccupantMedicalDetails occupantMedicalDetails = OccupantMedicalDetailsFactory.createOccupantMedicalDetails("101","90221",192, 95, dob);



    @Test
    public void a_create() {
        OccupantMedicalDetails created = service.create(occupantMedicalDetails);
        Assert.assertEquals(occupantMedicalDetails.getOccupantID(),created.getOccupantID());
        System.out.println("Created: "+created);
    }

    @Test
    public void b_read() {
        OccupantMedicalDetails read = service.read(occupantMedicalDetails.getOccupantID(),occupantMedicalDetails.getAilment());
        Assert.assertEquals(occupantMedicalDetails.getOccupantID(),read.getOccupantID());
        System.out.println("Read: "+read);
    }

    @Test
    public void c_update() {
        OccupantMedicalDetails updated = new OccupantMedicalDetails.Builder()
                .copy(occupantMedicalDetails)
                .setOccupantID("897415")
                .setAilmentID("861515")
                .setHeight(189)
                .setWeight(95)
                .setDateOfBirth(dob).build();
        //Assert.assertNotEquals(updated,service.create(occupantMedicalDetails));
    //    System.out.println("Updated: "+updated);
      //  System.out.println("Original: "+service.create(occupantMedicalDetails));
    }

    @Test
    public void e_delete() {
        boolean deleted = service.delete(occupantMedicalDetails.getOccupantID(),occupantMedicalDetails.getAilment());
        Assert.assertTrue(deleted);
        System.out.println("Successfully deleted!");

    }
    @Test
    public void d_getAll() {
        Set<OccupantMedicalDetails> occupantMedicalDetails= service.getAll();
        System.out.println("All OccupantMedicalDetails "+occupantMedicalDetails);
    }
}