package org.hospitality.app.entity.utility;

/*
    author: Shaun Donnelly
    desc: Entity for Payment
 */


import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Payment implements Serializable {

    @Id
    private String receiptNumber;
    private String paymentMethod;
    private double roomCost, serviceCost, totalStayCost;

    // changed from private to protected when adding to database
    protected Payment(){}

    private Payment(Builder builder){
        this.receiptNumber = builder.receiptNumber;
        this.paymentMethod = builder.paymentMethod;
        this.roomCost = builder.roomCost;
        this.serviceCost = builder.serviceCost;
        this.totalStayCost = builder.totalStayCost;
    }
    public String getReceiptNumber(){return receiptNumber;}

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getRoomCost() {
        return roomCost;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public double getTotalStayCost() {
        return totalStayCost;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "receiptNumber='" + receiptNumber + '\'' +
                ", paymentMethod='" + paymentMethod +
                ", roomCost=" + roomCost +
                ", serviceCost=" + serviceCost +
                ", totalStayCost=" + totalStayCost +
                '}';
    }

    public static class Builder{
        private String receiptNumber, paymentMethod;
        private double roomCost, serviceCost, totalStayCost;

        public Builder setReceiptNumber(String receiptNumber) {
            this.receiptNumber = receiptNumber;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setRoomCost(double roomCost){
            this.roomCost = roomCost;
            return this;
        }

        public Builder setServiceCost(double serviceCost){
            this.serviceCost = serviceCost;
            return this;
        }

        public Builder setTotalStayCost(double totalStayCost){
            this.totalStayCost = totalStayCost;
            return this;
        }

        public Builder copy(Payment payment){
            this.receiptNumber = payment.receiptNumber;
            this.paymentMethod = payment.paymentMethod;
            this.roomCost = payment.roomCost;
            this.serviceCost = payment.serviceCost;
            this.totalStayCost = payment.totalStayCost;
            return this;
        }

        public Payment build(){
            return new Payment(this);
        }

    }
}
