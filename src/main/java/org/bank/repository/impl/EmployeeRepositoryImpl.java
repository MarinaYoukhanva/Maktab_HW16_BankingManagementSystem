package org.bank.repository.impl;

import org.bank.base.repository.BaseRepositoryImpl;
import org.bank.entity.Employee;
import org.bank.repository.EmployeeRepository;
import org.hibernate.Session;

import java.util.Optional;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Long, Employee>
implements EmployeeRepository {
    public EmployeeRepositoryImpl(Class<Employee> entityClass) {
        super(entityClass);
    }

    @Override
    public Optional<Employee> findByUsername(Session session, String username) {
        return session.createQuery("FROM Employee e WHERE e.username = :username",
                Employee.class)
                .setParameter("username", username)
                .uniqueResultOptional();
    }
}
