package org.hospitality.app.controller.utility;
import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.factory.utility.PaymentFactory;
import org.hospitality.app.service.utility.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/payment")
public class PaymentController
{

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment)
    {
        Payment newPayment = PaymentFactory.createPayment(payment.getPaymentMethod(),payment.getRoomCost(),payment.getServiceCost(),payment.getTotalStayCost());
        return paymentService.create(newPayment);
    }

    @GetMapping("/all")
    public Set<Payment> getAll()
    {
        return paymentService.getAll();

    }
}
