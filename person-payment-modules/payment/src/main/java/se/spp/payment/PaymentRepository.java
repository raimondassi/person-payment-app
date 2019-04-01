package se.spp.payment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import se.spp.common.Payment;

import java.lang.annotation.Target;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {



}
