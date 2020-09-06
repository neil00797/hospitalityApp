package org.hospitality.app.service.utility.impl;

import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.repository.utility.PaymentRepository;
import org.hospitality.app.repository.utility.impl.PaymentRepositoryImpl;
import org.hospitality.app.service.utility.PaymentService;

import java.util.HashSet;
import java.util.Set;

public class PaymentServiceImpl implements PaymentService {
    private static PaymentService service = null;
    private PaymentRepository repository;

    private PaymentServiceImpl(){
        this.repository = PaymentRepositoryImpl.getRepository();
    }

    public static PaymentService getService(){
        if (service == null)
            service = new PaymentServiceImpl();
        return service;
    }


    @Override
    public Set<Payment> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Set<Payment> getCashPayments() {
        Set<Payment> payments = getAll();
        Set<Payment> paymentsWithCash = new HashSet<>();

        for (Payment payment: payments){
            if (payment.getPaymentMethod().equalsIgnoreCase("Cash")){
                paymentsWithCash.add(payment);
            }
        }
        return paymentsWithCash;
    }

    @Override
    public Payment create(Payment payment) {
        return this.repository.create(payment);
    }

    @Override
    public Payment read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Payment update(Payment payment) {
        return this.repository.update(payment);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
