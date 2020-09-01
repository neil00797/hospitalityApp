package org.hospitality.app.repository.utility;
/*
    author: @Shaun Donnelly
    desc: PaymentRepository
    date: 24-08-2020
 */

import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.repository.IRepository;

import java.util.Set;

public interface PaymentRepository extends IRepository<Payment, String> {
    Set<Payment> getAll();
}
