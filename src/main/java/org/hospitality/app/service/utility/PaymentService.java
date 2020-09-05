package org.hospitality.app.service.utility;

import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.service.IService;

import java.util.Set;

public interface PaymentService extends IService<Payment, String> {
    Set<Payment> getAll();

}
