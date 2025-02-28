package org.bank.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreditCard {

    String cardNumber;
    String cvv2;
    LocalDate expiryDate;
    String firstPass;
    String secondPass;
}
