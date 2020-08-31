package org.hospitality.app.factory.user;

import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.util.Helper;

//Thaakir Ajouhaar 217244394

public class StayInformationFactory
{
    public static StayInformation createStayInformation(String stayDuration)
    {
        String stayInformationId = Helper.generateId();
        String occupantId = Helper.generateId();
        String deliveriesID = Helper.generateId();

        StayInformation stayInformation = new StayInformation.Builder()
                .setOccupantNumber(stayInformationId)
                .setOccupantId(occupantId)
                .setDeliveries(deliveriesID)
                .setStayDuration(stayDuration)
                .build();

        return stayInformation;
    }
}
