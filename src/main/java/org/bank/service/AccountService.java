package org.bank.service;

import org.bank.base.service.BaseService;
import org.bank.entity.Account;
import org.bank.entity.Customer;
import org.bank.entity.dto.CreatedAccountInfoDto;
import org.hibernate.Session;

import java.util.List;

public interface AccountService extends BaseService<Long, Account> {
    Account create(Session session, Account.AccountDto dto);

    CreatedAccountInfoDto createBankAccount(
            Customer.CustomerDto customerDto,
            Account.AccountDto accountDto);

    List<Account> viewCustomerAccounts(String customerCode);
}
