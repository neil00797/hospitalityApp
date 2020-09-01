package org.hospitality.app.factory.user;

import org.hospitality.app.entity.utility.Ailment;
import org.hospitality.app.entity.utility.Medicine;
import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.hospitality.app.factory.utility.AilmentFactory;
import org.hospitality.app.factory.utility.MedicineFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

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