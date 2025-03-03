package org.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bank.base.model.BaseEntity;
import org.bank.entity.enums.TransactionType;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Transaction extends BaseEntity<Long> {

    Long amount;

    @Enumerated(EnumType.STRING)
    TransactionType transactionType;

    @ManyToOne(optional = false)
    Account sourceAccount;

    @ManyToOne
    Account destinationAccount;
}
