package org.hospitality.app.factory.utility;
/*
    author: @Moliehi Mabilietse
    desc : Service entity
 */

import org.hospitality.app.entity.utility.Service;
import org.hospitality.app.util.Helper;

public class ServiceFactory {

    public static Service createService(String serviceType) {

        String serviceId = Helper.generateId();

        Service service = new Service.Builder()
                .setserviceId(serviceId)
                .setServiceType(serviceType)
                .build();

        return service;

    }
}
