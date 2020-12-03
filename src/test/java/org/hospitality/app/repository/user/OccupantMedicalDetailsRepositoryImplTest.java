/*
package org.hospitality.app.repository.user;
*/
/*
    author: @SenzoMkupa
    date: 31-08-2020
 *//*



import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.hospitality.app.entity.utility.Ailment;
import org.hospitality.app.entity.utility.Medicine;
import org.hospitality.app.factory.user.OccupantMedicalDetailsFactory;
import org.hospitality.app.factory.utility.AilmentFactory;
import org.hospitality.app.factory.utility.MedicineFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OccupantMedicalDetailsRepositoryImplTest {

    @Autowired
    private static OccupantMedicalDetailsRepository repository;
    private static Date dob = new Date(2096,07,11);
    private static OccupantMedicalDetails occupantMedicalDetails = OccupantMedicalDetailsFactory.createOccupantMedicalDetails("101","90220", 192, 95, dob );

    @Test
    public void a_create() {
        OccupantMedicalDetails created = repository.save(occupantMedicalDetails);
        Assert.assertEquals(occupantMedicalDetails.getOccupantID(),created.getOccupantID());
        System.out.println("Created ID: "+created);
    }

    @Test
    public void b_read() {
        OccupantMedicalDetails read = repository.read(occupantMedicalDetails.getOccupantID(),occupantMedicalDetails.getAilment());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        OccupantMedicalDetails updated = new OccupantMedicalDetails.Builder().copy(occupantMedicalDetails).setAilmentID("19193").setOccupantID("288549").setWeight(80).setHeight(800).setDateOfBirth(dob).build();
        updated = repository.save(updated);
        System.out.println("Updated: " + updated);

    }

    @Test
    public void e_delete() {
        boolean deleted = repository.delete(occupantMedicalDetails.getOccupantID(),occupantMedicalDetails.getAilment());
    }

    @Test
    public void d_getAll() {
        System.out.println("Get all: " + repository.findAll());
    }
}
*/
