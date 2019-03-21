package se.spp.payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.spp.common.Payment;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping("/get/{id}")
    public Payment getPayment(@PathVariable Long id) {
        System.out.println(id);
        return new Payment();
    }

}
