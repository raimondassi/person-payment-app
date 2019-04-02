package se.spp.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.spp.common.Payment;
import se.spp.common.Person;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PaymentService {


    @Autowired
    public PaymentRepository paymentRepository;

    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    public Optional<Payment> findPayment(Long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        paymentRepository.findAll()
                .forEach(payments::add);
        return payments;
    }

    public List<Payment> getPaymentsForPerson(String personId) {
        List<Payment> payments = new ArrayList<>();
        paymentRepository.findAll()
                .forEach(payments::add);
        return payments
                .stream()
                .filter(payment -> payment.getPersonId().equals(personId))
                .collect(Collectors.toList());

    }

    public void updatePayment(Payment payment) {
        paymentRepository.save(payment);
    }

}

