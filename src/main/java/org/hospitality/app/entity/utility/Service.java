package org.hospitality.app.entity.utility;
/*
    author: @Moliehi Mabilietse
    desc : Service entity
 */

import javax.persistence.Entity;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
public class Service implements Serializable {

    @Id
    private String serviceId;
    private String serviceType;

    protected Service(){}
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

        public String serviceType, serviceId;

        public Builder setServiceId(String serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Builder setServiceType(String serviceType) {
            this.serviceType = serviceType;
            return this;
        }


        public Builder copy(Service Service) {
            this.serviceId = Service.serviceId;
            this.serviceType = Service.serviceType;
            return this;
        }

        public Service build() {
            return new Service(this);
        }


    }


}



