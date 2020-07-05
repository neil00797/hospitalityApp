package org.hospitality.app.factory;

import org.hospitality.app.entity.Payment;

/*
    author: Shaun Donnelly
    desc: Entity for PaymentFactory
 */

public class PaymentFactory {
    public static Payment createPayment(String paymentMethod, double roomCost, double serviceCost, double totalStayCost){
        Payment payment = new Payment.Builder()
                .setPaymentMethod(paymentMethod)
                .setRoomCost(roomCost)
                .setServiceCost(serviceCost)
                .setTotalStayCost(totalStayCost)
                .build();

        return payment;
    }
}
