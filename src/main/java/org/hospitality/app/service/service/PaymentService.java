package org.hospitality.app.service.service;

import org.hospitality.app.entity.service.Payment;
import org.hospitality.app.service.IService;

import java.util.Set;

public interface PaymentService extends IService<Payment, String> {
    Set<Payment> getAll();

}
