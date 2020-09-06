package org.hospitality.app.service.utility.impl;

import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.factory.utility.PaymentFactory;
import org.hospitality.app.repository.utility.PaymentRepository;
import org.hospitality.app.repository.utility.impl.PaymentRepositoryImpl;
import org.hospitality.app.service.utility.PaymentService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaymentServiceImplTest {
    private static PaymentService service = PaymentServiceImpl.getService();
    private static Payment payment = PaymentFactory.createPayment("Cash", 1000.00, 500.00, 1500.00);
    private static Payment payment2 = PaymentFactory.createPayment("EFT", 1599.00, 1000.00, 2599.00);

    @Test
    public void e_getAll() {

            System.out.println("Get all: " + service.getAll() + "\n");
    }

    @Test
    public void a_create() {
        Payment created = service.create(payment);
        Assert.assertEquals(payment.getReceiptNumber(), created.getReceiptNumber());

        Payment created2 = service.create(payment2);
        Assert.assertEquals(payment2.getReceiptNumber(), created2.getReceiptNumber());
        System.out.println("Created Record1: " + created + "\n" +"Created Record2: " + created2 + "\n");
    }

    @Test
    public void b_read() {
        Payment read = service.read(payment.getPaymentMethod());
        Payment read2 = service.read(payment2.getPaymentMethod());
        System.out.println("Read Record1: " + read + "\n" + "Read Record2: " + read2 + "\n");
    }

    @Test
    public void c_update() {
        Payment updated = new Payment.Builder().copy(payment).setRoomCost(800.00).setServiceCost(800.00).setTotalStayCost(1600.00).build();
        Payment updated2 = new Payment.Builder().copy(payment2).setRoomCost(2000.00).setServiceCost(1000.00).setTotalStayCost(3000.00).build();
        updated = service.update(updated);
        updated2 = service.update(updated2);
        System.out.println("Updated: " + updated + "\n" + "Updated2: " + updated2 + "\n");
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(payment.getPaymentMethod());
        Assert.assertTrue(deleted);
        boolean deleted2 = service.delete(payment2.getPaymentMethod());
        Assert.assertTrue(deleted2);
        System.out.println("Records Deleted Successfully");
    }

    @Test
    public void d_getCashPayments(){
        Set<Payment> paymentsWithCash = service.getCashPayments();
        System.out.println("Records with Cash Payments: " +  paymentsWithCash + "\n");
    }
}