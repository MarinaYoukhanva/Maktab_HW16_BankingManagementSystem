package org.bank.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bank.base.model.BaseEntity;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CreditCard extends BaseEntity<Long> {

    String cardNumber;
    String cvv2;
    LocalDate expiryDate;
    String firstPass;
    String secondPass;
}
