package org.bank.repository.impl;

import org.bank.base.repository.BaseRepositoryImpl;
import org.bank.entity.CreditCard;
import org.bank.repository.CreditCardRepository;

public class CreditCardRepositoryImpl extends BaseRepositoryImpl<Long, CreditCard>
implements CreditCardRepository {
    public CreditCardRepositoryImpl(Class<CreditCard> entityClass) {
        super(entityClass);
    }


}
