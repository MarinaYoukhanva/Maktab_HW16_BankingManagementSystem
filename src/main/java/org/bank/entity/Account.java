package org.bank.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bank.base.model.BaseEntity;
import org.bank.entity.enums.AccountType;

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

    LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    AccountType accountType;

    @ManyToOne(optional = false)
    Customer owner;

    @OneToOne(mappedBy = "account")
    CreditCard creditCard;

    @ManyToOne(optional = false)
    BankBranch bankBranch;

    public record AccountDto(
            AccountType accountType,
            Long bankBranchId, Long balance){ }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + getId() + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountSheba='" + accountSheba + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", accountType=" + accountType +
                ", owner-id=" + owner.getId() +
                ", creditCard-id=" + creditCard.getId() +
                ", bankBranch-id=" + bankBranch.getId() +
                '}';
    }
}
