package org.bank.service;

import org.bank.base.service.BaseService;
import org.bank.entity.Account;
import org.bank.entity.Customer;
import org.hibernate.Session;

public interface AccountService extends BaseService<Long, Account> {
    Account create(Session session, Account.AccountDto dto);

    void createBankAccount(
            Customer.CustomerDto customerDto,
            Account.AccountDto accountDto);
}
