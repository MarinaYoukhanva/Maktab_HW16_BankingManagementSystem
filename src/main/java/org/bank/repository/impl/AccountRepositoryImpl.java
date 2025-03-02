package org.bank.repository.impl;

import org.bank.base.repository.BaseRepositoryImpl;
import org.bank.entity.Account;
import org.bank.repository.AccountRepository;

public class AccountRepositoryImpl extends BaseRepositoryImpl<Long, Account>
implements AccountRepository {
    public AccountRepositoryImpl(Class<Account> entityClass) {
        super(entityClass);
    }
}
