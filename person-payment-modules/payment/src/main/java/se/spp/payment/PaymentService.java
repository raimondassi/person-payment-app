package se.spp.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
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

    public List<Payment> getPaymentsForPerson(String officialId) {
        List<Payment> payments = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        String personResourceUrl = "http://localhost:8081/person//find-person-from-official-id/";
        Person personFromOfficialId = restTemplate.getForObject(personResourceUrl + officialId, Person.class);
        Long personId = personFromOfficialId.getId();
        return (List<Payment>) paymentRepository.findAllById(Collections.singleton(personId));

    }

    public void updatePayment(Payment payment) {
        paymentRepository.save(payment);
    }

}

