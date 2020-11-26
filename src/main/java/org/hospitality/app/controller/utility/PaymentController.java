package org.hospitality.app.controller.utility;
import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.factory.utility.PaymentFactory;
import org.hospitality.app.service.utility.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hospitality_db/payment")
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

    @GetMapping("/read/{paymentMethod}")
    public Payment read(@PathVariable String paymentMethod)
    {
        return paymentService.read(paymentMethod);
    }

    @GetMapping("/update")
    public Payment update(@RequestBody Payment s)
    {
        return paymentService.update(s);
    }

    @GetMapping("/all")
    public Set<Payment> getAll()
    {
        return paymentService.getAll();

    }
    @DeleteMapping("/delete/{paymentMethod}")
    public boolean delete(@PathVariable String paymentMethod)
    {
        return paymentService.delete(paymentMethod);
    }

}
