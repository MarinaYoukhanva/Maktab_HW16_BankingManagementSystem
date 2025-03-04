package org.bank.service;

import org.bank.base.service.BaseService;
import org.bank.entity.CreditCard;
import org.hibernate.Session;

public interface CreditCardService extends BaseService<Long, CreditCard> {
    CreditCard create(Session session);
}
