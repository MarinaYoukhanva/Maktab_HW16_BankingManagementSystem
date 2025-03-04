package org.bank.entity.dto;

import lombok.ToString;
import org.bank.entity.Account;
import org.bank.entity.CreditCard;
import org.bank.entity.Customer;
import org.bank.entity.enums.AccountType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CreatedAccountInfoDto(

        Long CustomerId,
        String firstName,
        String lastName,
        String username,
        String password,
        String customerCode,
        String nationalCode,
        String phoneNumber,

        Long accountId,
        String accountNumber,
        String accountSheba,
        Long balance,
        AccountType accountType,
        LocalDateTime accountCreatedAt,
        Long bankBranchId,

        Long creditCardId,
        String cardNumber,
        String cvv2,
        LocalDateTime expiryDate,
        String firstPass,
        String secondPass
) {

}

