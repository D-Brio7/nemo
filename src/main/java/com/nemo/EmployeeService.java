package com.nemo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
@Service
public class EmployeeService
{
    @Autowired
    EmployeeRepository employeeRepository;
    //getting all student records
    public List<Employee> getallemployees()
    {
        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }
    //getting a specific record
    public Employee getEmployeeById(int id)
    {
        return employeeRepository.findById(id).get();
    }
    public void saveOrUpdate(Employee employee)
    {
        employeeRepository.save(employee);
    }
    //deleting a specific record
    public void delete(int id)
    {
        employeeRepository.deleteById(id);
    }
}