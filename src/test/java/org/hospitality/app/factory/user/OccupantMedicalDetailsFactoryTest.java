package org.hospitality.app.factory.user;

import org.hospitality.app.entity.service.Ailment;
import org.hospitality.app.entity.service.Medicine;
import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.hospitality.app.factory.service.AilmentFactory;
import org.hospitality.app.factory.service.MedicineFactory;
import org.hospitality.app.factory.user.OccupantMedicalDetailsFactory;
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