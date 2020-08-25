package org.hospitality.app.entity.service;

/*
    author: Shaun Donnelly
    desc: Entity for Delivery
 */

public class Delivery {
    private String deliveryNumber, roomNumber, serviceType ;


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
