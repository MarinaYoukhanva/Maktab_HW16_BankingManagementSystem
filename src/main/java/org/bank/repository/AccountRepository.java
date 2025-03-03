package org.bank.repository;

import org.bank.base.repository.BaseRepository;
import org.bank.entity.Account;
import org.hibernate.Session;

import java.util.List;

public interface AccountRepository extends BaseRepository<Long, Account> {
    List<Account> customerAccounts(Session session, String customerCode);
}
