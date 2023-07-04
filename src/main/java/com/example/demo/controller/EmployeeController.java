package com.example.demo.controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
        EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String listEmployees(Model model){
        List<EmployeeDto> employees = employeeService.findAllEmployees();
        model.addAttribute("employees",employees);
        return "employees-list";
    }
    @GetMapping("/employees/search")
    public String searchEmployees(@RequestParam(value = "query") String query, Model model){
        List<EmployeeDto> employees = employeeService.searchEmployees(query);
        model.addAttribute("employees",employees);
        return "employees-list";
    }

    @GetMapping("/employees/new")
    public String createEmployees(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employees-create";
    }
    @PostMapping("/employees/new")
    public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeDto employeeDto, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("employee",employeeDto);
            return "employees-create";
        }
        employeeService.saveEmployee(employeeDto);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{employeeId}")
    public String employeeDetail(@PathVariable("employeeId") long employeeId, Model model) {
        EmployeeDto employeeDto = employeeService.findEmployeeById(employeeId);
        model.addAttribute("employee", employeeDto);
        return "employees-detail";
    }

    @GetMapping("employees/{employeeId}/edit")
    public String editEmployeeForm(@PathVariable("employeeId") Long employeeId, Model model ){
        EmployeeDto employeeDto = employeeService.findEmployeeById(employeeId);
        model.addAttribute("employee",employeeDto);
        return "employees-edit";
    }
    @PostMapping("/employees/{employeeId}/edit")
    public String updateEmployee(@PathVariable("employeeId") Long employeeId, @Valid @ModelAttribute("employee") EmployeeDto employeeDto, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("employee",employeeDto);
            return "employees-edit";
        }
        employeeDto.setId(employeeId);
        employeeService.updateEmployee(employeeDto);
        return "redirect:/employees";
    }
    @GetMapping("/employees/{employeeId}/delete")
    public String deleteEmployee(@PathVariable("employeeId") Long employeeId, Model model){
        EmployeeDto employeeDto = employeeService.findEmployeeById(employeeId);
        model.addAttribute("employee", employeeDto);
        return "employees-delete";
    }
    @GetMapping("/employees/{employeeId}/delete/confirm")
    public String deleteEmployeeConfirm(@PathVariable("employeeId") Long employeeId, Model model){

        employeeService.delete(employeeId);
        return "redirect:/employees";
    }



}
