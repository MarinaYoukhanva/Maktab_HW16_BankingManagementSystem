package org.bank.repository;

import org.bank.base.repository.BaseRepository;
import org.bank.entity.Employee;
import org.hibernate.Session;

import java.util.Optional;

public interface EmployeeRepository extends BaseRepository<Long, Employee> {

    Optional<Employee> findByUsername(Session session, String username);
}
