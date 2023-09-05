package com.tech.service;

import com.tech.dto.EmployeeDto;
import com.tech.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(EmployeeDto employee);

   public List<Employee> getAllEmployee();

   public String deleteEmployee(Long id);


   public Employee updateEmployee(Employee employee, Long id);

    public Employee getEmployeeById(Long id);
}
