package dev.mohini.springjpahibernate.controller;

import dev.mohini.springjpahibernate.model.Employee;
import dev.mohini.springjpahibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping
    public List<Employee> get()
    {
        return  employeeService.get();
    }

    @PostMapping
    public Employee save(@RequestBody Employee employee)
    {
          employeeService.save(employee);
        return employee;
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee)
    {
        employeeService.save(employee);
        return employee;
    }

    @RequestMapping("/{id}")
    public Employee get(@PathVariable int id )
    {
        Employee employee=  employeeService.get(id);
        if(employee==null)
            throw new RuntimeException("Employee with id "+id+" not found");
        return employee;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id )
    {
        employeeService.delete(id);
        return "Employee with id "+id+" is deleted";
    }
}
