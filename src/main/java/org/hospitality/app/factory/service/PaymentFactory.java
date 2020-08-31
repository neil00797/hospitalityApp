package org.hospitality.app.factory.service;

import org.hospitality.app.entity.service.Payment;
import org.hospitality.app.util.Helper;

/*
    author: Shaun Donnelly
    desc: Entity for PaymentFactory
 */

public class PaymentFactory {
    public static Payment createPayment(

            String paymentMethod,
            double roomCost,
            double serviceCost,
            double totalStayCost){

        String receiptNumber = Helper.generateId();

        Payment payment = new Payment.Builder()
                .setReceiptNumber(receiptNumber)
                .setPaymentMethod(paymentMethod)
                .setRoomCost(roomCost)
                .setServiceCost(serviceCost)
                .setTotalStayCost(totalStayCost)
                .build();

        return payment;
    }
}
