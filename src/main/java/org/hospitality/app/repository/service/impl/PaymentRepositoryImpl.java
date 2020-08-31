package org.hospitality.app.repository.service.impl;
/*
    author: @Shaun Donnelly
    desc: PaymentRepositoryImpl
    date: 24-08-2020
 */
import org.hospitality.app.entity.service.Delivery;
import org.hospitality.app.entity.service.Payment;
import org.hospitality.app.repository.service.DeliveryRepository;
import org.hospitality.app.repository.service.PaymentRepository;

import javax.sound.midi.Receiver;
import java.util.HashSet;
import java.util.Set;

public class PaymentRepositoryImpl implements PaymentRepository {
    private static PaymentRepository repository = null;
    private Set<Payment> paymentDB;

    private PaymentRepositoryImpl(){
        this.paymentDB = new HashSet<>();
    }

    public static PaymentRepository getRepository(){
        if (repository == null) repository = new PaymentRepositoryImpl();
        return repository;
    }

    @Override
    public Payment create(Payment payment) {
        this.paymentDB.add(payment);
        return payment;
    }

    @Override
    public Payment read(String receiptNumber) {
        for (Payment payment: this.paymentDB){
            if (payment.getPaymentMethod().equalsIgnoreCase(receiptNumber))
                return payment;
        }
        return null;
    }

    @Override
    public Payment update(Payment payment) {
        boolean deletePayment = delete(payment.getPaymentMethod());
        if(deletePayment){
            this.paymentDB.add(payment);
            return payment;
        }
        return null;
    }

    @Override
    public boolean delete(String receiptNumber) {
        Payment payment = read(receiptNumber);
        if(payment != null){
            this.paymentDB.remove(payment);
            return true;
        }
        return false;

    }

    @Override
    public Set<Payment> getAll() {
        return this.paymentDB;
    }
}
