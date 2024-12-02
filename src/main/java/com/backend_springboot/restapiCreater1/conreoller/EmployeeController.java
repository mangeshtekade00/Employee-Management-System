package com.backend_springboot.restapiCreater1.conreoller;

import com.backend_springboot.restapiCreater1.model.Employee;
import com.backend_springboot.restapiCreater1.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
// build create employee rest api
@PostMapping()
    public ResponseEntity<Employee>saveEmployee(@RequestBody Employee employee){
        return  new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // to get all employee rest api
@GetMapping
    public List<Employee>getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // build get employee by id rest api
    //http://localhost:8080/api/employees/4
    @GetMapping("{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable("id") long employeeId){

        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }


    // update employee rest api
    //http://localhost:8080/api/employees/4
    @PutMapping("{id}")
public  ResponseEntity<Employee>updateEmployeeById(@PathVariable("id") long employeeId,@RequestBody Employee employee){

        return   new ResponseEntity<Employee>(employeeService.updateEmployee(employee,employeeId),HttpStatus.OK);
}


// Build delete employee rest api
    //http://localhost:8080/api/employees/4
    @DeleteMapping("{id}")
    public  ResponseEntity<String>deleteEmployee(@PathVariable("id") long id){
        //delete from db
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee delete successfully",HttpStatus.OK);
    }


}
