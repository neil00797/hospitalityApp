package org.hospitality.app.factory.utility;

import org.hospitality.app.entity.utility.Medicine;
import org.hospitality.app.factory.utility.MedicineFactory;
import org.junit.Assert;
import org.junit.Test;

public class MedicineFactoryTest {



    @Test
    public void createMedicine() {
        String medDesc = "Xanax";
        Medicine medicine = MedicineFactory.createMedicine(medDesc);
        Assert.assertNotNull(medicine);
        Assert.assertNotNull(medicine.getMedicineID());
    }
}