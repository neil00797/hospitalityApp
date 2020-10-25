package org.hospitality.app.repository.utility;
/*
    author: @Shaun Donnelly
    desc: PaymentRepository
    date: 24-08-2020
 */

import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
    Set<Payment> getAll();
}
