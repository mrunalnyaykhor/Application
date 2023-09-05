package com.tech.controller;

import com.tech.dto.EmployeeDto;
import com.tech.exception.EmployeeNotFoundException;
import com.tech.model.Employee;
import com.tech.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeservice;
    @RequestMapping("/employee")
    public String prelogin()
    {
        return "This is Employee Controller";
    }
    @PostMapping("/saveEmployee")
    public ResponseEntity<Employee> saveEmployeeData(@RequestBody @Valid EmployeeDto employee)
    {
        Employee emp = employeeservice.saveEmployee(employee);
        log.info("employee saved successfully");
        return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
    }
    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        List<Employee> employeelist= employeeservice.getAllEmployee();
        return  new ResponseEntity<>(employeelist,HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id)
    {
        Employee employee = employeeservice.getEmployeeById(id);

        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PutMapping("/updateEmployee/{id}")

     public Employee updateEmployee(@Valid @RequestBody Employee employee, @PathVariable("id") Long id)
    {
      return employeeservice.updateEmployee(employee, id);
    }

    @DeleteMapping({"employee/{id}"})
    public ResponseEntity<Employee> deleteTodo(@PathVariable("id") Long id) {
        employeeservice.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
