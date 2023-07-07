package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
        EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeDto> listEmployees(Model model){
        List<EmployeeDto> employees = employeeService.findAllEmployees();
        return employees;
    }

    @PostMapping("/employees/new")
    public void saveEmployee(@RequestBody  EmployeeDto employeeDto){
      employeeService.saveEmployee(employeeDto);

    }

    @GetMapping("/employees/{employeeId}")
    public EmployeeDto employeeDetail(@PathVariable("employeeId") long employeeId) {
        EmployeeDto employee = employeeService.findEmployeeById(employeeId);
        return employee;
    }

    @PutMapping("/employees/{employeeId}")
    public EmployeeDto updateEmployee( @PathVariable("employeeId") Long id ,@RequestBody EmployeeDto employee){
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return employee;
    }


@DeleteMapping("/employees/{employeeId}")
public String deleteEmployee(@PathVariable("employeeId") Long id){
    EmployeeDto employee = employeeService.findEmployeeById(id);

    if(employee == null){
        throw new RuntimeException("Employee id not found : "+id);
    }
    employeeService.delete(id);
    return "deleted emp id - " +id;
}



}
