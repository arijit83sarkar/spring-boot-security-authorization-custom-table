package com.raven.springbootsecurityauthorizationcustomtable.repository;

import com.raven.springbootsecurityauthorizationcustomtable.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
