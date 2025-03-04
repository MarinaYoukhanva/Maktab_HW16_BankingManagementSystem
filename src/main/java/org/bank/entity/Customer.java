package org.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bank.base.model.BaseEntity;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Customer extends BaseEntity<Long> {

    String firstName;
    String lastName;
    String username;
    String password;
    String customerCode;
    String nationalCode;
    String phoneNumber;

    @OneToMany(mappedBy = "owner")
    List<Account> accounts;

    public record CustomerDto(String firstName, String lastName,
                              String nationalCode, String phoneNumber) {}

    @Override
    public String toString() {
        return "Customer{" +
                "id" + getId() +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
