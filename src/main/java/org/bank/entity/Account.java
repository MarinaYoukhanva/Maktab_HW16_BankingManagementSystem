package org.bank.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bank.base.model.BaseEntity;
import org.bank.entity.enums.AccountType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Account extends BaseEntity<Long> {

    String accountNumber;
    String accountSheba;
    Long balance;
    LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    AccountType accountType;

    @ManyToOne(optional = false)
    Customer owner;

    @OneToOne(mappedBy = "account")
    CreditCard creditCard;

    @ManyToOne(optional = false)
    BankBranch bankBranch;

    @Override
    public String toString() {
        return "Account{" +
                "id" + getId() +
                "accountNumber='" + accountNumber + '\'' +
                ", accountSheba='" + accountSheba + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", accountType=" + accountType +
                ", owner=" + owner.getId() +
                ", creditCard=" + creditCard.getId() +
                ", bankBranch=" + bankBranch +
                '}';
    }
}
