package org.bank.service;

import org.bank.base.service.BaseService;
import org.bank.entity.Customer;
import org.hibernate.Session;

public interface CustomerService extends BaseService<Long, Customer> {

    Customer login(String username, String password);

    Customer create(Session session, Customer.CustomerDto dto);

    void changeFirstPassword(Long customerId, String cardNum, String oldPassword,
                        String newPassword);

    void changeSecondPassword(Long customerId, String cardNum, String oldPassword,
                              String newPassword);
}
