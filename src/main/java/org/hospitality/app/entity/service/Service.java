package org.hospitality.app.entity.service;
/*
    author: @Moliehi Mabilietse
    desc : Service entity
 */

public class Service {

    private static String serviceId;
    private static String serviceType;


    private Service(Builder builder) {
        this.serviceId = builder.serviceId;
        this.serviceType = builder.serviceType;


    }

    public String serviceId() {
        return serviceId;
    }

    public String serviceType() {
        return serviceType;
    }

    @Override
    public String toString() {
        return "Position{" +
                "serviceId='" + serviceId + '\'' +
                ", positionStatus='" + serviceType + '\'' +
                '}';
    }

    public String getServiceId() {
        return serviceId();
    }

    public static class Builder {

        public String serviceType;
        String serviceId, positionStatus;

        public Builder setserviceId(String serviceId) {

            this.serviceId = serviceId;
            return this;

        }


        public Builder copy(Service Service) {

            this.serviceId = Service.serviceId;
            this.serviceType = Service.serviceType;
            return this;

        }

        public Builder setserviceType(String serviceType) {

            this.serviceType = serviceType;
            return this;

        }

        public Service build() {

            return new Service(this);

        }


    }


}



