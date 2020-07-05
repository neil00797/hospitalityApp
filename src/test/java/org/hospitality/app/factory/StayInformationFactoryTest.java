package org.hospitality.app.factory;

import org.hospitality.app.entity.StayInformation;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
//Thaakir Ajouhaar 217244394

public class StayInformationFactoryTest {

    @Test
    public void createStayInformation() {
        StayInformation stayInformation = StayInformationFactory.createStayInformation("3 Days");
        Assert.assertEquals(stayInformation, stayInformation);
    }
}