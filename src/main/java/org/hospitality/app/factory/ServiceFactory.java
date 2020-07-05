package org.hospitality.app.factory;
/*
    author: @Moliehi Mabilietse
    desc: Factory for service
 */


import org.hospitality.app.entity.Service;
import org.hospitality.app.util.Helper;

public class ServiceFactory {

 public static Service createService(String serviceType){

  String serviceId = Helper.generateId();

  Service service = new Service.Builder()
          .setserviceId(serviceId)
          .setserviceType(serviceType)
          .build();

  return service;
  }

}







