package org.bank.service;

import org.bank.base.service.BaseService;
import org.bank.entity.CreditCard;
import org.hibernate.Session;

import java.time.LocalDate;

public interface CreditCardService extends BaseService<Long, CreditCard> {
    CreditCard create(Session session);

    void cardToCard(Long customerId, String sourceCardNumber,
                    String destinationCardNumber, Long amount,
                    String secondPass, String cvv2, LocalDate expiryDate);
}
