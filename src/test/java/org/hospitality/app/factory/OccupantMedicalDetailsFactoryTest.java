package org.hospitality.app.factory;

import org.hospitality.app.entity.Ailment;
import org.hospitality.app.entity.Medicine;
import org.hospitality.app.entity.OccupantMedicalDetails;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class OccupantMedicalDetailsFactoryTest {



    @Test
    public void createOccupantMedicalDetails() {
        String medDesc = "panado";
        Medicine medicine = MedicineFactory.createMedicine(medDesc);
        String ailDesc = "Flu";
        Ailment ailment = AilmentFactory.createAilment(ailDesc,medicine);
        int height =150;
        int weight =65;
        Date dob = new Date(1996,05,31);
        OccupantMedicalDetails occupantMedicalDetails = OccupantMedicalDetailsFactory.createOccupantMedicalDetails(ailment,height,weight,dob);
        Assert.assertNotNull(occupantMedicalDetails);
    }
}