package org.hospitality.app.factory.service;

import org.hospitality.app.entity.service.Ailment;
import org.hospitality.app.entity.service.Medicine;
import org.hospitality.app.factory.service.AilmentFactory;
import org.hospitality.app.factory.service.MedicineFactory;
import org.junit.Assert;
import org.junit.Test;

public class AilmentFactoryTest {



    @Test
    public void createAilment() {
        String medDesc = "panado";
        Medicine medicine = MedicineFactory.createMedicine(medDesc);
        String ailDesc = "Flu";
        Ailment ailment = AilmentFactory.createAilment(ailDesc,medicine);
        Assert.assertNotNull(ailment);
        Assert.assertNotNull(ailment.getAilmentID());
    }
}