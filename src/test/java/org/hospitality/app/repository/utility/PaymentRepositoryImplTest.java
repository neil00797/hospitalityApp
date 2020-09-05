package org.hospitality.app.repository.utility;
/*
    author: @Shaun Donnelly
    desc: PaymentRepositoryImplTest
    date: 24-08-2020
 */
import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.factory.utility.PaymentFactory;
import org.hospitality.app.repository.utility.PaymentRepository;
import org.hospitality.app.repository.utility.impl.PaymentRepositoryImpl;
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
