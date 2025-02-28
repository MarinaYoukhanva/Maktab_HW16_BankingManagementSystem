package org.bank.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bank.entity.enums.AccountType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {

    String accountNumber;
    String accountSheba;
    AccountType accountType;
    Long balance;
    LocalDate createdAt;
}
