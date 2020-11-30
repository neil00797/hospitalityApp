package org.hospitality.app.factory.utility;
/*
    author: @Moliehi Mabilietse
    desc : Service entity
 */

import org.hospitality.app.entity.utility.Facility;


import static org.hospitality.app.util.Helper.generateId;

public class FacilityFactory {

    public static Facility createService(String serviceType) {
        return new Facility.Builder().setServiceId(generateId())
                .setServiceType(serviceType)
                .build();


    }
}
