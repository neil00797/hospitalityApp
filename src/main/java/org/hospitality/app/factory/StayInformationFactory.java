package org.hospitality.app.factory;

import org.hospitality.app.entity.StayInformation;
import org.hospitality.app.util.Helper;

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
