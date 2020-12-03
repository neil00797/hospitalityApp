package org.hospitality.app.entity.utility;

/*
    author: Shaun Donnelly
    desc: Entity for Delivery
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
// @Table(name ="new name if you don't want to use class name")
public class  Delivery implements Serializable {
    @Id
    private String deliveryNumber;
    private String roomNumber, serviceType ;

    // changed from private to protected when adding to database
    protected Delivery(){}

    private Delivery(Builder builder){
        this.deliveryNumber = builder.deliveryNumber;
        this.roomNumber = builder.roomNumber;
        this.serviceType = builder.serviceType;
    }

    public String getDeliveryNumber() {
        return deliveryNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getServiceType() {
        return serviceType;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryNumber='" + deliveryNumber + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }

    public static class Builder{
        private String deliveryNumber, roomNumber, serviceType;

        public Builder setDeliveryNumber(String deliveryNumber){
            this.deliveryNumber = deliveryNumber;
            return this;
        }

        public Builder setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public Builder setServiceType(String serviceType){
            this.serviceType = serviceType;
            return this;
        }

        public Builder copy(Delivery delivery){
            this.deliveryNumber = delivery.deliveryNumber;
            this.roomNumber = delivery.roomNumber;
            this.serviceType = delivery.serviceType;
            return this;
        }

        public Delivery build(){
            return new Delivery(this);
        }
    }
}
