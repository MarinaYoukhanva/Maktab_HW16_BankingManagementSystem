package org.bank.service.impl;

import org.bank.entity.Customer;
import org.bank.entity.User;
import org.bank.repository.CustomerRepository;
import org.bank.repository.UserRepository;
import org.bank.service.CustomerService;
import org.hibernate.Session;

public class CustomerServiceImpl extends UserServiceImpl<Customer, CustomerRepository>
        implements CustomerService{
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);}

    @Override
    public void updateColumns(Customer entity, Customer foundEntity) {

    }

    @Override
    public void infoLogicCheck(Session session, Customer entity) {

    }
}
