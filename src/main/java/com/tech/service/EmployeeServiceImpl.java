package com.tech.service;

import com.tech.dto.EmployeeDto;
import com.tech.exception.EmployeeNotFoundException;
import com.tech.model.Employee;
import com.tech.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeerepository;

    public Employee saveEmployee(EmployeeDto employee) {
        Employee employee1 = new Employee();
        BeanUtils.copyProperties(employee,employee1);
        Employee emp = employeerepository.save(employee1);
        return emp;
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeelist = employeerepository.findAll();
        return employeelist;
    }

    @Override
    public String deleteEmployee(Long id) {

        employeerepository.deleteById(id);
        return "Deleted Successfully.....!!" +id;

    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeerepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new EmployeeNotFoundException("id not exist");
        }
        return employeeOptional.get();

    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        Optional<Employee> employeeOptional = employeerepository.findById(id);
        if (employeeOptional.isEmpty()) {
            throw new EmployeeNotFoundException("id does not exist");
        }
        return employeerepository.save(employee);

    }


}
