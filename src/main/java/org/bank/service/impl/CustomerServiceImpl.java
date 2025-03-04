package org.bank.service.impl;

import org.bank.base.config.SessionFactoryInstance;
import org.bank.base.service.BaseServiceImpl;
import org.bank.entity.Customer;
import org.bank.entity.Customer_;
import org.bank.exceptions.NotFoundException;
import org.bank.repository.CustomerRepository;
import org.bank.service.CustomerService;
import org.bank.service.authentication.CustomerAuthentication;
import org.bank.service.fieldGenerator.RandomGenerator;
import org.bank.validations.UniqueFieldCheckable;
import org.bank.validations.UniquenessValidator;
import org.hibernate.Session;

import java.util.ArrayList;

public class CustomerServiceImpl extends BaseServiceImpl<Long, Customer, CustomerRepository>
implements CustomerService, UniqueFieldCheckable<Customer> {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);}


    @Override
    public void updateColumns(Customer entity, Customer foundEntity) {
        foundEntity.setFirstName(entity.getFirstName());
        foundEntity.setLastName(entity.getLastName());
        foundEntity.setPhoneNumber(entity.getPhoneNumber());
        foundEntity.setUsername(entity.getUsername());
        foundEntity.setPassword(entity.getPassword());
    }

    @Override
    public void checkUniqueFields(Session session, Customer entity) {
        UniquenessValidator.checkUniqueFieldOrThrowException(getRepository(),
                session, Customer.class, Customer_.customerCode, entity.getCustomerCode());
        UniquenessValidator.checkUniqueFieldOrThrowException(getRepository(),
                session, Customer.class, Customer_.username, entity.getUsername());
        UniquenessValidator.checkUniqueFieldOrThrowException(getRepository(),
                session, Customer.class, Customer_.nationalCode, entity.getNationalCode());
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

    @Override
    public Customer create(Session session, Customer.CustomerDto dto) {
        String firstname = dto.firstName();
        String lastname = dto.lastName();
        String nationalCode = dto.nationalCode();
        String phoneNumber = dto.phoneNumber();
        String customerCode = RandomGenerator.generateCustomerCode(session);
        String password = RandomGenerator.generateCustomerPassword(session);
        return new Customer(firstname, lastname,
                customerCode, password,
                customerCode, nationalCode, phoneNumber, new ArrayList<>());
    }


}
