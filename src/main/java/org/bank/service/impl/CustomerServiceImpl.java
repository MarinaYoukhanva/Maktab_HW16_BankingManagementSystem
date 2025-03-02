package org.bank.service.impl;

import org.bank.base.config.SessionFactoryInstance;
import org.bank.base.service.BaseServiceImpl;
import org.bank.entity.Customer;
import org.bank.exceptions.NotFoundException;
import org.bank.repository.CustomerRepository;
import org.bank.service.Authentication.CustomerAuthentication;
import org.bank.service.CustomerService;
import org.hibernate.Session;

public class CustomerServiceImpl extends BaseServiceImpl<Long, Customer, CustomerRepository>
implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);}


    @Override
    public void updateColumns(Customer entity, Customer foundEntity) {

    }

    @Override
    public Customer login(String username, String password) {
        try (Session session = SessionFactoryInstance.sessionFactory.openSession()){
            Customer foundCustomer = getRepository()
                    .findByUsername(session, username)
                    .orElseThrow(() -> new NotFoundException(Customer.class));
            if (!password.equals(foundCustomer.getPassword()))
                throw new NotFoundException(Customer.class);
            CustomerAuthentication.setLoggedInCustomer(foundCustomer);
            return foundCustomer;
        }
    }
}
