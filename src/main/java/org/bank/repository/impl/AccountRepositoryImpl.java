package org.bank.repository.impl;

import org.bank.base.repository.BaseRepositoryImpl;
import org.bank.entity.Account;
import org.bank.repository.AccountRepository;
import org.hibernate.Session;

import java.util.List;

public class AccountRepositoryImpl extends BaseRepositoryImpl<Long, Account>
implements AccountRepository {
    public AccountRepositoryImpl(Class<Account> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Account> customerAccounts(Session session, String customerCode) {
        return session.createQuery("""
                        FROM Account a
                        Where a.owner.customerCode = :customerCode
                """, Account.class)
                .setParameter("customerCode", customerCode)
                .list();
    }
}
