package org.hospitality.app.factory.impl;
/*
    author: @Shaun Donnelly
    desc: PaymentRepositoryImplTest
    date: 24-08-2020
 */
import junit.framework.TestCase;
import org.hospitality.app.entity.service.Payment;
import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.factory.service.PaymentFactory;
import org.hospitality.app.repository.service.PaymentRepository;
import org.hospitality.app.repository.service.impl.PaymentRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaymentRepositoryImplTest{

    private static PaymentRepository repository = PaymentRepositoryImpl.getRepository();
    private static Payment payment = PaymentFactory.createPayment("Cash", 1000.00,500.00,1500.00 );

    @Test
    public void a_create(){
        Payment created = repository.create(payment);
        Assert.assertEquals(payment.getReceiptNumber(), created.getReceiptNumber());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read(){
        Payment read = repository.read(payment.getPaymentMethod());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update(){
        Payment updated = new Payment.Builder().copy(payment).setRoomCost(800.00).build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete(){
        boolean deleted = repository.delete(payment.getPaymentMethod());
        Assert.assertTrue(deleted);
    }

    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }
}
