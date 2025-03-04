package org.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bank.base.model.BaseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CreditCard extends BaseEntity<Long> {

    @Column(
            unique = true, nullable = false, length = 16)
    @NotBlank(
            message = "cardNumber can not be null or blank! ")
    @Size(min = 16, max = 16,
            message = "cardNumber must have 16 digits! ")
    @Pattern(regexp = "^\\d{16}$",
            message = "invalid format for cardNumber! ")
    String cardNumber;

    @Column(
             nullable = false, length = 3)
    @NotBlank(
            message = "cvv2 can not be null or blank! ")
    @Size(min = 3, max = 3,
            message = "cvv2 must have 3 digits! ")
    @Pattern(regexp = "^\\d{3}$",
            message = "invalid format for cvv2! ")
    String cvv2;

    LocalDateTime expiryDate;

    @Column(
            nullable = false, length = 4)
    @NotBlank(
            message = "firstPass can not be null or blank! ")
    @Size(min = 4, max = 4,
            message = "firstPass must have 4 digits! ")
    @Pattern(regexp = "^\\d{4}$",
            message = "invalid format for firstPass! ")
    String firstPass;

    @Column(
            nullable = false, length = 6)
    @NotBlank(
            message = "secondPass can not be null or blank! ")
    @Size(min = 6, max = 6,
            message = "secondPass must have 6 digits! ")
    @Pattern(regexp = "^\\d{6}$",
            message = "invalid format for secondPass! ")
    String secondPass;

    @OneToOne(optional = false)
    Account account;

    @Override
    public String toString() {
        return "CreditCard{" +
                "id" + getId() +
                "cardNumber='" + cardNumber + '\'' +
                ", cvv2='" + cvv2 + '\'' +
                ", expiryDate=" + expiryDate +
                ", firstPass='" + firstPass + '\'' +
                ", secondPass='" + secondPass + '\'' +
                ", account=" + account.getId() +
                '}';
    }
}
