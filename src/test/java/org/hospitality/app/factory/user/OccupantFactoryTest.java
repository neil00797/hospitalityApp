package org.hospitality.app.factory.user;
/*
    author: @NeilJohnson
    desc: Factory Test for Occupant
    date: 29-06-2020
 */
import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.factory.user.OccupantFactory;
import org.junit.Assert;
import org.junit.Test;

public class OccupantFactoryTest {

    @Test
    public void createOccupant() {
        Occupant occupant = OccupantFactory.createOccupant("Neil", "Johnson");

        Assert.assertEquals(occupant, occupant);
        //Test
    }
}