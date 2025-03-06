package org.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @Column(
            nullable = false, length = 50)
    @NotBlank(
            message = "firstname can not be null or blank! ")
    @Size(max = 50,
            message = "long firstname! ")
    @Pattern(regexp = "^[a-zA-Z]+$",
            message = "firstname only can contains letters! ")
    String firstName;

    @Column(
            nullable = false, length = 50)
    @NotBlank(
            message = "lastname can not be null or blank! ")
    @Size(max = 50,
            message = "long lastname! ")
    @Pattern(regexp = "^[a-zA-Z]+$",
            message = "lastname only can contains letters! ")
    String lastName;

    @Column(
            nullable = false, unique = true, length = 50)
    @NotBlank(
            message = "username can not be null or blank! ")
    @Size(max = 50,
            message = "long username! ")
    String username;

    @Column(
            nullable = false, length = 50)
    @NotBlank(
            message = "password can not be null or blank! ")
    @Size(min = 8, max = 50,
            message = "password must have 8-50 characters! ")
    String password;


    @Column(
            unique = true, nullable = false, length = 10)
    @NotBlank(
            message = "customer_code can not be null or blank! ")
    @Size(min = 10, max = 10,
            message = "customer_code must have 10 digits! ")
    @Pattern(regexp = "^\\d{10}$",
            message = "invalid format for customer_code! ")
    String customerCode;

    @Column(
            nullable = false, unique = true, length = 10, updatable = false)
    @NotBlank(
            message = "national_code can not be null or blank! ")
    @Pattern(regexp = "^\\d{10}$",
            message = "invalid format for national-code! ")
    @Size(min = 10, max = 10,
            message = "national-code must have 10 digits! ")
    String nationalCode;

    @Column(
            nullable = false, length = 15)
    @NotBlank(
            message = "phone_number can not be null or blank! ")
    @Size(max = 15,
            message = "long phone_number! ")
    @Pattern(regexp = "^((0098)0?9|\\+980?9)[01239]\\d{8}$",
            message = "invalid phone-number! ")
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
                ", accounts=" + accounts.stream().map(BaseEntity::getId) +
                '}';
    }
}
