package org.bank.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer extends User {

    String firstName;
    String lastName;
    String username;
    String password;
    String customerCode;
    String nationalCode;
}
