package org.bank.repository;

import org.bank.base.repository.BaseRepository;
import org.bank.entity.Customer;
import org.hibernate.Session;

import java.util.Optional;

public interface CustomerRepository extends BaseRepository<Long, Customer> {
    Optional<Customer> findByUsername(Session session, String username);
    Customer customerWithAccounts(Session session, String customerCode);

    Optional<Customer> findByNationalCode(Session session, String nationalCode);
}
