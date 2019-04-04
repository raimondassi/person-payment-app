package se.spp.common;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Payment {
    private Long personId;
    @Id
    private Long paymentId;
    private double amount;
    private LocalDateTime date;

    public Payment(Long personId, Long paymentId, double ammount, LocalDateTime date) {
        this.personId = personId;
        this.paymentId = paymentId;
        this.amount = ammount;
        this.date = date;
    }

    public Payment() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
