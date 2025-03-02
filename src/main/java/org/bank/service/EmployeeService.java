package org.bank.service;

import org.bank.base.service.BaseService;
import org.bank.entity.Employee;

public interface EmployeeService extends BaseService<Long, Employee> {

    Employee login(String username, String password);
}
