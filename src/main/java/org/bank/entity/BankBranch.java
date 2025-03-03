package org.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bank.base.model.BaseEntity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class BankBranch extends BaseEntity<Long> {

    String branchNumber;
    String name;
    String address;

    @OneToOne
    Employee branchManager;
}
