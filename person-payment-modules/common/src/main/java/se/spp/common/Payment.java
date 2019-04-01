package se.spp.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Payment {

    private String personId;
    @Id
  //@GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long paymentId;
    private double ammount;
    private LocalDateTime date;

    public Payment(String personId, Long paymentId, double ammount, LocalDateTime date) {
        this.personId = personId;
        this.paymentId = paymentId;
        this.ammount = ammount;
        this.date = date;
    }

    public Payment() {

    }


    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
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

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
