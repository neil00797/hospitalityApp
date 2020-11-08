package org.hospitality.app.entity.utility;
/*
    author: @Moliehi Mabilietse
    desc : Service entity
 */



import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Service implements Serializable {

    @Id
    private static String serviceId;
    private static String serviceType;

    protected Service(){}


    public Service(Builder builder) {
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
    public String getServiceType(){
        return serviceType();}

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

        public Builder setServiceType(String serviceType) {

            this.serviceType = serviceType;
            return this;

        }

        public Service build() {

            return new Service(this);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service.Builder builder = (Service.Builder) o;
        return serviceId().equals(builder.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId());
    }

}



