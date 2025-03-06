package org.bank.repository;

import org.bank.base.repository.BaseRepository;
import org.bank.entity.CreditCard;
import org.hibernate.Session;

import java.util.List;

public interface CreditCardRepository extends BaseRepository<Long, CreditCard> {
    List<String> findCustomerCards (Session session, Long customerId);
}
