package org.hospitality.app.factory.utility;

import org.hospitality.app.entity.utility.Ailment;
import org.hospitality.app.entity.utility.Medicine;
import org.hospitality.app.factory.utility.AilmentFactory;
import org.hospitality.app.factory.utility.MedicineFactory;
import org.junit.Assert;
import org.junit.Test;

public class AilmentFactoryTest {



    @Test
    public void createAilment() {
        String medDesc = "panado";
        Medicine medicine = MedicineFactory.createMedicine(medDesc);
        String ailDesc = "Flu";
        Ailment ailment = AilmentFactory.createAilment(ailDesc,medDesc);
        Assert.assertNotNull(ailment);
        Assert.assertNotNull(ailment.getAilmentID());
    }
}