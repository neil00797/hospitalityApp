package org.hospitality.app.factory;

import org.hospitality.app.entity.Medicine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicineFactoryTest {



    @Test
    public void createMedicine() {
        String medDesc = "Xanax";
        Medicine medicine = MedicineFactory.createMedicine(medDesc);
        Assert.assertNotNull(medicine);
        Assert.assertNotNull(medicine.getMedicineID());
    }
}