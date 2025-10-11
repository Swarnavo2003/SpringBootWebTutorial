package com.projects.springbootwebtutorial.controllers;

import com.projects.springbootwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId) {
        return new EmployeeDTO(employeeId, "Swarnavo","swarnavo@gmail.com",22, LocalDate.of(2025,11,1), true);
    }

    @GetMapping()
    public String getAllEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy) {
        return "Hi age " + age + " " + sortBy;
    }
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
        inputEmployee.setId(100L);
        return inputEmployee;
    }

    @PutMapping
    public String updateEmployeeById() {
        return "Hello From Put";
    }
}
