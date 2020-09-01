package org.hospitality.app.service.service.impl;

import org.hospitality.app.entity.service.Payment;
import org.hospitality.app.repository.service.PaymentRepository;
import org.hospitality.app.repository.service.impl.PaymentRepositoryImpl;
import org.hospitality.app.service.service.PaymentService;

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
