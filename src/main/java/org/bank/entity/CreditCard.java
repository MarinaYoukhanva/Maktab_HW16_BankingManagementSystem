package org.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bank.base.model.BaseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CreditCard extends BaseEntity<Long> {

    String cardNumber;
    String cvv2;
    LocalDateTime expiryDate;
    String firstPass;
    String secondPass;

    @OneToOne(optional = false)
    Account account;

    @Override
    public String toString() {
        return "CreditCard{" +
                "id" + getId() +
                "cardNumber='" + cardNumber + '\'' +
                ", cvv2='" + cvv2 + '\'' +
                ", expiryDate=" + expiryDate +
                ", firstPass='" + firstPass + '\'' +
                ", secondPass='" + secondPass + '\'' +
                ", account=" + account.getId() +
                '}';
    }
}
