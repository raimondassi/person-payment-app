package se.spp.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se.spp.common.Payment;
import se.spp.common.Person;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    @Autowired
    public PaymentRepository paymentRepository;
    @Value("${personUrl}")
    String personUrl;

    public void addPaymentWithPersonOfficialId(String officialId, Payment payment) {
        RestTemplate restTemplate = new RestTemplate();
        String personResourceUrl = personUrl + "find-person-from-official-id/";
        Person personFromOfficialId = restTemplate.getForObject(personResourceUrl + officialId, Person.class);
        Long personId = personFromOfficialId.getId();
        payment.setPersonId(personId);
        addPayment(payment);
    }

    public void addPayment(Payment payment) {
        if (paymentRepository.findById(payment.getPersonId()).isPresent()) {
            System.out.println("The payment already exist");
            return;
        } else
            paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        if (paymentRepository.findById(id).isPresent())
            paymentRepository.deleteById(id);
        else
            System.out.println("The payment does not exist");
        return;
    }

    public Optional<Payment> findPayment(Long id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll().stream().collect(Collectors.toList());
    }

    public List<Payment> getPaymentsForPerson(String officialId) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String personResourceUrl = personUrl + "find-person-from-official-id/";
            Person personFromOfficialId = restTemplate.getForObject(personResourceUrl + officialId, Person.class);
            Long personId = personFromOfficialId.getId();
            return paymentRepository.findAll().stream().filter(payment -> payment.getPersonId() == personId).collect(Collectors.toList());
        } catch (NullPointerException e) {
            System.out.println("No person or payment");
            return null;
        }
    }

    public void updatePayment(Payment payment) {
        if (paymentRepository.findById(payment.getPaymentId()).isPresent())
            paymentRepository.save(payment);
        else {
            System.out.println("The payment does not exist");
            return;
        }
    }
}

