package com.codeclan.example.employeesprojectsservice.repostitories;

import com.codeclan.example.employeesprojectsservice.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
