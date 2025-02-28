package org.bank.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bank.entity.enums.EmployeePosition;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    String username;
    String password;
    EmployeePosition position;
}
