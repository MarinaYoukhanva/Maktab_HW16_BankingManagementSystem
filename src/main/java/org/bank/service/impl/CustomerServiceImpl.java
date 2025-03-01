package org.bank.service.impl;

import org.bank.entity.Customer;
import org.bank.repository.CustomerRepository;
import org.bank.service.CustomerService;

public class CustomerServiceImpl extends UserServiceImpl<Customer, CustomerRepository>
        implements CustomerService{
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);}

    @Override
    public void updateColumns(Customer entity, Customer foundEntity) {

    }

}
