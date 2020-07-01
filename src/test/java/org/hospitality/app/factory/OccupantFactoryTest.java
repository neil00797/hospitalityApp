package org.hospitality.app.factory;
/*
    author: @NeilJohnson
    desc: Factory Test for Occupant
    date: 29-06-2020
 */
import org.hospitality.app.entity.Occupant;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OccupantFactoryTest {

    @Test
    public void createOccupant() {
        Occupant occupant = OccupantFactory.createOccupant("Neil", "Johnson");

        Assert.assertEquals(occupant, occupant);
    }
}