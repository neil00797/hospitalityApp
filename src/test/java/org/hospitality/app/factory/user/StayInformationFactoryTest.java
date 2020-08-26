package org.hospitality.app.factory.user;

import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.factory.user.StayInformationFactory;
import org.junit.Assert;
import org.junit.Test;
//Thaakir Ajouhaar 217244394

public class StayInformationFactoryTest {

    @Test
    public void createStayInformation() {
        StayInformation stayInformation = StayInformationFactory.createStayInformation("3 Days");
        Assert.assertEquals(stayInformation, stayInformation);
    }
}