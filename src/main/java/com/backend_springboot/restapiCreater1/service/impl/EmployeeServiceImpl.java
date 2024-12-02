package com.backend_springboot.restapiCreater1.service.impl;

import com.backend_springboot.restapiCreater1.exception.ResourceNotFoundEnceptions;
import com.backend_springboot.restapiCreater1.model.Employee;
import com.backend_springboot.restapiCreater1.repository.EmployeeRepository;
import com.backend_springboot.restapiCreater1.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee>employee = employeeRepository.findById(id);

        if(employee.isPresent()){
            return employee.get();
        }else {
            throw  new ResourceNotFoundEnceptions("Employee","Id",id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
     // check employee with given id is present or not
     Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundEnceptions("employee","Id",id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        // save to database

        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundEnceptions("Employee","Id",id));
        employeeRepository.deleteById(id);
    }
}
