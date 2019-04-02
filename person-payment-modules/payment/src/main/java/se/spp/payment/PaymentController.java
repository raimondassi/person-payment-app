package se.spp.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.spp.common.Payment;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    public final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/add-payment")
    public void addPayment(@RequestBody Payment payment) {
        paymentService.addPayment(payment);

    }

    @PostMapping("/delete-payment/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }

    @GetMapping("/find-payment/{id}")
    public Optional<Payment> findPayment(@PathVariable Long id) {
        return paymentService.findPayment(id);
    }

    @GetMapping("/get-all-payments")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/get-payments-for-person/{personId}")
    public List<Payment> getAllPaymentsForPerson(@PathVariable String personId) {
        return paymentService.getPaymentsForPerson(personId);
    }

    @PostMapping("/update-payment")
    public void updatePayment(@RequestBody Payment payment) {
        paymentService.updatePayment(payment);
    }

}


