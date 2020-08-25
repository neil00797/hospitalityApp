package org.hospitality.app.factory.service;
/*
    author: @Moliehi Mabilietse
    desc : Service entity
 */

import org.hospitality.app.entity.service.Service;
import org.hospitality.app.util.Helper;

public class ServiceFactory {

    public static Service createService(String serviceType) {

        String serviceId = Helper.generateId();

        Service service = new Service.Builder()
                .setserviceId(serviceId)
                .setserviceType(serviceType)
                .build();

        return service;

    }
}
