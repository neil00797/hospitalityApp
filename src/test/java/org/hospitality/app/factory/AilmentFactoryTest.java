package org.hospitality.app.factory;

import org.hospitality.app.entity.Ailment;
import org.hospitality.app.entity.Medicine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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