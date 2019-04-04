package se.spp.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.spp.common.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
