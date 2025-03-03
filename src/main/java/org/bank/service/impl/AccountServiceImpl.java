package org.bank.service.impl;

import org.bank.base.service.BaseServiceImpl;
import org.bank.entity.Account;
import org.bank.repository.AccountRepository;
import org.bank.service.AccountService;

public class AccountServiceImpl extends BaseServiceImpl<Long, Account, AccountRepository>
implements AccountService {
    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

    @Override
    public void updateColumns(Account entity, Account foundEntity) {

    }

    public void createBankAccount(){}
}
