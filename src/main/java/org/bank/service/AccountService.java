package org.bank.service;

import org.bank.base.service.BaseService;
import org.bank.entity.Account;
import org.bank.entity.Customer;
import org.bank.entity.dto.CreatedAccountInfoDto;
import org.hibernate.Session;

public interface AccountService extends BaseService<Long, Account> {
    Account create(Session session, Account.AccountDto dto);

    CreatedAccountInfoDto createBankAccount(
            Customer.CustomerDto customerDto,
            Account.AccountDto accountDto);
}
