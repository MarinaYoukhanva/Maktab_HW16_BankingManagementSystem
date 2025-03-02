package org.bank.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bank.base.model.BaseEntity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BankBranch extends BaseEntity<Long> {

    String branchNumber;
    String name;
    String address;
}
