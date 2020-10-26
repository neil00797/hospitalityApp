package org.hospitality.app.service.utility.impl;

import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.repository.utility.PaymentRepository;
import org.hospitality.app.service.utility.PaymentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Service
public class PaymentServiceImpl implements PaymentService {
    private static PaymentService service = null;
    private PaymentRepository repository;

    /*private PaymentServiceImpl(){
        this.repository = PaymentRepositoryImpl.getRepository();
    }

    public static PaymentService getService(){
        if (service == null)
            service = new PaymentServiceImpl();
        return service;
    }*/


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
        return this.repository.save(payment);
    }

    @Override
    public Payment read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Payment update(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s))
            return false;

        else return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentServiceImpl that = (PaymentServiceImpl) o;
        return repository.equals(that.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repository);
    }
}
