package com.nemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//creating RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1")
@RestController
public class EmployeeController
{
    //autowired the StudentService class
    @Autowired
    private EmployeeRepository repo;

    @CrossOrigin
    @GetMapping("/employees")
    public List<Employee>  getAllEmployee() {
        System.out.println(repo.findAll());
        return (List<Employee>) repo.findAll();
    }

    @CrossOrigin
    @PostMapping("/insertemployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        return repo.save(employee);
    }


    @CrossOrigin
    @GetMapping("/employee/{id}")
    public ResponseEntity<Optional<Employee>>  getEmployeeById(@PathVariable int id)  {

        Optional<Employee> employee = repo.findById(id);
        return ResponseEntity.ok(employee);
    }


    @CrossOrigin
    @PutMapping("/updateemployee/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employeeDetails){
        Employee employee = repo.findById(id).orElseThrow();

        employee.setFirstname(employeeDetails.getFirstname());
        employee.setLastname(employeeDetails.getLastname());
        employee.setEmail(employeeDetails.getEmail());

        Employee updatedEmployee = repo.save(employee);
        return (updatedEmployee);

    }

    @CrossOrigin
    @DeleteMapping("/deleteemployee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id){
        Employee employee = repo.findById(id).orElseThrow();
        repo.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }
}

