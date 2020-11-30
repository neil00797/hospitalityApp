package org.hospitality.app.entity.utility;
/*
    author: @Moliehi Mabilietse
    desc : Service entity
 */



import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Facility{

    @Id
    private String serviceId;
    private String serviceType;

    protected Facility(){}


    private Facility(Builder builder) {
        this.serviceId = builder.serviceId;
        this.serviceType = builder.serviceType;


    }

    @Override
    public String toString() {
        return "Position{" +
                "serviceId='" + serviceId + '\'' +
                ", positionStatus='" + serviceType + '\'' +
                '}';
    }

    public String getServiceId() {
        return serviceId;
    }
    public String getServiceType(){
        return serviceType;
    }

    public static class Builder {

        private String serviceType;
        private String serviceId;

        public Builder setServiceId(String serviceId) {
            this.serviceId = serviceId;
            return this;

        }
        public Builder setServiceType(String serviceType) {
            this.serviceType = serviceType;
            return this;

        }


        public Builder copy(Facility facility) {

            this.serviceId = facility.serviceId;
            this.serviceType = facility.serviceType;
            return this;

        }

        public Facility build() {

            return new Facility(this);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return serviceId.equals(facility.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId);
    }

}



