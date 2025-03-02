package org.bank.repository.impl;

import org.bank.base.repository.BaseRepositoryImpl;
import org.bank.entity.Customer;
import org.bank.repository.CustomerRepository;
import org.hibernate.Session;

import java.util.Optional;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Long, Customer>
        implements CustomerRepository {
    public CustomerRepositoryImpl(Class<Customer> entityClass) {
        super(entityClass);
    }

    @Override
    public Optional<Customer> findByUsername(Session session, String username) {
        return session.createQuery("FROM Customer c WHERE c.username = :username"
                        , Customer.class)
                .setParameter("username", username)
                .uniqueResultOptional();
    }
}
