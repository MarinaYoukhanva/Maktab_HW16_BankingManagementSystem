package org.bank.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

    String firstName;
    String lastName;
    String customerCode;
    String nationalCode;
}
