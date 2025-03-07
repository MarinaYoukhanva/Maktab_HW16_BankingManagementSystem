package org.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bank.base.model.BaseEntity;
import org.bank.entity.enums.EmployeePosition;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Employee extends BaseEntity<Long> {

    String username;
    String password;
    String employeeCode;
    String nationalCode;


    @Enumerated(EnumType.STRING)
    EmployeePosition position;

    @ManyToOne
    Employee manager;

    @ManyToOne(optional = false)
    BankBranch bankBranch;
}
