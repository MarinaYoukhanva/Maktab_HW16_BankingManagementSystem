package org.bank.repository.impl;

import org.bank.entity.Customer;
import org.bank.entity.User;
import org.bank.repository.CustomerRepository;

public class CustomerRepositoryImpl extends UserRepositoryImpl<Customer>
        implements CustomerRepository {
    public CustomerRepositoryImpl(Class<Customer> entityClass) {
        super(entityClass);
    }
}
