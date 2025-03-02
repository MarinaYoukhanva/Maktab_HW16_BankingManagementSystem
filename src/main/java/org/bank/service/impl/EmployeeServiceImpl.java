package org.bank.service.impl;

import org.bank.base.config.SessionFactoryInstance;
import org.bank.base.service.BaseServiceImpl;
import org.bank.entity.Employee;
import org.bank.exceptions.NotFoundException;
import org.bank.repository.EmployeeRepository;
import org.bank.service.Authentication.EmployeeAuthentication;
import org.bank.service.EmployeeService;
import org.hibernate.Session;

public class EmployeeServiceImpl extends BaseServiceImpl<Long, Employee, EmployeeRepository>
implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public void updateColumns(Employee entity, Employee foundEntity) {

    }

    @Override
    public Employee login(String username, String password) {
        try (Session session = SessionFactoryInstance.sessionFactory.openSession()){
            Employee foundEmployee = getRepository()
                    .findByUsername(session, username)
                    .orElseThrow(() -> new NotFoundException(Employee.class));
            if (!password.equals(foundEmployee.getPassword()))
                throw new NotFoundException(Employee.class);
            EmployeeAuthentication.setLoggedInEmployee(foundEmployee);
            return foundEmployee;
        }
    }
}
