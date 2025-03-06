package org.bank.repository.impl;

import org.bank.base.repository.BaseRepositoryImpl;
import org.bank.entity.CreditCard;
import org.bank.repository.CreditCardRepository;
import org.hibernate.Session;

import java.util.List;

public class CreditCardRepositoryImpl extends BaseRepositoryImpl<Long, CreditCard>
implements CreditCardRepository {
    public CreditCardRepositoryImpl(Class<CreditCard> entityClass) {
        super(entityClass);
    }

    @Override
    public List<String> findCustomerCards(Session session, Long customerId) {
        return session.createQuery("SELECT cc.cardNumber FROM CreditCard cc WHERE cc.account.owner.id = :customerId"
                ,String.class)
                .setParameter("customerId", customerId)
                .list();
    }
}
