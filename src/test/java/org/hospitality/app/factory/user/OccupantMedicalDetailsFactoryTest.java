package org.hospitality.app.factory.user;

import org.hospitality.app.entity.utility.Ailment;
import org.hospitality.app.entity.utility.Medicine;
import org.hospitality.app.entity.user.OccupantMedicalDetails;
import org.hospitality.app.factory.utility.AilmentFactory;
import org.hospitality.app.factory.utility.MedicineFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class OccupantMedicalDetailsFactoryTest {



    @Test
    public void createOccupantMedicalDetails() {
        int height =150;
        int weight =65;
        GregorianCalendar dob = new GregorianCalendar(2020, 9, 21);
        OccupantMedicalDetails occupantMedicalDetails = OccupantMedicalDetailsFactory.createOccupantMedicalDetails("101", "90220", height, weight, dob );
        Assert.assertNotNull(occupantMedicalDetails);
    }
}